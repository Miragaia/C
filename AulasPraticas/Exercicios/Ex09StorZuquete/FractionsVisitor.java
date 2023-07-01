// Generated from Fractions.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FractionsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FractionsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FractionsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FractionsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FractionsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(FractionsParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link FractionsParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FractionsParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnNeg}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnNeg(FractionsParser.ExprUnNegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnPos}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnPos(FractionsParser.ExprUnPosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(FractionsParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPrint}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrint(FractionsParser.ExprPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCopy}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCopy(FractionsParser.ExprCopyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPaste}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPaste(FractionsParser.ExprPasteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPower}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPower(FractionsParser.ExprPowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReduce(FractionsParser.ExprReduceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDivMod(FractionsParser.ExprMultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(FractionsParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNewline}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNewline(FractionsParser.ExprNewlineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(FractionsParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInteger(FractionsParser.ExprIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link FractionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(FractionsParser.ExprIdContext ctx);
}