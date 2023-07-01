// Generated from Fractions.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FractionsParser}.
 */
public interface FractionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FractionsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FractionsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FractionsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FractionsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(FractionsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(FractionsParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FractionsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FractionsParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FractionsParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnNeg}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnNeg(FractionsParser.ExprUnNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnNeg}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnNeg(FractionsParser.ExprUnNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnPos}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnPos(FractionsParser.ExprUnPosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnPos}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnPos(FractionsParser.ExprUnPosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(FractionsParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(FractionsParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPrint}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPrint(FractionsParser.ExprPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPrint}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPrint(FractionsParser.ExprPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCopy}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCopy(FractionsParser.ExprCopyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCopy}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCopy(FractionsParser.ExprCopyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPaste}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPaste(FractionsParser.ExprPasteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPaste}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPaste(FractionsParser.ExprPasteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPower}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPower(FractionsParser.ExprPowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPower}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPower(FractionsParser.ExprPowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReduce(FractionsParser.ExprReduceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReduce(FractionsParser.ExprReduceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(FractionsParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(FractionsParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(FractionsParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(FractionsParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNewline}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNewline(FractionsParser.ExprNewlineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNewline}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNewline(FractionsParser.ExprNewlineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(FractionsParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(FractionsParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInteger(FractionsParser.ExprIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInteger(FractionsParser.ExprIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprId(FractionsParser.ExprIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprId(FractionsParser.ExprIdContext ctx);
}