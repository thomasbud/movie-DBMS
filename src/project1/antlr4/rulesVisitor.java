// Generated from /Users/engrbundle/IdeaProjects/BasicAntlrScript/src/project1/rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link rulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface rulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link rulesParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(rulesParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(rulesParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(rulesParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#show_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_cmd(rulesParser.Show_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#create_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_cmd(rulesParser.Create_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#update_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_cmd(rulesParser.Update_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#insert_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_cmd(rulesParser.Insert_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#delete_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_cmd(rulesParser.Delete_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(rulesParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#atomic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic_expr(rulesParser.Atomic_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(rulesParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(rulesParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#renaming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenaming(rulesParser.RenamingContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(rulesParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#difference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(rulesParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(rulesParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#natural_join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatural_join(rulesParser.Natural_joinContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(rulesParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(rulesParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(rulesParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(rulesParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(rulesParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#attribute_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_list(rulesParser.Attribute_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#typed_attribute_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyped_attribute_list(rulesParser.Typed_attribute_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#open_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_cmd(rulesParser.Open_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#close_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClose_cmd(rulesParser.Close_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#write_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_cmd(rulesParser.Write_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#exit_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_cmd(rulesParser.Exit_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#attribute_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_name(rulesParser.Attribute_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#relation_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_name(rulesParser.Relation_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link rulesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(rulesParser.TypeContext ctx);
}