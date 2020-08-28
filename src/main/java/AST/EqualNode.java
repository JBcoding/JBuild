package AST;

public class EqualNode extends BinaryOperationNode {

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
