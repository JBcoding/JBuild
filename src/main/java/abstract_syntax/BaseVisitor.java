package abstract_syntax;

public abstract class BaseVisitor<T> implements ASTVisitor<T> {
    @Override
    public T visit(SimpleCommandNode node) {
        return (T) node.getArguments().accept(this);
    }

    @Override
    public T visit(PolyStatementsNode node) {
        T res = (T) node.getCommand().accept(this);
        if (node.getNext() != null) {
            res = (T) node.getNext().accept(this);
        }
        return res;
    }

    @Override
    public T visit(LiteralNode node) {
        return null;
    }

    @Override
    public T visit(NotEqualNode node) {
        node.getLeft().accept(this);
        return (T) node.getRight().accept(this);
    }

    @Override
    public T visit(EqualNode node) {
        node.getLeft().accept(this);
        return (T) node.getRight().accept(this);
    }

    @Override
    public T visit(AdditionNode node) {
        node.getLeft().accept(this);
        return (T) node.getRight().accept(this);
    }

    @Override
    public T visit(SubtractionNode node) {
        node.getLeft().accept(this);
        return (T) node.getRight().accept(this);
    }

    @Override
    public T visit(DivideNode node) {
        node.getLeft().accept(this);
        return (T) node.getRight().accept(this);
    }

    @Override
    public T visit(MultiplyNode node) {
        node.getLeft().accept(this);
        return (T) node.getRight().accept(this);
    }

    @Override
    public T visit(ModuloNode node) {
        return null;
    }

    @Override
    public T visit(ShapeDeclarationNode node) {
        return (T) node.getStatements().accept(this);
    }

    @Override
    public T visit(BuildingNode node) {
        T res = null;
        for (ExpressionNode coord : node.getCoordinates()) {
            res = (T) coord.accept(this);
        }
        return res;
    }

    @Override
    public T visit(ArgumentsNode node) {
        T res = null;
        for (ExpressionNode coord : node.getArguments()) {
            res = (T) coord.accept(this);
        }
        return res;
    }

    @Override
    public T visit(ExtrudeCommandNode extrudeCommandNode) {
        extrudeCommandNode.getArgs().accept(this);
        T res = null;
        for (FaceDeclarationNode coord : extrudeCommandNode.getFaces()) {
            res = (T) coord.accept(this);
        }
        return res;
    }

    @Override
    public T visit(IfNode ifNode) {
        ifNode.getExpresion().accept(this);
        ifNode.getTrueBranch().accept(this);
        return (T) ifNode.getFalseBranch().accept(this);
    }

    @Override
    public T visit(PairNode pairNode) {
        pairNode.getLeft().accept(this);
        return (T) pairNode.getRight().accept(this);
    }

    @Override
    public T visit(PolyNameCommandNode polyNameCommandNode) {
        return null;
    }

    @Override
    public T visit(FaceDeclarationNode faceDeclarationNode) {
        return (T) faceDeclarationNode.getStatements().accept(this);
    }

    @Override
    public T visit(SplitDeclarationNode splitDeclarationNode) {
        splitDeclarationNode.getSize().accept(this);
        return (T) splitDeclarationNode.getStatements().accept(this);
    }

    @Override
    public T visit(SplitCommandNode splitCommandNode) {
        T res = null;
        for (SplitDeclarationNode split : splitCommandNode.getSplits()) {
            res = (T) split.accept(this);
        }
        return res;
    }

    @Override
    public T visit(ProgramNode programNode) {
        for (AssignmentNode asgn : programNode.getGlobalVariables()) {
            asgn.accept(this);
        }

        for (ShapeDeclarationNode shape: programNode.getRules()) {
            shape.accept(this);
        }

        for (BuildingNode building: programNode.getBuildings()) {
            building.accept(this);
        }

        return null;
    }

    @Override
    public T visit(VariableNode variableNode) {
        return null;
    }

    @Override
    public T visit(AssignmentNode assignmentNode) {
        return (T) assignmentNode.getExpression().accept(this);
    }

    @Override
    public T visit(FunctionCallNode functionCallNode) {
        return (T) functionCallNode.getArguments().accept(this);
    }
}
