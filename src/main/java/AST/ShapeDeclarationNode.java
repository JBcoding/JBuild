package AST;

public class ShapeDeclarationNode extends AST {
    private String name;
    private PolyStatementsNode statements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
