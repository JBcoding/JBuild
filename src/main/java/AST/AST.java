package AST;

public abstract class AST {
    public abstract Object accept(ASTVisitor visitor);
    private int lineNumber;

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
