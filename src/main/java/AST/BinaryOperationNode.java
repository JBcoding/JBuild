package AST;

public abstract class BinaryOperationNode extends ExpressionNode {
    ExpressionNode left;
    ExpressionNode right;

    public ExpressionNode getLeft() {
        return left;
    }

    public void setLeft(ExpressionNode left) {
        this.left = left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    public void setRight(ExpressionNode right) {
        this.right = right;
    }
}
