package AST;

import java.util.List;

public class ArgumentsNode extends AST {
    private List<ExpressionNode> arguments;

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }

    public List<ExpressionNode> getArguments() {
        return arguments;
    }

    public void setArguments(List<ExpressionNode> arguments) {
        this.arguments = arguments;
    }
}
