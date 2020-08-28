package AST;

public class FaceDeclarationNode extends AST {
    FaceType type;
    PolyStatementsNode statements;

    public FaceType getType() {
        return type;
    }

    public void setType(FaceType type) {
        this.type = type;
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


