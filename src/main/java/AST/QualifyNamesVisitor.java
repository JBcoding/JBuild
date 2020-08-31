package AST;

public class QualifyNamesVisitor extends BaseVisitor<AST> {
    String name;

    public QualifyNamesVisitor(String name) {
        this.name = name;
    }

    private String qualify(String str) {
        return name + "." + str;
    }

    @Override
    public AST visit(ShapeDeclarationNode node) {
        AST res = super.visit(node);
        node.setName(name + "." + node.getName());
        return res;
    }

    @Override
    public AST visit(BuildingNode node) {
        AST res = super.visit(node);
        node.setStartRule(qualify(node.getStartRule()));
        return res;
    }

    @Override
    public AST visit(PolyNameCommandNode polyNameCommandNode) {
        AST res = super.visit(polyNameCommandNode);
        polyNameCommandNode.setName(qualify(polyNameCommandNode.getName()));
        return res;
    }

    @Override
    public AST visit(VariableNode variableNode) {
        AST res = super.visit(variableNode);
        variableNode.setName(qualify(variableNode.getName()));
        return res;
    }

    @Override
    public AST visit(AssignmentNode assignmentNode) {
        AST res = super.visit(assignmentNode);
        assignmentNode.setVariable(qualify(assignmentNode.getVariable()));
        return res;
    }
}
