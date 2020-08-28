package AST;

import java.util.List;

public class ProgramNode extends AST {
    BuildingNode building;
    List<ShapeDeclarationNode> rules;
    List<AssignmentNode> globalVariables;

    public List<AssignmentNode> getGlobalVariables() {
        return globalVariables;
    }

    public void setGlobalVariables(List<AssignmentNode> globalVariables) {
        this.globalVariables = globalVariables;
    }

    public BuildingNode getBuilding() {
        return building;
    }

    public void setBuilding(BuildingNode building) {
        this.building = building;
    }

    public List<ShapeDeclarationNode> getRules() {
        return rules;
    }

    public void setRules(List<ShapeDeclarationNode> rules) {
        this.rules = rules;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
