// Generated from CSV/CSV.g4 by ANTLR 4.12.0

package CSV;
import Utils.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSVParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CSVVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CSVParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CSVParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(CSVParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(CSVParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataInitial}
	 * labeled alternative in {@link CSVParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataInitial(CSVParser.DataInitialContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataValue}
	 * labeled alternative in {@link CSVParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValue(CSVParser.DataValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataNull}
	 * labeled alternative in {@link CSVParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataNull(CSVParser.DataNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldText}
	 * labeled alternative in {@link CSVParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldText(CSVParser.FieldTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldInt}
	 * labeled alternative in {@link CSVParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldInt(CSVParser.FieldIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldReal}
	 * labeled alternative in {@link CSVParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldReal(CSVParser.FieldRealContext ctx);
}