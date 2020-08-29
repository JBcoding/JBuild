// Generated from /home/mathias/gitrepos/jbuild/src/main/antlr4/renderer.Building.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BuildingParser}.
 */
public interface BuildingListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BuildingParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BuildingParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BuildingParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#plotDecl}.
	 * @param ctx the parse tree
	 */
	void enterPlotDecl(BuildingParser.PlotDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#plotDecl}.
	 * @param ctx the parse tree
	 */
	void exitPlotDecl(BuildingParser.PlotDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#shapeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterShapeDeclaration(BuildingParser.ShapeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#shapeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitShapeDeclaration(BuildingParser.ShapeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyStatementsMultiple}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 */
	void enterPolyStatementsMultiple(BuildingParser.PolyStatementsMultipleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyStatementsMultiple}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 */
	void exitPolyStatementsMultiple(BuildingParser.PolyStatementsMultipleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyStatementSingle}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 */
	void enterPolyStatementSingle(BuildingParser.PolyStatementSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyStatementSingle}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 */
	void exitPolyStatementSingle(BuildingParser.PolyStatementSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyStatementFinal}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 */
	void enterPolyStatementFinal(BuildingParser.PolyStatementFinalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyStatementFinal}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 */
	void exitPolyStatementFinal(BuildingParser.PolyStatementFinalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyCommandSimple}
	 * labeled alternative in {@link BuildingParser#polyCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolyCommandSimple(BuildingParser.PolyCommandSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyCommandSimple}
	 * labeled alternative in {@link BuildingParser#polyCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolyCommandSimple(BuildingParser.PolyCommandSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyCommandAssignment}
	 * labeled alternative in {@link BuildingParser#polyCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolyCommandAssignment(BuildingParser.PolyCommandAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyCommandAssignment}
	 * labeled alternative in {@link BuildingParser#polyCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolyCommandAssignment(BuildingParser.PolyCommandAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#simpleCommand}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCommand(BuildingParser.SimpleCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#simpleCommand}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCommand(BuildingParser.SimpleCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(BuildingParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(BuildingParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyCommandName}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolyCommandName(BuildingParser.PolyCommandNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyCommandName}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolyCommandName(BuildingParser.PolyCommandNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyExtrudeCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolyExtrudeCommand(BuildingParser.PolyExtrudeCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyExtrudeCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolyExtrudeCommand(BuildingParser.PolyExtrudeCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polySplitCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolySplitCommand(BuildingParser.PolySplitCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polySplitCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolySplitCommand(BuildingParser.PolySplitCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polyIfCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolyIfCommand(BuildingParser.PolyIfCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polyIfCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolyIfCommand(BuildingParser.PolyIfCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extrudeSimple}
	 * labeled alternative in {@link BuildingParser#extrudeCommand}.
	 * @param ctx the parse tree
	 */
	void enterExtrudeSimple(BuildingParser.ExtrudeSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extrudeSimple}
	 * labeled alternative in {@link BuildingParser#extrudeCommand}.
	 * @param ctx the parse tree
	 */
	void exitExtrudeSimple(BuildingParser.ExtrudeSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extrudeFull}
	 * labeled alternative in {@link BuildingParser#extrudeCommand}.
	 * @param ctx the parse tree
	 */
	void enterExtrudeFull(BuildingParser.ExtrudeFullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extrudeFull}
	 * labeled alternative in {@link BuildingParser#extrudeCommand}.
	 * @param ctx the parse tree
	 */
	void exitExtrudeFull(BuildingParser.ExtrudeFullContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#faceDecl}.
	 * @param ctx the parse tree
	 */
	void enterFaceDecl(BuildingParser.FaceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#faceDecl}.
	 * @param ctx the parse tree
	 */
	void exitFaceDecl(BuildingParser.FaceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#enclosedPolystatements}.
	 * @param ctx the parse tree
	 */
	void enterEnclosedPolystatements(BuildingParser.EnclosedPolystatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#enclosedPolystatements}.
	 * @param ctx the parse tree
	 */
	void exitEnclosedPolystatements(BuildingParser.EnclosedPolystatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#splitCommand}.
	 * @param ctx the parse tree
	 */
	void enterSplitCommand(BuildingParser.SplitCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#splitCommand}.
	 * @param ctx the parse tree
	 */
	void exitSplitCommand(BuildingParser.SplitCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#splitRepeating}.
	 * @param ctx the parse tree
	 */
	void enterSplitRepeating(BuildingParser.SplitRepeatingContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#splitRepeating}.
	 * @param ctx the parse tree
	 */
	void exitSplitRepeating(BuildingParser.SplitRepeatingContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#splitDecl}.
	 * @param ctx the parse tree
	 */
	void enterSplitDecl(BuildingParser.SplitDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#splitDecl}.
	 * @param ctx the parse tree
	 */
	void exitSplitDecl(BuildingParser.SplitDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(BuildingParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(BuildingParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildingParser#ifCommand}.
	 * @param ctx the parse tree
	 */
	void enterIfCommand(BuildingParser.IfCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildingParser#ifCommand}.
	 * @param ctx the parse tree
	 */
	void exitIfCommand(BuildingParser.IfCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionPar}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionPar(BuildingParser.ExpressionParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionPar}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionPar(BuildingParser.ExpressionParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionVal}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionVal(BuildingParser.ExpressionValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionVal}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionVal(BuildingParser.ExpressionValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAddSub}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddSub(BuildingParser.ExpressionAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAddSub}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddSub(BuildingParser.ExpressionAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionPair}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionPair(BuildingParser.ExpressionPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionPair}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionPair(BuildingParser.ExpressionPairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionMulDivMod}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMulDivMod(BuildingParser.ExpressionMulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionMulDivMod}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMulDivMod(BuildingParser.ExpressionMulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFunctionCall(BuildingParser.ExpressionFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFunctionCall(BuildingParser.ExpressionFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionEqNeq}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEqNeq(BuildingParser.ExpressionEqNeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionEqNeq}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEqNeq(BuildingParser.ExpressionEqNeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valTrue}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValTrue(BuildingParser.ValTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valTrue}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValTrue(BuildingParser.ValTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFalse}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValFalse(BuildingParser.ValFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFalse}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValFalse(BuildingParser.ValFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValNumber(BuildingParser.ValNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValNumber(BuildingParser.ValNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valString}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValString(BuildingParser.ValStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valString}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValString(BuildingParser.ValStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valPercentage}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValPercentage(BuildingParser.ValPercentageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valPercentage}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValPercentage(BuildingParser.ValPercentageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFraction}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValFraction(BuildingParser.ValFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFraction}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValFraction(BuildingParser.ValFractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valVariable}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValVariable(BuildingParser.ValVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valVariable}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValVariable(BuildingParser.ValVariableContext ctx);
}