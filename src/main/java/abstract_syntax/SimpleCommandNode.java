package abstract_syntax;

public class SimpleCommandNode extends PolyCommand {
    String command;
    ArgumentsNode arguments;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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
