import org.stringtemplate.v4.*;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Compiler extends FractionsBaseVisitor<ST> {
	STGroup templates = new STGroupFile("templates.stg");
	Map<String, Boolean> variables = new HashMap<String, Boolean>();
	ST output;

   @Override public ST visitProgram(FractionsParser.ProgramContext ctx) {
      	//  Get instanceia do inicio do programa
	output = templates.getInstanceOf("program");
	
	//  Visita todos os filhos
	visitChildren(ctx);

	//  Dá print ao programa na nova linguagem (compilado)
	System.out.printf(output.render());
	return null;
   }

   @Override public ST visitStat(FractionsParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAssignment(FractionsParser.AssignmentContext ctx) {
        ST res = visit(ctx.expr());
        String varName = ctx.ID().getText();
        ST var_decl, var_set;

        if (variables.get(varName) == null) {
                variables.put(varName, true);
                var_decl = templates.getInstanceOf("var_declaration");
                var_decl.add("name", varName);
                output.add("variables", var_decl);
        }

        var_set = templates.getInstanceOf("var_set");
        var_set.add("name", varName);
        var_set.add("expr", res);
        output.add("instructions", var_set);
         return null;

   }

   @Override public ST visitExprUnNeg(FractionsParser.ExprUnNegContext ctx) {
	ST res = visit(ctx.expr());
	ST minus = templates.getInstanceOf("minus");
	minus.add("a", res);

	return minus;
   }

   @Override public ST visitExprUnPos(FractionsParser.ExprUnPosContext ctx) {
      	ST res = visit(ctx.expr());
     	return res;
   }

   @Override public ST visitExprParent(FractionsParser.ExprParentContext ctx) {
        ST res = visit(ctx.expr());
        return res;
   }

   @Override public ST visitExprPrint(FractionsParser.ExprPrintContext ctx) {
      	ST res = visit(ctx.expr());
	ST print = templates.getInstanceOf("print_expr");
      	print.add("expr", res);
	output.add("instructions", print);

	return null;
   }

   @Override public ST visitExprCopy(FractionsParser.ExprCopyContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitExprPaste(FractionsParser.ExprPasteContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitExprPower(FractionsParser.ExprPowerContext ctx) {
      	ST base = visit(ctx.expr(0));
      ST exp = visit(ctx.expr(1));
      ST power = templates.getInstanceOf("power");
      power.add("a", base);
      power.add("b", exp);

      return power;
   }

   @Override public ST visitExprReduce(FractionsParser.ExprReduceContext ctx) {
	      ST res = visit(ctx.expr());
        ST reduce = templates.getInstanceOf("reduce_expr");
        reduce.add("expr", res);
        output.add("instructions", reduce);

        return null;

   }

   @Override public ST visitExprLiteral(FractionsParser.ExprLiteralContext ctx) {
      	ST res = templates.getInstanceOf("literal");
	String fraction[] = ctx.Literal().getText().split("/");

	if (fraction.length == 2) {
      res.add("n", fraction[0]);
      res.add("d", fraction[1]);
	}
	else {
      res.add("n", fraction[0]);
      res.add("d", "1");
	}

     	return res;
   }

   @Override public ST visitExprMultDivMod(FractionsParser.ExprMultDivModContext ctx) {
        ST a = visit(ctx.expr(0));
        ST b = visit(ctx.expr(1));
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

   @Override public ST visitExprAddSub(FractionsParser.ExprAddSubContext ctx) {
        ST a = visit(ctx.expr(0));
        ST b = visit(ctx.expr(1));
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

   @Override public ST visitExprInteger(FractionsParser.ExprIntegerContext ctx) {
      ST res = templates.getInstanceOf("literal");
      String integer = ctx.Integer().getText();
   
      res.add("n", integer);
      res.add("d", "1");

      return res;
   }

   @Override public ST visitExprId(FractionsParser.ExprIdContext ctx) {
   	ST res = templates.getInstanceOf("variable");
	res.add("name", ctx.ID().getText());

	return res;
   }
}
