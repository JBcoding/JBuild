package AST;

import java.util.List;

public class SplitCommandNode extends PolyCommand {
    Axis axis;

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    List<SplitDeclarationNode> splits;
    boolean repeat;
    boolean includePartialSections;

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public boolean isIncludePartialSections() {
        return includePartialSections;
    }

    public void setIncludePartialSections(boolean includePartialSections) {
        this.includePartialSections = includePartialSections;
    }



    public List<SplitDeclarationNode> getSplits() {
        return splits;
    }

    public void setSplits(List<SplitDeclarationNode> splits) {
        this.splits = splits;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
