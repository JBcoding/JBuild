package abstract_syntax;

import java.util.List;

public class ProgramNode extends AST {
    List<BuildingNode> buildings;
    List<ShapeDeclarationNode> rules;
    List<AssignmentNode> globalVariables;

    public List<AssignmentNode> getGlobalVariables() {
        return globalVariables;
    }

    public void setGlobalVariables(List<AssignmentNode> globalVariables) {
        this.globalVariables = globalVariables;
    }

    public List<BuildingNode> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingNode> buildings) {
        this.buildings = buildings;
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
