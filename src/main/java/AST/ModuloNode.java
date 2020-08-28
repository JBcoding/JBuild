package AST;

public class ModuloNode extends BinaryOperationNode {

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
