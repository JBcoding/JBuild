package abstract_syntax;

public class IfNode extends PolyCommand {
    ExpressionNode expresion;
    PolyStatementsNode trueBranch;
    PolyStatementsNode falseBranch;

    public ExpressionNode getExpresion() {
        return expresion;
    }

    public void setExpresion(ExpressionNode expresion) {
        this.expresion = expresion;
    }

    public PolyStatementsNode getTrueBranch() {
        return trueBranch;
    }

    public void setTrueBranch(PolyStatementsNode trueBranch) {
        this.trueBranch = trueBranch;
    }

    public PolyStatementsNode getFalseBranch() {
        return falseBranch;
    }

    public void setFalseBranch(PolyStatementsNode falseBranch) {
        this.falseBranch = falseBranch;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
