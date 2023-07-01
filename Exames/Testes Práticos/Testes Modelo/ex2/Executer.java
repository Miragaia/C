import java.util.*;

@SuppressWarnings("CheckReturnValue")
public class Executer extends FracLangBaseVisitor<Fraction> {

   HashMap<String, Fraction> variables = new HashMap<>();
   Scanner sc = new Scanner(System.in);

   @Override public Fraction visitProgram(FracLangParser.ProgramContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Fraction visitStat(FracLangParser.StatContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
      }
      return res;
   }

   @Override public Fraction visitAssignment(FracLangParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      String variable = ctx.ID().getText();

      if (variable != null && res != null){
         variables.put(variable, res);
      }
      return res;
   }

   @Override public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null) {
         if (ctx.op.getText().equals("-")) {
            res = new Fraction(-res.getNumerador(), res.getDenominador());
         }
      }
      return res;
   }

   @Override public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));
      if (e1 != null && e2 != null) {
         switch(ctx.op.getText()) {
            case "+":
               res = new Fraction(e1.getNumerador() * e2.getDenominador() + e2.getNumerador() * e1.getDenominador(), e1.getDenominador() * e2.getDenominador());
               break;
            case "-":
               res = new Fraction(e1.getNumerador() * e2.getDenominador() - e2.getNumerador() * e1.getDenominador(), e1.getDenominador() * e2.getDenominador());
               break;
         }
      }
      return res;
   }

   @Override public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));
      if (e1 != null && e2 != null) {
         switch(ctx.op.getText()) {
            case "*":
               res = new Fraction(e1.getNumerador() * e2.getNumerador(), e1.getDenominador() * e2.getDenominador());
               break;
            case ":":
               res = new Fraction(e1.getNumerador() * e2.getDenominador(), e1.getDenominador() * e2.getNumerador());
               break;
         }
      }
      return res;
   }

   @Override public Fraction visitExprParenteses(FracLangParser.ExprParentesesContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
      String [] parts = ctx.getText().split("/");
      Fraction frac;
      try{
         switch (parts.length) {
         case 1:
            frac = new Fraction(Integer.parseInt(ctx.getText()));
            break;

         case 2:
            int num = Integer.parseInt(ctx.getText().split("/")[0]);
            int den = Integer.parseInt(ctx.getText().split("/")[1]);

            frac = new Fraction(num, den);
            break;
      
         default:
            frac = null;
            break;
      }
      } catch(NumberFormatException e){
         System.out.println("Error: Invalid Fraction!");
         return null;
      }

      return frac;
      //return res;
   }

   @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      Fraction res = null;
      String variable = ctx.getText();

      if (!variables.containsKey(variable)){
         System.out.println("Variable " + variable + " not initialized!");
      }else{
         res = variables.get(variable);
      }
      return res;
   }

   @Override public Fraction visitExprString(FracLangParser.ExprStringContext ctx) {
      String output = ctx.STRING().getText();
      System.out.println(output.substring(1, output.length()-1) + ": ");
      String user = sc.nextLine();

      String [] parts = user.split("/");
      Fraction frac;
      try{
         switch (parts.length) {
         case 1:
            frac = new Fraction(Integer.parseInt(user));
            break;

         case 2:
            int num = Integer.parseInt(user.split("/")[0]);
            int den = Integer.parseInt(user.split("/")[1]);

            frac = new Fraction(num, den);
            break;
      
         default:
            frac = null;
            break;
      }
      } catch(NumberFormatException e){
         System.out.println("Error: Invalid Fraction!");
         return null;
      }

      return frac;
   }

   @Override public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null) {
         res = res.reduce();
      }
      return res;
   }
}
