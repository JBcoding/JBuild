package abstract_syntax;

public class FunctionCallNode extends ExpressionNode {
    String functionName;
    ArgumentsNode arguments;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public ArgumentsNode getArguments() {
        return arguments;
    }

    public void setArguments(ArgumentsNode arguments) {
        this.arguments = arguments;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
