package abstract_syntax;

public class PolyStatementsNode extends AST {
    private PolyCommand command;
    private PolyStatementsNode next;

    public PolyCommand getCommand() {
        return command;
    }

    public void setCommand(PolyCommand command) {
        this.command = command;
    }

    public PolyStatementsNode getNext() {
        return next;
    }

    public void setNext(PolyStatementsNode next) {
        this.next = next;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
