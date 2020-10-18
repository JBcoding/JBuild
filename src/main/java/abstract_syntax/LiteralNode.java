package abstract_syntax;

public class LiteralNode extends ExpressionNode {
    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
