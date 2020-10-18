package abstract_syntax;

public interface ASTVisitor<T> {
    T visit(SimpleCommandNode node);
    T visit(PolyStatementsNode node);
    T visit(LiteralNode node);
    T visit(NotEqualNode node);
    T visit(EqualNode node);
    T visit(AdditionNode node);
    T visit(SubtractionNode node);
    T visit(DivideNode node);
    T visit(MultiplyNode node);
    T visit(ModuloNode node);
    T visit(ShapeDeclarationNode node);
    T visit(BuildingNode node);
    T visit(ArgumentsNode node);
    T visit(ExtrudeCommandNode extrudeCommandNode);
    T visit(IfNode ifNode);
    T visit(PairNode pairNode);
    T visit(PolyNameCommandNode polyNameCommandNode);
    T visit(FaceDeclarationNode faceDeclarationNode);
    T visit(SplitDeclarationNode splitDeclarationNode);
    T visit(SplitCommandNode splitCommandNode);
    T visit(ProgramNode programNode);
    T visit(VariableNode variableNode);
    T visit(AssignmentNode assignmentNode);
    T visit(FunctionCallNode functionCallNode);
}
