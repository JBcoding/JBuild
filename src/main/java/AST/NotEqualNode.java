package AST;

public class NotEqualNode extends BinaryOperationNode {

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
