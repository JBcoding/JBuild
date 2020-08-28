package AST;

public class AdditionNode extends BinaryOperationNode {

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
