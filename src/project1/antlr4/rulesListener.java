// Generated from C:/Users/sidds/Documents/CSCE 315/PA1/CSCE315Project1/src/project1\rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link rulesParser}.
 */
public interface rulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link rulesParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(rulesParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(rulesParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(rulesParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(rulesParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(rulesParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(rulesParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#show_cmd}.
	 * @param ctx the parse tree
	 */
	void enterShow_cmd(rulesParser.Show_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#show_cmd}.
	 * @param ctx the parse tree
	 */
	void exitShow_cmd(rulesParser.Show_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#create_cmd}.
	 * @param ctx the parse tree
	 */
	void enterCreate_cmd(rulesParser.Create_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#create_cmd}.
	 * @param ctx the parse tree
	 */
	void exitCreate_cmd(rulesParser.Create_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#update_cmd}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_cmd(rulesParser.Update_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#update_cmd}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_cmd(rulesParser.Update_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#insert_cmd}.
	 * @param ctx the parse tree
	 */
	void enterInsert_cmd(rulesParser.Insert_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#insert_cmd}.
	 * @param ctx the parse tree
	 */
	void exitInsert_cmd(rulesParser.Insert_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#delete_cmd}.
	 * @param ctx the parse tree
	 */
	void enterDelete_cmd(rulesParser.Delete_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#delete_cmd}.
	 * @param ctx the parse tree
	 */
	void exitDelete_cmd(rulesParser.Delete_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(rulesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(rulesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#atomic_expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomic_expr(rulesParser.Atomic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#atomic_expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomic_expr(rulesParser.Atomic_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(rulesParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(rulesParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(rulesParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(rulesParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#renaming}.
	 * @param ctx the parse tree
	 */
	void enterRenaming(rulesParser.RenamingContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#renaming}.
	 * @param ctx the parse tree
	 */
	void exitRenaming(rulesParser.RenamingContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(rulesParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(rulesParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#difference}.
	 * @param ctx the parse tree
	 */
	void enterDifference(rulesParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#difference}.
	 * @param ctx the parse tree
	 */
	void exitDifference(rulesParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#product}.
	 * @param ctx the parse tree
	 */
	void enterProduct(rulesParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#product}.
	 * @param ctx the parse tree
	 */
	void exitProduct(rulesParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#natural_join}.
	 * @param ctx the parse tree
	 */
	void enterNatural_join(rulesParser.Natural_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#natural_join}.
	 * @param ctx the parse tree
	 */
	void exitNatural_join(rulesParser.Natural_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(rulesParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(rulesParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(rulesParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(rulesParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(rulesParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(rulesParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(rulesParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(rulesParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(rulesParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(rulesParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#attribute_list}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_list(rulesParser.Attribute_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#attribute_list}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_list(rulesParser.Attribute_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#typed_attribute_list}.
	 * @param ctx the parse tree
	 */
	void enterTyped_attribute_list(rulesParser.Typed_attribute_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#typed_attribute_list}.
	 * @param ctx the parse tree
	 */
	void exitTyped_attribute_list(rulesParser.Typed_attribute_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#open_cmd}.
	 * @param ctx the parse tree
	 */
	void enterOpen_cmd(rulesParser.Open_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#open_cmd}.
	 * @param ctx the parse tree
	 */
	void exitOpen_cmd(rulesParser.Open_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#close_cmd}.
	 * @param ctx the parse tree
	 */
	void enterClose_cmd(rulesParser.Close_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#close_cmd}.
	 * @param ctx the parse tree
	 */
	void exitClose_cmd(rulesParser.Close_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void enterWrite_cmd(rulesParser.Write_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void exitWrite_cmd(rulesParser.Write_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#exit_cmd}.
	 * @param ctx the parse tree
	 */
	void enterExit_cmd(rulesParser.Exit_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#exit_cmd}.
	 * @param ctx the parse tree
	 */
	void exitExit_cmd(rulesParser.Exit_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_name(rulesParser.Attribute_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_name(rulesParser.Attribute_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#relation_name}.
	 * @param ctx the parse tree
	 */
	void enterRelation_name(rulesParser.Relation_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#relation_name}.
	 * @param ctx the parse tree
	 */
	void exitRelation_name(rulesParser.Relation_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link rulesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(rulesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link rulesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(rulesParser.TypeContext ctx);
}