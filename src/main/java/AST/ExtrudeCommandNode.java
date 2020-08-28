package AST;

import java.util.List;

public class ExtrudeCommandNode extends PolyCommand {
    ArgumentsNode args;
    List<FaceDeclarationNode> faces;

    public ArgumentsNode getArgs() {
        return args;
    }

    public void setArgs(ArgumentsNode args) {
        this.args = args;
    }

    public List<FaceDeclarationNode> getFaces() {
        return faces;
    }

    public void setFaces(List<FaceDeclarationNode> faces) {
        this.faces = faces;
    }

    @Override
    public Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
