import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Executer extends StrLangBaseVisitor<String> {

   HashMap<String, String> variables = new HashMap<>();

   Scanner sc = new Scanner(System.in);

   @Override
   public String visitProgram(StrLangParser.ProgramContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitPrintStatement(StrLangParser.PrintStatementContext ctx) {
      System.out.println(visit(ctx.print()));
      return "";
   }

   @Override
   public String visitAssignmentStatement(StrLangParser.AssignmentStatementContext ctx) {
      return visit(ctx.assignment());

      // return res;
   }

   @Override
   public String visitPrint(StrLangParser.PrintContext ctx) {
      String res = visit(ctx.expression());
      if (res != null) {
         return res;

      }

      return "";
      // return res;
   }

   @Override
   public String visitAssignment(StrLangParser.AssignmentContext ctx) {
      String coiso = ctx.getText().split(":")[0];
      String variable = visit(ctx.expression(0));
      String value = visit(ctx.expression(1));

      if (value != null) {
         if (!variables.containsKey(coiso)) {
            variables.put(coiso, value);
         } else {
            variables.put(coiso, value);
         }
      }
      return "";
   }

   @Override
   public String visitExprparenteses(StrLangParser.ExprparentesesContext ctx) {
      return visit(ctx.expression());
      // return res;
   }

   @Override
   public String visitExprInput(StrLangParser.ExprInputContext ctx) {
      System.out.println(visit(ctx.expression()));
      String value = sc.nextLine();
      return value;
      // return res;
   }

   @Override
   public String visitExprAdd(StrLangParser.ExprAddContext ctx) {
      String value1 = visit(ctx.expression(0));
      String value2 = visit(ctx.expression(1));
      String concat = "";
      if (value1 != null && value2 != null) {
         concat = value1 + value2;
      }

      return concat;
   }

   @Override
   public String visitExprSub(StrLangParser.ExprSubContext ctx) {
      String value1 = visit(ctx.expression(0));
      String value2 = visit(ctx.expression(1));

      if (value1.contains(value2)) {
         return value1.replaceAll(value2, "");
      }

      return "";
   }

   @Override
   public String visitExprReplace(StrLangParser.ExprReplaceContext ctx) {
      String initial = visit(ctx.expression(0));
      String item = visit(ctx.expression(1));
      String text = visit(ctx.expression(2));

      if (initial != null && item != null && text != null) {
         return initial.replace(item, text);
      }

      return "";
   }

   @Override
   public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      String exp = visit(ctx.expression());

      if (exp != null) {
         return exp.trim();
      }

      return "";
   }

   @Override
   public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String res = ctx.getText();
      return res.substring(1, res.length() - 1);
      // return res;
   }

   @Override
   public String visitExprID(StrLangParser.ExprIDContext ctx) {
      String value = ctx.getText();

      if (!variables.containsKey(value)) {
         return "Variable '" + value + "' does not exist";
      } else {
         return variables.get(value);
      }
   }
}
