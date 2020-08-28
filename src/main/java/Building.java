import AST.*;
import building.antlr.BuildingBaseVisitor;
import building.antlr.BuildingLexer;
import building.antlr.BuildingParser;
import com.jogamp.opengl.GL2;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Building {
    private List<Shape> shapes;
    private AST ast;
    private double rotationAngle;
    private Vector3D rotationTranslationDiff;
    private Vector3D translation;

    private BoundingBox boundingBox;

    public Building(AST ast) {
        this((List<Shape>) ast.accept(new ShapeGeneratorVisitor()));
        this.ast = ast;
    }

    private Building(List<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
        this.translation = Vector3D.ZERO;
        this.rotationAngle = 0;
        this.rotationTranslationDiff = Vector3D.ZERO;

        List<BoundingBox> boundingBoxes = shapes.stream().map(Shape::getBoundingBox).collect(Collectors.toList());
        Vector3D min = new Vector3D(
                boundingBoxes.stream().mapToDouble(bb -> bb.getMin().getX()).min().getAsDouble(),
                boundingBoxes.stream().mapToDouble(bb -> bb.getMin().getY()).min().getAsDouble(),
                boundingBoxes.stream().mapToDouble(bb -> bb.getMin().getZ()).min().getAsDouble());
        Vector3D max = new Vector3D(
                boundingBoxes.stream().mapToDouble(bb -> bb.getMax().getX()).max().getAsDouble(),
                boundingBoxes.stream().mapToDouble(bb -> bb.getMax().getY()).max().getAsDouble(),
                boundingBoxes.stream().mapToDouble(bb -> bb.getMax().getZ()).max().getAsDouble());
        this.boundingBox = new BoundingBox(min, max);
    }

    public static Building buildFromFile(File file) throws IOException {
        InputStream stream = new FileInputStream(file);
        BuildingLexer lexer = new BuildingLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        //Parse the token stream
        BuildingParser parser = new BuildingParser(tokenStream);
        BuildingParser.ProgramContext unit = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            return null;
        }

        //Build Abstract Syntax Tree (AST)
        BuildingBaseVisitor<AST> ASTBuilder = new BuildAstVisitor();
        AST ast = ASTBuilder.visitProgram(unit);

        return new Building(ast);
    }

    public void draw(GL2 gl, boolean highlighted, Vector3D position) {
        gl.glTranslated(translation.getX(), translation.getY(), translation.getZ());
        gl.glRotated(rotationAngle * 180 / Math.PI, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(-rotationTranslationDiff.getX(), -rotationTranslationDiff.getY(), -rotationTranslationDiff.getZ());
        for (Shape s : shapes) {
            s.draw(gl, highlighted, Util.preMultiplyVector3dMatrix(position.subtract(translation), Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J)).add(rotationTranslationDiff));
        }
        gl.glTranslated(rotationTranslationDiff.getX(), rotationTranslationDiff.getY(), rotationTranslationDiff.getZ());
        gl.glRotated(-rotationAngle * 180 / Math.PI, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(-translation.getX(), -translation.getY(), -translation.getZ());
    }

    public double getClosestHit(Vector3D startPoint, Vector3D direction) {
        Vector3D min = boundingBox.getMin();
        Vector3D max = boundingBox.getMax();

        startPoint = Util.preMultiplyVector3dMatrix(startPoint.subtract(translation), Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J)).add(rotationTranslationDiff);
        direction = Util.preMultiplyVector3dMatrix(direction, Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J));

        double result = Double.MAX_VALUE;

        result = Math.min(result, Util.getIntersectionDistance(startPoint, direction, min, new Vector3D(min.getX(), max.getY(), max.getZ()), new Vector3D(min.getX(), min.getY(), max.getZ()), Axis3D.X));
        result = Math.min(result, Util.getIntersectionDistance(startPoint, direction, new Vector3D(max.getX(), min.getY(), min.getZ()), max, new Vector3D(max.getX(), min.getY(), max.getZ()), Axis3D.X));

        result = Math.min(result, Util.getIntersectionDistance(startPoint, direction, min, new Vector3D(max.getX(), min.getY(), max.getZ()), new Vector3D(min.getX(), min.getY(), max.getZ()), Axis3D.Y));
        result = Math.min(result, Util.getIntersectionDistance(startPoint, direction, new Vector3D(min.getX(), max.getY(), min.getZ()), max, new Vector3D(min.getX(), max.getY(), max.getZ()), Axis3D.Y));

        result = Math.min(result, Util.getIntersectionDistance(startPoint, direction, min, new Vector3D(max.getX(), max.getY(), min.getZ()), new Vector3D(min.getX(), max.getY(), min.getZ()), Axis3D.Z));
        result = Math.min(result, Util.getIntersectionDistance(startPoint, direction, new Vector3D(min.getX(), min.getY(), max.getZ()), max, new Vector3D(min.getX(), max.getY(), max.getZ()), Axis3D.Z));

        return result;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public double getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;

        Vector3D midPointBefore = new Vector3D(
                (boundingBox.getMax().getX() - boundingBox.getMin().getX()) / 2,
                (boundingBox.getMax().getY() - boundingBox.getMin().getY()) / 2,
                (boundingBox.getMax().getZ() - boundingBox.getMin().getZ() / 2)
        );

        Vector3D midPointAfter = Util.preMultiplyVector3dMatrix(midPointBefore, Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J));

        this.rotationTranslationDiff = midPointAfter.subtract(midPointBefore);

        this.rotationTranslationDiff = Util.preMultiplyVector3dMatrix(this.rotationTranslationDiff, Util.createRotationMatrix(Math.PI / 2, Vector3D.PLUS_J));
    }

    public Vector3D getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3D translation) {
        this.translation = translation;
    }

    public AST getAst() {
        return ast;
    }

    public void setAst(AST ast) {
        this.ast = ast;
    }
}
