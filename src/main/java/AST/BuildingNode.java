package AST;

import java.util.List;

public class BuildingNode extends AST{
    private List<ExpressionNode> coordinates;
    private String startRule;

    public String getStartRule() {
        return startRule;
    }

    public void setStartRule(String startRule) {
        this.startRule = startRule;
    }

    public List<ExpressionNode> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<ExpressionNode> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
