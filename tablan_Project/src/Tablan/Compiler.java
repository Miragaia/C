package Tablan;

import java.io.File;
import java.lang.reflect.UndeclaredThrowableException;

import org.stringtemplate.v4.*;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import static java.util.Map.entry;    
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@SuppressWarnings("CheckReturnValue")
public class Compiler extends TablanBaseVisitor<ST> {
   STGroup templates = new STGroupFile("Tablan/stringtemplates.stg");
   int formulaCounter = 0;
   Map<String, String> declaredVars = new HashMap<String, String>();
   ArrayList<String> declaredUserTypes = new ArrayList<>();
   Map<String, Boolean> isVarAssigned = new HashMap<String, Boolean>();
   Set<String> librariesAddedSet = new HashSet<String>();

   Map<String, String> typeValue = Map.ofEntries(
      entry("integer","IntegerType"),
      entry("real","RealType"),
      entry("text","TextType"),
      entry("boolean","BooleanType"),
      entry("table","TableType")
   );

   ST output;

   private static enum SYNCLASS {
      TYPE,
      VAR,
   };

   private static String getMappedName(String name, SYNCLASS synclass) throws RuntimeException {
      String varPrefix = "tabVar_";
      String typePrefix = "tabType_";

      switch (synclass) {
         case VAR:
            return varPrefix + name;
         case TYPE:
            return typePrefix + name;
         default:
            String msg = String.format("INTERNAL COMPILER ERROR! Unknown syntatic class when trying to map name %s.", name);
            throw new RuntimeException(msg);
      }
   }

   @Override public ST visitProgram(TablanParser.ProgramContext ctx) {
           //  Get instanceia do inicio do programa
        output = templates.getInstanceOf("program");

        //  Visita todos os filhos
        visitChildren(ctx);

        //  Dá print ao programa na nova linguagem (compilado)
        return output;
   }

   @Override public ST visitStat(TablanParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitDeclaration(TablanParser.DeclarationContext ctx) {
      //  Variable to declare is a defined type
      String rawType = ctx.typeName.getText();
      String type = rawType;

      if (!typeValue.containsKey(rawType)) {
         type = getMappedName(rawType, SYNCLASS.TYPE);

         if (!declaredUserTypes.contains(type)) {
            var vars = ctx.idList().ID();
            String v = !vars.isEmpty() ? vars.get(0).getText() : "null";
            String msg = String.format(
               "ERROR! Type '%s' was undefined (when declaring variable '%s').",
               rawType, v);
            throw new RuntimeException(msg, null);
         }
      }
      
      //String type = (ctx.typeName.getText());
      for (TerminalNode idNode : ctx.idList().ID()) {
         String rawVarName = idNode.getText();
         String varName = getMappedName(rawVarName, SYNCLASS.VAR);

         declaredVars.put(varName, type);
         isVarAssigned.put(varName, false);
         ST var_decl = templates.getInstanceOf("var_declaration");
         var_decl.add("name", varName);
         var_decl.add("type", type);
         output.add("variables", var_decl);
      }

      return null;
   }

   @Override public ST visitAssignValue(TablanParser.AssignValueContext ctx) throws RuntimeException{
      String rawVarName = ctx.varName.getText();
      String varName = getMappedName(rawVarName, SYNCLASS.VAR);
      if (declaredVars.get(varName) == null) {
         String msg = String.format("ERROR! Tried to assign a value to undefined variable \"%s\"!", varName);
         throw new RuntimeException(msg);
      }
      
      if (!isVarAssigned.get(varName)) {
         ST var_decl = templates.getInstanceOf("var_set_new_type");
         var_decl.add("name", varName);
         var_decl.add("type", declaredVars.get(varName));
         output.add("instructions", var_decl);
         isVarAssigned.put(varName, true);
      }

      ST var_set = templates.getInstanceOf("var_set");
      var_set.add("name", varName);
      var_set.add("expr", visit(ctx.exprData()));
      output.add("instructions", var_set);

      return null;
   }

   @Override public ST visitAssignNewRow(TablanParser.AssignNewRowContext ctx) throws RuntimeException {
      String rawVarName = ctx.varName.getText();
      String varName = getMappedName(rawVarName, SYNCLASS.VAR);
      
      ST var_set;

      if (ctx.rowName == null) {
         var_set = templates.getInstanceOf("var_set_new_class");
         var_set.add("name", varName);
         var_set.add("class", declaredVars.get(varName));
         isVarAssigned.put(varName, true);
      }
      else {

         if (!isVarAssigned.get(varName)) {
            ST var_decl = templates.getInstanceOf("var_set_new_class");
            var_decl.add("name", varName);
            var_decl.add("class", declaredVars.get(varName));
            output.add("instructions", var_decl);
            isVarAssigned.put(varName, true);
         }
      
         var_set = templates.getInstanceOf("var_copy_col");
         var_set.add("name", varName);
         var_set.add("colName", ctx.rowName.getText());

         if (ctx.tableName != null) {
            String rawTableName = ctx.tableName.getText();
            String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
            if (declaredVars.get(tableName) == null) {
               throw new RuntimeException(String.format("ERROR! Tried to access undefined table \"%s\"!", tableName));
            }
            var_set.add("tableName", tableName);
         }
      }
      
      output.add("instructions", var_set);

      return null;
   }


   @Override public ST visitAssignReadRow(TablanParser.AssignReadRowContext ctx) throws RuntimeException {
      String rawVarName = ctx.varName.getText();
      String varName = getMappedName(rawVarName, SYNCLASS.VAR);

      String fileSpecified = ctx.fileName.getText();
      String fileName = "../" + fileSpecified.substring(1, fileSpecified.length() - 1);
      File file = new File(fileSpecified);

      if (declaredVars.get(varName) == null) {
         throw new RuntimeException("ERROR! Tried to give a value to an undefined Variable!");
      }

      if (file.exists() || file.isDirectory()) {
         throw new RuntimeException("ERROR! File specified doesn't exist or is a directory!");
      }

      if (!isVarAssigned.get(varName)) {
         ST var_decl = templates.getInstanceOf("var_set_new_type");
         var_decl.add("name", varName);
         var_decl.add("type", declaredVars.get(varName));
         output.add("instructions", var_decl);
         isVarAssigned.put(varName, true);
      }

      //  First column number and name where specified
      if (ctx.colNumI != null && ctx.colNameI != null) {

         String colNum = ctx.colNumI.getText();
         String colName = ctx.colNameI.getText();

         ST readColFile = templates.getInstanceOf("var_read_file_col_number");
         readColFile.add("name", varName);
         readColFile.add("fileName", fileName);
         readColFile.add("fileCol", colNum);
         readColFile.add("colName", colName);
         output.add("instructions", readColFile);

         for (int i = 0; i < ctx.colNum.size(); i++) {
            String adiColNum = ctx.colNum.get(i).getText();
            String adiColName = ctx.colName.get(i).getText();

            readColFile = templates.getInstanceOf("var_read_file_col_number");
            readColFile.add("name", varName);
            readColFile.add("fileName", fileName);
            readColFile.add("fileCol", adiColNum);
            readColFile.add("colName", adiColName);
            output.add("instructions", readColFile);
         }
      }
      else {
         ST loadFile = templates.getInstanceOf("var_load_file");
         loadFile.add("name", varName);
         loadFile.add("fileName", fileName);
         output.add("instructions", loadFile);

      }

      return null;
   }

   @Override public ST visitAssignReadFile(TablanParser.AssignReadFileContext ctx) throws RuntimeException {
      String rawVarName = ctx.varName.getText();
      String varName = getMappedName(rawVarName, SYNCLASS.VAR);

      String fileSpecified = ctx.fileName.getText();
      String fileName = "../" + fileSpecified.substring(1, fileSpecified.length() - 1);
      File file = new File(fileSpecified);

      if (declaredVars.get(varName) == null) {
         throw new RuntimeException("ERROR! Tried to give a value to an undefined Variable!");
      }

      if (file.exists() || file.isDirectory()) {
         throw new RuntimeException("ERROR! File specified doesn't exist or is a directory!");
      }

      if (!isVarAssigned.get(varName)) {
         ST var_decl = templates.getInstanceOf("var_set_new_type");
         var_decl.add("name", varName);
         var_decl.add("type", declaredVars.get(varName));
         output.add("instructions", var_decl);
         isVarAssigned.put(varName, true);
      }

      String colNum = ctx.fileColNameI.getText();
      String colName = ctx.colNameI.getText();

      //  First column number and name where specified
      if (colNum != null && colName != null) {

         ST readColFile = templates.getInstanceOf("var_read_file_col_name");
         readColFile.add("name", varName);
         readColFile.add("fileName", fileName);
         readColFile.add("fileColName", colNum);
         readColFile.add("colName", colName);
         output.add("instructions", readColFile);

         for (int i = 0; i < ctx.fileColName.size(); i++) {
            String adiColNum = ctx.fileColName.get(i).getText();
            String adiColName = ctx.colName.get(i).getText();

            readColFile = templates.getInstanceOf("var_read_file_col_name");
            readColFile.add("name", varName);
            readColFile.add("fileName", fileName);
            readColFile.add("fileColName", adiColNum);
            readColFile.add("colName", adiColName);
            output.add("instructions", readColFile);
         }
      }
      else {
         ST loadFile = templates.getInstanceOf("var_load_file");
         loadFile.add("name", varName);
         loadFile.add("fileName", fileName);
         output.add("instructions", loadFile);

      }

      return null;
   }

   @Override public ST visitAssignNormalValue(TablanParser.AssignNormalValueContext ctx) {
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
      String rowName = ctx.rowName.getText();

      if (declaredVars.get(tableName) == null) {
         throw new RuntimeException("ERROR! Tried to give a value to an undefined Table! Table Name > " + tableName);
      }
      
      ST assignVal = templates.getInstanceOf("var_assign_to_col");
      assignVal.add("tableName", tableName);
      assignVal.add("colName", rowName);
      assignVal.add("value", visit(ctx.exprData()));
      output.add("instructions", assignVal);

      return null;
   }

   @Override public ST visitAssignColRowValue(TablanParser.AssignColRowValueContext ctx) {
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
      String rowName = ctx.rowName.getText();

      String rawOGtableName = ctx.oldTableName.getText();
      String OGtableName = getMappedName(rawOGtableName, SYNCLASS.VAR);
      String OGcolName = ctx.oldRowName.getText();

      if (declaredVars.get(tableName) == null) {
         throw new RuntimeException("ERROR! Tried to give a value to an undefined Table!");
      }

      if (!isVarAssigned.get(tableName)) {
         ST var_decl = templates.getInstanceOf("var_set_new_class");
         var_decl.add("name", tableName);
         var_decl.add("vlass", declaredVars.get(tableName));
         output.add("instructions", var_decl);
      }
      
      isVarAssigned.put(tableName, true);
      ST assignVal = templates.getInstanceOf("var_copy_col_to_col");
      assignVal.add("tableName", tableName);
      assignVal.add("colName", rowName);
      assignVal.add("OGtableName", OGtableName);
      assignVal.add("OGcolName", OGcolName);
      output.add("instructions", assignVal);

      return null;
   }

   @Override public ST visitAssignTableRowValue(TablanParser.AssignTableRowValueContext ctx) {
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);

      String rawOGtableName = ctx.oldTableName.getText();
      String OGtableName = getMappedName(rawOGtableName, SYNCLASS.VAR);
      String OGcolName = ctx.oldRowName.getText();

      if (declaredVars.get(tableName) == null) {
         throw new RuntimeException("ERROR! Tried to give a value to an undefined Table! " + tableName);
      }

      if (!isVarAssigned.get(tableName)) {
         ST var_decl = templates.getInstanceOf("var_set_new_class");
         var_decl.add("name", tableName);
         var_decl.add("class", declaredVars.get(tableName));
         output.add("instructions", var_decl);
      }
      
      isVarAssigned.put(tableName, true);
      ST assignVal = templates.getInstanceOf("var_copy_col_to_table");
      assignVal.add("tableName", tableName);
      assignVal.add("OGtableName", OGtableName);
      assignVal.add("OGcolName", OGcolName);
      output.add("instructions", assignVal);

      return null;
   }

   @Override public ST visitIdList(TablanParser.IdListContext ctx) {
      return null;
   }

   @Override public ST visitType(TablanParser.TypeContext ctx) {
      return null;
   }

   @Override public ST visitExprUnNeg(TablanParser.ExprUnNegContext ctx) {
      ST res = visit(ctx.e);
      ST minus = templates.getInstanceOf("minus");
      minus.add("a", res);
   
      return minus;
   }
   
   @Override public ST visitExprUnPos(TablanParser.ExprUnPosContext ctx) {
      ST res = visit(ctx.e);
      return res;
   }

   @Override public ST visitExprParent(TablanParser.ExprParentContext ctx) {
      ST res = visit(ctx.e);
      return res;
   }

   @Override public ST visitExprTableRowLength(TablanParser.ExprTableRowLengthContext ctx) {
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
      String colName = ctx.rowName.getText();
      ST length = templates.getInstanceOf("table_length");
      length.add("tableName", tableName);
      length.add("colName", colName);
   
      return length;
   }
   
   @Override public ST visitExprTableRow(TablanParser.ExprTableRowContext ctx) {
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
      String colName = ctx.rowName.getText();
      ST colVal = templates.getInstanceOf("get_col_value");
      colVal.add("tableName", tableName);
      colVal.add("colName", colName);
   
      return colVal;
   }

   @Override public ST visitExprToInt(TablanParser.ExprToIntContext ctx) {
      ST varName = visit(ctx.e);
      if (ctx.eType == "Scanner")
         new ST(getMappedName(varName.toString(), SYNCLASS.VAR));
      ST toInt = templates.getInstanceOf("toInteger");
      toInt.add("a", varName);
   
      return toInt;
   }

   @Override public ST visitExprToText(TablanParser.ExprToTextContext ctx) {
      ST varName = visit(ctx.e);
      if (ctx.eType == "Scanner")
         new ST(getMappedName(varName.toString(), SYNCLASS.VAR));
      ST toText = templates.getInstanceOf("toText");
      toText.add("a", varName);
   
      return toText;
   }

   @Override public ST visitExprToReal(TablanParser.ExprToRealContext ctx) {
      ST varName = visit(ctx.e);
      if (ctx.eType == "Scanner")
         new ST(getMappedName(varName.toString(), SYNCLASS.VAR));
      ST toReal = templates.getInstanceOf("toReal");
      toReal.add("a", varName);
   
      return toReal;
   }

   @Override public ST visitExprAddSub(TablanParser.ExprAddSubContext ctx) {
      String a = visit(ctx.e1).render();
      String b = visit(ctx.e2).render();
      ST bin_op;

      if (ctx.op.getText().equals("+")) {
         bin_op = templates.getInstanceOf("sum");
      }
      else {
         bin_op = templates.getInstanceOf("sub");
      }

      bin_op.add("a", a);
      bin_op.add("b", b);
  
      return bin_op;
   }

   @Override public ST visitExprInteger(TablanParser.ExprIntegerContext ctx) {
      ST res = templates.getInstanceOf("integer");
      res.add("varName", ctx.INTEGER().getText());

      return res;
   }

   @Override public ST visitExprReal(TablanParser.ExprRealContext ctx) {
      ST res = templates.getInstanceOf("real");
      res.add("varName", ctx.REAL().getText());

      return res;
   }

   @Override public ST visitExprBoolean(TablanParser.ExprBooleanContext ctx) {
      ST res = templates.getInstanceOf("boolean");
      res.add("varName", ctx.BOOLEAN().getText());

      return res;
   }

   @Override public ST visitExprComparison(TablanParser.ExprComparisonContext ctx) {
      ST bin_op = templates.getInstanceOf("isEqual");
      bin_op.add("a", visit(ctx.e1).render());
      bin_op.add("b", visit(ctx.e2).render());


      return bin_op;
   }

   @Override public ST visitExprCompHighLow(TablanParser.ExprCompHighLowContext ctx) {
      String a = visit(ctx.e1).render();
      String b = visit(ctx.e2).render();
      ST bin_op;

      if (ctx.op.getText().equals(">")) {
         bin_op = templates.getInstanceOf("higher");
      }
      else {
         bin_op = templates.getInstanceOf("lower");
      }

      bin_op.add("a", a);
      bin_op.add("b", b);
  
      return bin_op;
   }

   @Override public ST visitExprCompHighLowEquals(TablanParser.ExprCompHighLowEqualsContext ctx) {
      String a = visit(ctx.e1).render();
      String b = visit(ctx.e2).render();
      ST bin_op;

      if (ctx.op.getText().equals(">=")) {
         bin_op = templates.getInstanceOf("higher_equal");
      }
      else {
         bin_op = templates.getInstanceOf("lower_equal");
      }

      bin_op.add("a", a);
      bin_op.add("b", b);
  
      return bin_op;
   }

   @Override public ST visitConditional(TablanParser.ConditionalContext ctx) {
      ST start_if = templates.getInstanceOf("start_if");
      start_if.add("condition", visit(ctx.exprData()).render());
   
      output.add("instructions", start_if); 

      for (TablanParser.StatContext forLoopInstruction :  ctx.trueSL) {
         output.add("instructions", templates.getInstanceOf("indentation")); 
         visit(forLoopInstruction);
      }

      ST end_loop = templates.getInstanceOf("end_for_loop");
      output.add("instructions", end_loop); 
      if (ctx.falseSL != null) {
         ST start_else = templates.getInstanceOf("start_else");
         output.add("instructions", start_else); 
   
         for (TablanParser.StatContext forLoopInstruction :  ctx.falseSL) {
            output.add("instructions", templates.getInstanceOf("indentation")); 
            visit(forLoopInstruction);
         }
   
         output.add("instructions", end_loop); 
      }

      return null;
   }

   @Override public ST visitExprText(TablanParser.ExprTextContext ctx) {
      ST res = templates.getInstanceOf("text");
      res.add("varName", ctx.TEXT().getText());

      return res;
   }

   @Override public ST visitExprTable(TablanParser.ExprTableContext ctx) {
      ST rawTableName = visit(ctx.table());
      ST tableName = new ST(getMappedName(rawTableName.toString(), SYNCLASS.TYPE));

      ST res = templates.getInstanceOf("instanciate_t_class");
      res.add("tableClassName", tableName);

      return res;
   }

   @Override public ST visitExprReadStdIn(TablanParser.ExprReadStdInContext ctx) {
      if (!librariesAddedSet.contains("Scanner")) {
         ST importLib = templates.getInstanceOf("importLibrary");
         importLib.add("libName", "java.util.Scanner");
         librariesAddedSet.add("Scanner");
         output.add("imports", importLib);

         ST instanciateUtil = templates.getInstanceOf("instanciate_util_class");
         instanciateUtil.add("utilName", "Scanner");
         instanciateUtil.add("varName", "scanner");
         instanciateUtil.add("utilArgs", "System.in");
         output.add("variables", instanciateUtil);
      }
      ST read = templates.getInstanceOf("use_util");
      read.add("utilName", "scanner");
      read.add("function", "nextLine");
      return read;
   }

   @Override public ST visitExprMultDiv(TablanParser.ExprMultDivContext ctx) {
      ST a = visit(ctx.e1);
      ST b = visit(ctx.e2);
      ST bin_op;

      if (ctx.op.getText().equals("*")) {
         bin_op = templates.getInstanceOf("mul");
      }
      else {
         bin_op = templates.getInstanceOf("div");
      }

      bin_op.add("a", a);
      bin_op.add("b", b);
            
      return bin_op;
   }


   @Override public ST visitExprID(TablanParser.ExprIDContext ctx) {
      ST res = templates.getInstanceOf("variable");
      res.add("name", getMappedName(ctx.ID().getText(), SYNCLASS.VAR));

      return res;
   }

   @Override public ST visitExprError(TablanParser.ExprErrorContext ctx) {
      ST res = templates.getInstanceOf("checkError");

      return res;
   }

   @Override public ST visitTable(TablanParser.TableContext ctx) {


      //  Defining the main header of the table
      if (ctx.rowName == null) {
         String rawTableName = ctx.tableNome.getText();
         String tableName = getMappedName(rawTableName, SYNCLASS.VAR);

         String newHeader = ctx.rowHeader.getText();

         if (!isVarAssigned.get(tableName)) {
            ST var_set = templates.getInstanceOf("var_set_new_class");
            var_set.add("name", tableName);
            var_set.add("class", declaredVars.get(tableName));
            output.add("instructions", var_set);
            isVarAssigned.put(tableName, true);
         }
         
         ST tableHeader = templates.getInstanceOf("table_set_main_header");
         tableHeader.add("tableName", tableName);
         tableHeader.add("newHeader", newHeader);
         output.add("instructions", tableHeader);
         return new ST(rawTableName);
      }
      //  Defining the type and header of a column TODO how do I chose which table it is?
      else {
         String colName = ctx.rowName.getText();
         String colType = ctx.rowType.getText();
         ST columnType = templates.getInstanceOf("table_set_col_type");
         columnType.add("colName", colName);
         columnType.add("type", colType);
         output.add("instructions", columnType);

         if ( ctx.rowHeader != null) {
            ST columnHeader = templates.getInstanceOf("table_set_col_header");
            columnHeader.add("colName", colName);
            columnHeader.add("colHeader", ctx.rowHeader.getText());
            output.add("instructions", columnHeader);
         }
      }

      return null;
   }

   @Override public ST visitTableOpAddLine(TablanParser.TableOpAddLineContext ctx) {    
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);

      if (declaredVars.get(tableName) == null) {
         String msg = String.format("ERROR! Tried to give a value to undefined table \"%s\"!", tableName);
         throw new RuntimeException(msg);
      }

      ST addRow = templates.getInstanceOf("table_add_row");
      
      if (ctx.exprData().size() != 0) {
         ST val = visit(ctx.exprData().get(0));
         String type = ctx.exprData().get(0).eType;
         if (type == null) {
            addRow.add("valueArray", val.render() + ".copyType()");
         }
         else {
            addRow.add("valueArray", "new " + type + "(" + val.render() + ")");
         }

         for (int i = 1; i < ctx.exprData().size(); i++) {
            val = visit(ctx.exprData().get(i));
            type = ctx.exprData().get(i).eType;
            // ctx.expr().eType.name()
            if (type == null) {
               addRow.add("valueArray", ", " + val.render() + ".copyType()");
            }
            else{
               addRow.add("valueArray", ", " + "new " + type + "(" + val.render() + ")");
            }
         }
      }

      addRow.add("tableName", tableName);
      output.add("instructions", addRow);

      return null;
   }

   @Override public ST visitTableOpNewRenameCol(TablanParser.TableOpNewRenameColContext ctx) {
      ST addCol = templates.getInstanceOf("table_set_col_header");
      String rawTableName = ctx.rowName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
      String colName = ctx.rowType.getText();
      String colHeader = ctx.rowHeader.getText();

      addCol.add("tableName", tableName);
      addCol.add("colName", colName);
      addCol.add("colHeader", colHeader);
      output.add("instructions", addCol);

      return null;
   }

   @Override public ST visitTableOpNewCol(TablanParser.TableOpNewColContext ctx) {
      ST addCol = templates.getInstanceOf("table_add_col");
      String colName = ctx.rowName.getText();
      String colType = ctx.rowType.getText();

      addCol.add("colName", colName);
      addCol.add("colType", colType);
      output.add("instructions", addCol);

      return null;
   }
   
   @Override public ST visitPrintError(TablanParser.PrintErrorContext ctx) {
      String val;
      ST print_error = templates.getInstanceOf("print_error");
      output.add("instructions", print_error);

      return null;
   }

   @Override public ST visitPrintExpr(TablanParser.PrintExprContext ctx) {
      String val;
      ST print_expr = templates.getInstanceOf("print_expr");
      
      val = visit(ctx.valsI).render();
      print_expr.add("expr", val);
      
      for (int i = 1; i <= ctx.vals.size(); i++) {
         val = visit(ctx.exprData().get(i)).render();
         print_expr.add("expr", " + " + val);
      }

      if (ctx.size != null) {
         String size = visit(ctx.size).render();
         print_expr.add("center", size);
      }

      output.add("instructions", print_expr);

      return null;
   }
   
   @Override public ST visitPrintLnExpr(TablanParser.PrintLnExprContext ctx) {
      String val;
      ST print_expr = templates.getInstanceOf("println_expr");
      
      val = visit(ctx.valsI).render();
      print_expr.add("expr", val);
      
      for (int i = 1; i <= ctx.vals.size(); i++) {
         val = visit(ctx.exprData().get(i)).render();
         print_expr.add("expr", " + " + val);
      }

      if (ctx.size != null) {
         String size = visit(ctx.size).render();
         print_expr.add("center", size);
      }

      output.add("instructions", print_expr);

      return null;
   }

   @Override public ST visitDefineTableMain(TablanParser.DefineTableMainContext ctx) throws RuntimeException {
      String rawTableName = ctx.tableName.getText();
      String tableName = getMappedName(rawTableName, SYNCLASS.TYPE);

      if (declaredUserTypes.contains(tableName)) {
         String msg = String.format("ERROR! Custom type '%s' was already defined.", rawTableName);
         throw new RuntimeException(msg);
      }

      if (!librariesAddedSet.contains("HashMap")) {
         ST importLib = templates.getInstanceOf("importLibrary");
         importLib.add("libName", "java.util.HashMap");
         librariesAddedSet.add("HashMap");
         output.add("imports", importLib);
      }
      if (!librariesAddedSet.contains("ArrayList")) {
         ST importLib = templates.getInstanceOf("importLibrary");
         importLib.add("libName", "java.util.ArrayList");
         librariesAddedSet.add("ArrayList");
         output.add("imports", importLib);
      }

      ST t_class = templates.getInstanceOf("make_t_class");
      
      if (ctx.tableHeader != null) {
         t_class.add("tableHeader", ctx.tableHeader.getText());
      }

      List<String> formulaNames = new ArrayList<String>();

      for (TablanParser.DefineColumnContext tableInstruction :  ctx.defineColumn()) {

         ST t_col = templates.getInstanceOf("make_t_column");
         String colName = tableInstruction.columnName.getText();
   
         t_col.add("colType", tableInstruction.colType.getText());   
         if (tableInstruction.exprData() != null) { 
         }
         if (tableInstruction.colHeader != null) {
            t_col.add("colHeader", tableInstruction.colHeader.getText());         
         }
         else {
            t_col.add("colHeader", "null");  
         }
   
         t_col.add("colName", colName);

         t_class.add("tableInstructions", t_col);

         declaredVars.put(tableName + "." + colName, tableInstruction.colType.getText());
         isVarAssigned.put(tableName + "." + colName, true);
         
         //  Table col is a formula
         if (tableInstruction.exprData() != null) {
            //  Get the formula
            String formula = tableInstruction.exprData().getText();
            String formulaType = tableInstruction.colType.getText();
            String formulaName = "formulaNum" + formulaCounter;
            formulaNames.add(formulaName);
            ST t_form = templates.getInstanceOf("make_t_formula");
            t_form.add("colFormula", visit(tableInstruction.exprData()).render());     
            t_form.add("colType", formulaType);      
            t_form.add("colFormulaName", formulaName);  

            ArrayList<String> varList = new ArrayList<String>();

            //  Extract the variable names from the formula
            Pattern p = Pattern.compile("[a-zA-Z_][a-zA-Z_0-9]*");
            Matcher m = p.matcher(formula);
            while (m.find()) {
               varList.add(m.group());
            }

            String formulaString;
            String seeIfNullString;

            for (String formulaArg : varList) {
               String argType = declaredVars.get(tableName + "." + formulaArg);
               String colType = typeValue.get(argType);
               String mappedArg = getMappedName(formulaArg, SYNCLASS.VAR);

               formulaString = colType+" "+mappedArg+" = ("+colType+")this.getCol(\""+formulaArg+"\").getByIndex(rowIndex);\n";
               t_form.add("args", formulaString);
               seeIfNullString = "if (" + mappedArg +" == null) {return null;}\n";
               t_form.add("ifNull", seeIfNullString);
            }
            
            t_col.add("colFormula", "\"" + formulaName + "\"");
            t_class.add("formulas", t_form);
            formulaCounter++;
        
         }            
         else {
            t_col.add("colFormula", "null");  
         }

      }         


      ST t_addRow = templates.getInstanceOf("make_t_addRow_Override");
      for (String formName : formulaNames) {
         ST t_addElseIf = templates.getInstanceOf("make_t_elseif");
         t_addElseIf.add("formulaName", formName);   
         t_addRow.add("formulaName", t_addElseIf);   
      }   
      if (formulaNames.size() != 0) {   
         t_class.add("formulas", t_addRow);  
      }    
      
      t_class.add("tableName", tableName);
      output.add("tableclasses", t_class);

      declaredUserTypes.add(tableName);

      return null;
   }

   @Override public ST visitDefineColumn(TablanParser.DefineColumnContext ctx) {
      ST t_col = templates.getInstanceOf("make_t_column");
      String colName = ctx.columnName.getText();

      if (ctx.exprData() != null) {
         t_col.add("colFormula", "formulaNum" + formulaCounter);           
      }
      else {
         t_col.add("colFormula", "null");  
      }
      if (ctx.colType != null) {
         t_col.add("colType", ctx.colType.getText());   
      }
      else {
         t_col.add("colType", "null");  
      }
      if (ctx.colHeader != null) {
         t_col.add("colHeader", ctx.colHeader.getText());         
      }
      else {
         t_col.add("colHeader", "null");  
      }

      t_col.add("colName", colName);
      return t_col;
   }

   @Override public ST visitForLoop(TablanParser.ForLoopContext ctx) {
      ST start_loop = templates.getInstanceOf("start_for_loop");
      String rawElemName = ctx.elemName.getText();
      String rawTableName = ctx.tableName.getText();

      String elemName = getMappedName(rawElemName, SYNCLASS.VAR);
      String tableName = getMappedName(rawTableName, SYNCLASS.VAR);
      
      start_loop.add("varType", "TableType");
      start_loop.add("variable", elemName);
      start_loop.add("tableName", tableName);
      output.add("instructions", start_loop);

      declaredVars.put(elemName, "ArrayList");
      isVarAssigned.put(elemName, true);

      for (TablanParser.StatContext forLoopInstruction :  ctx.stat()) {
         output.add("instructions", templates.getInstanceOf("indentation")); 
         visit(forLoopInstruction);
      }

      declaredVars.remove(elemName);
      isVarAssigned.remove(elemName);
      ST end_loop = templates.getInstanceOf("end_for_loop");
      output.add("instructions", end_loop); 

      return null;

   }



}
