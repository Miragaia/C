package CSV;
import java.util.ArrayList;
import Utils.*;

import javax.crypto.AEADBadTagException;

@SuppressWarnings("CheckReturnValue")
public class Visitor extends CSVBaseVisitor<ArrayList<Type>> {

   public TableType table = new TableType();

   @Override public ArrayList<Type> visitProgram(CSVParser.ProgramContext ctx) {

      ArrayList<ArrayList<Type>> rows = new ArrayList<ArrayList<Type>>();
      ArrayList<Type> header = new ArrayList<Type>();
      header = visit(ctx.header());
      
      // Array of rows
      for(int i = 0; i < ctx.row().size(); i++){
         ArrayList<Type> row = visit(ctx.row(i));
         rows.add(row);
      }
      
      // Transform rows into columns
      for(int i = 0; i < header.size(); i++){
         Column col;
         if (rows.get(0).get(i) != null) {
            col = new Column(header.get(i).toString(), rows.get(0).get(i).name(), "");
         }
         else {
            col = new Column(header.get(i).toString(), "Type", "");
         }
         for(int j = 0; j < rows.size(); j++){
            col.put(rows.get(j).get(i));
         }
         table.columns.put(col.header, col);
      }
      return null;
   }

   @Override public ArrayList<Type> visitHeader(CSVParser.HeaderContext ctx) {
      ArrayList<Type> res = new ArrayList<Type>();
      res = visit(ctx.row());
      return res;
   }

   @Override public ArrayList<Type> visitRow(CSVParser.RowContext ctx) {
      ArrayList<Type> res = new ArrayList<Type>();
      for(int i=0; i<ctx.data().size(); i++) {
         if (ctx.data(i) != null) {
            ArrayList<Type> field = visit(ctx.data(i));
            res.add(field.get(0));
         }
         else {
            res.add(null);
         }
      }
      return res;
   }

   @Override public ArrayList<Type> visitDataInitial(CSVParser.DataInitialContext ctx) {
      ArrayList<Type> res = new ArrayList<Type>();
      res = visit(ctx.field());
      return res;
   }

   @Override public ArrayList<Type> visitDataValue(CSVParser.DataValueContext ctx) {
      ArrayList<Type> res = new ArrayList<Type>();
      res = visit(ctx.field());
      return res;
   }

   @Override public ArrayList<Type> visitDataNull(CSVParser.DataNullContext ctx) {
      ArrayList<Type> res = new ArrayList<Type>();
      res.add(null);
      return res;
   }

   @Override public ArrayList<Type> visitFieldText(CSVParser.FieldTextContext ctx) {
      Type text = new TextType(ctx.TEXT().getText());

      ArrayList<Type> res = new ArrayList<Type>();
      res.add(text);

      return res;
   }

   @Override public ArrayList<Type> visitFieldInt(CSVParser.FieldIntContext ctx) {
      
      Type integ = new IntegerType(Integer.parseInt(ctx.NUMBER().getText()));
      
      ArrayList<Type> res = new ArrayList<Type>();
      res.add(integ);

      return res;
   }

   @Override public ArrayList<Type> visitFieldReal(CSVParser.FieldRealContext ctx) {
      Type real = new RealType(Double.parseDouble(ctx.REAL().getText()));
      
      ArrayList<Type> res = new ArrayList<Type>();
      res.add(real);

      return res;
   }

   public TableType getFinalTable() {
      return table;
   }
}
