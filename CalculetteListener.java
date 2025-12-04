// Generated from Calculette.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculetteParser}.
 */
public interface CalculetteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalculetteParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalculetteParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CalculetteParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CalculetteParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CalculetteParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CalculetteParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#readlnInstruction}.
	 * @param ctx the parse tree
	 */
	void enterReadlnInstruction(CalculetteParser.ReadlnInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#readlnInstruction}.
	 * @param ctx the parse tree
	 */
	void exitReadlnInstruction(CalculetteParser.ReadlnInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#printlnInstruction}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnInstruction(CalculetteParser.PrintlnInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#printlnInstruction}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnInstruction(CalculetteParser.PrintlnInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CalculetteParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CalculetteParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculetteParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculetteParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#bloc}.
	 * @param ctx the parse tree
	 */
	void enterBloc(CalculetteParser.BlocContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#bloc}.
	 * @param ctx the parse tree
	 */
	void exitBloc(CalculetteParser.BlocContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#whileInstruction}.
	 * @param ctx the parse tree
	 */
	void enterWhileInstruction(CalculetteParser.WhileInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#whileInstruction}.
	 * @param ctx the parse tree
	 */
	void exitWhileInstruction(CalculetteParser.WhileInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#forInstruction}.
	 * @param ctx the parse tree
	 */
	void enterForInstruction(CalculetteParser.ForInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#forInstruction}.
	 * @param ctx the parse tree
	 */
	void exitForInstruction(CalculetteParser.ForInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CalculetteParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CalculetteParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(CalculetteParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(CalculetteParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CalculetteParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CalculetteParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#fonction}.
	 * @param ctx the parse tree
	 */
	void enterFonction(CalculetteParser.FonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#fonction}.
	 * @param ctx the parse tree
	 */
	void exitFonction(CalculetteParser.FonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(CalculetteParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(CalculetteParser.FinInstructionContext ctx);
}