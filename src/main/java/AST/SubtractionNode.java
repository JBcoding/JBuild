package AST;

public class SubtractionNode extends BinaryOperationNode {

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
