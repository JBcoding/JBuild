// Generated from /Users/madsbjoern/Documents/Git/JBuild/src/main/antlr4/renderer.Building.g4 by ANTLR 4.8
package building.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BuildingParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BuildingVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BuildingParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BuildingParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#plotDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlotDecl(BuildingParser.PlotDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#shapeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeDeclaration(BuildingParser.ShapeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyStatementsMultiple}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyStatementsMultiple(BuildingParser.PolyStatementsMultipleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyStatementSingle}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyStatementSingle(BuildingParser.PolyStatementSingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyStatementFinal}
	 * labeled alternative in {@link BuildingParser#polyStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyStatementFinal(BuildingParser.PolyStatementFinalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyCommandSimple}
	 * labeled alternative in {@link BuildingParser#polyCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyCommandSimple(BuildingParser.PolyCommandSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyCommandAssignment}
	 * labeled alternative in {@link BuildingParser#polyCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyCommandAssignment(BuildingParser.PolyCommandAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#simpleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCommand(BuildingParser.SimpleCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(BuildingParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyCommandName}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyCommandName(BuildingParser.PolyCommandNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyExtrudeCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyExtrudeCommand(BuildingParser.PolyExtrudeCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polySplitCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolySplitCommand(BuildingParser.PolySplitCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polyIfCommand}
	 * labeled alternative in {@link BuildingParser#polyFinalCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyIfCommand(BuildingParser.PolyIfCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extrudeSimple}
	 * labeled alternative in {@link BuildingParser#extrudeCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtrudeSimple(BuildingParser.ExtrudeSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extrudeFull}
	 * labeled alternative in {@link BuildingParser#extrudeCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtrudeFull(BuildingParser.ExtrudeFullContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#faceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFaceDecl(BuildingParser.FaceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#enclosedPolystatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedPolystatements(BuildingParser.EnclosedPolystatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#splitCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitCommand(BuildingParser.SplitCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#splitRepeating}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitRepeating(BuildingParser.SplitRepeatingContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#splitDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitDecl(BuildingParser.SplitDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(BuildingParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#ifCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCommand(BuildingParser.IfCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionPar}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPar(BuildingParser.ExpressionParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionVal}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionVal(BuildingParser.ExpressionValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAddSub}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddSub(BuildingParser.ExpressionAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionPair}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPair(BuildingParser.ExpressionPairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionMulDivMod}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMulDivMod(BuildingParser.ExpressionMulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFunctionCall(BuildingParser.ExpressionFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionEqNeq}
	 * labeled alternative in {@link BuildingParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEqNeq(BuildingParser.ExpressionEqNeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valTrue}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValTrue(BuildingParser.ValTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFalse}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFalse(BuildingParser.ValFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValNumber(BuildingParser.ValNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valString}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValString(BuildingParser.ValStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valPercentage}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValPercentage(BuildingParser.ValPercentageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFraction}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFraction(BuildingParser.ValFractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valVariable}
	 * labeled alternative in {@link BuildingParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValVariable(BuildingParser.ValVariableContext ctx);
}