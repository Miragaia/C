// Generated from BigIntCalc.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BigIntCalcParser}.
 */
public interface BigIntCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BigIntCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BigIntCalcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigIntCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BigIntCalcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigIntCalcParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(BigIntCalcParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigIntCalcParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(BigIntCalcParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigIntCalcParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(BigIntCalcParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigIntCalcParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(BigIntCalcParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigIntCalcParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(BigIntCalcParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigIntCalcParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(BigIntCalcParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link BigIntCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(BigIntCalcParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link BigIntCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(BigIntCalcParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link BigIntCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(BigIntCalcParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link BigIntCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(BigIntCalcParser.ExprIDContext ctx);
}