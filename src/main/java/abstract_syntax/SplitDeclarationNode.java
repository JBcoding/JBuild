package abstract_syntax;

public class SplitDeclarationNode extends AST {
    ExpressionNode size;
    PolyStatementsNode statements;

    public ExpressionNode getSize() {
        return size;
    }

    public void setSize(ExpressionNode size) {
        this.size = size;
    }

    public PolyStatementsNode getStatements() {
        return statements;
    }

    public void setStatements(PolyStatementsNode statements) {
        this.statements = statements;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}


