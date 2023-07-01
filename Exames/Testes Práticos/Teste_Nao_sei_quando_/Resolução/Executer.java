import java.math.BigInteger;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Executer extends BigIntCalcBaseVisitor<BigInteger> {

   HashMap<String, BigInteger> variables = new HashMap<>();

   @Override
   public BigInteger visitProgram(BigIntCalcParser.ProgramContext ctx) {
      BigInteger res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public BigInteger visitStat(BigIntCalcParser.StatContext ctx) {
      BigInteger res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public BigInteger visitShow(BigIntCalcParser.ShowContext ctx) {
      BigInteger res = visit(ctx.expr());

      if (res != null) {
         System.out.println(res);
      }

      return res;
   }

   @Override
   public BigInteger visitAssign(BigIntCalcParser.AssignContext ctx) {
      BigInteger res = visit(ctx.expr());
      String id = ctx.ID().getText();

      if (id != null && res != null) {
         variables.put(id, res);
      }
      return res;
   }

   @Override
   public BigInteger visitExprNumber(BigIntCalcParser.ExprNumberContext ctx) {
      BigInteger res = new BigInteger(ctx.getText());
      return res;
   }

   @Override
   public BigInteger visitExprID(BigIntCalcParser.ExprIDContext ctx) {
      String variable = ctx.getText();

      if (!variables.containsKey(variable)) {
         System.out.println("Variable " + variable + " not yet assigned!");
         return null;
      }
      return variables.get(variable);
   }
}
