package renderer;

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
    private String filePath;

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

    public String getFilePath() {
        return filePath;
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

        Building b = new Building(ast);
        b.filePath = file.getAbsolutePath();
        return b;
    }

    public void draw(GL2 gl, boolean highlighted, Vector3D position) {
        gl.glTranslated(translation.getX(), translation.getY(), translation.getZ());
        gl.glRotated(rotationAngle * 180 / Math.PI, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(-rotationTranslationDiff.getX(), -rotationTranslationDiff.getY(), -rotationTranslationDiff.getZ());
        for (Shape s : shapes) {
            s.draw(gl, highlighted, Util.preMultiplyVector3dMatrix(position.subtract(translation), Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J)).add(rotationTranslationDiff));
        }
        if (highlighted) {
            drawBoundingBox(gl);
            drawRotationRing(gl);
        }

        gl.glTranslated(rotationTranslationDiff.getX(), rotationTranslationDiff.getY(), rotationTranslationDiff.getZ());
        gl.glRotated(-rotationAngle * 180 / Math.PI, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(-translation.getX(), -translation.getY(), -translation.getZ());
    }

    private void drawBoundingBox(GL2 gl) {
        Vector3D bbMin = boundingBox.getMin();
        Vector3D bbMax = boundingBox.getMax();
        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMin.getY(), bbMin.getZ()), new Vector3D(bbMin.getX(), bbMin.getY(), bbMax.getZ()));
        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMax.getY(), bbMin.getZ()), new Vector3D(bbMin.getX(), bbMax.getY(), bbMax.getZ()));
        Util.drawLine(gl, new Vector3D(bbMax.getX(), bbMin.getY(), bbMin.getZ()), new Vector3D(bbMax.getX(), bbMin.getY(), bbMax.getZ()));
        Util.drawLine(gl, new Vector3D(bbMax.getX(), bbMax.getY(), bbMin.getZ()), new Vector3D(bbMax.getX(), bbMax.getY(), bbMax.getZ()));

        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMin.getY(), bbMin.getZ()), new Vector3D(bbMin.getX(), bbMax.getY(), bbMin.getZ()));
        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMin.getY(), bbMax.getZ()), new Vector3D(bbMin.getX(), bbMax.getY(), bbMax.getZ()));
        Util.drawLine(gl, new Vector3D(bbMax.getX(), bbMin.getY(), bbMin.getZ()), new Vector3D(bbMax.getX(), bbMax.getY(), bbMin.getZ()));
        Util.drawLine(gl, new Vector3D(bbMax.getX(), bbMin.getY(), bbMax.getZ()), new Vector3D(bbMax.getX(), bbMax.getY(), bbMax.getZ()));

        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMin.getY(), bbMin.getZ()), new Vector3D(bbMax.getX(), bbMin.getY(), bbMin.getZ()));
        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMax.getY(), bbMin.getZ()), new Vector3D(bbMax.getX(), bbMax.getY(), bbMin.getZ()));
        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMin.getY(), bbMax.getZ()), new Vector3D(bbMax.getX(), bbMin.getY(), bbMax.getZ()));
        Util.drawLine(gl, new Vector3D(bbMin.getX(), bbMax.getY(), bbMax.getZ()), new Vector3D(bbMax.getX(), bbMax.getY(), bbMax.getZ()));
    }

    private void drawRotationRing(GL2 gl) {
        Vector3D bbMin = boundingBox.getMin();
        Vector3D bbMax = boundingBox.getMax();

        int ringParts = 100;
        Vector3D centrum = (new Vector3D(bbMax.getX(), 0, bbMax.getZ())).subtract(new Vector3D(bbMin.getX(), 0, bbMin.getZ())).scalarMultiply(.5);
        double smallRadius = centrum.distance(Vector3D.ZERO) + 1;
        centrum = centrum.add(bbMin);
        double bigRadius = smallRadius + 1;

        gl.glColor3d(.6, .6, .6);
        for (int i = 0; i < ringParts; i++) {
            double fromAngle = Math.PI * 2 * i / ringParts;
            double toAngle = Math.PI * 2 * (i + 1) / ringParts;

            Vector3D p1 = new Vector3D(Math.cos(fromAngle), 0, Math.sin(fromAngle)).scalarMultiply(smallRadius);
            Vector3D p2 = new Vector3D(Math.cos(fromAngle), 0, Math.sin(fromAngle)).scalarMultiply(bigRadius);
            Vector3D p3 = new Vector3D(Math.cos(toAngle), 0, Math.sin(toAngle)).scalarMultiply(smallRadius);
            Vector3D p4 = new Vector3D(Math.cos(toAngle), 0, Math.sin(toAngle)).scalarMultiply(bigRadius);

            p1 = p1.add(centrum);
            p2 = p2.add(centrum);
            p3 = p3.add(centrum);
            p4 = p4.add(centrum);

            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glNormal3d(0, 1, 0);
            gl.glVertex3d(p1.getX(), p1.getY(), p1.getZ());

            gl.glNormal3d(0, 1, 0);
            gl.glVertex3d(p2.getX(), p2.getY(), p2.getZ());

            gl.glNormal3d(0, 1, 0);
            gl.glVertex3d(p3.getX(), p3.getY(), p3.getZ());

            gl.glNormal3d(0, 1, 0);
            gl.glVertex3d(p4.getX(), p4.getY(), p4.getZ());

            gl.glNormal3d(0, 1, 0);
            gl.glVertex3d(p2.getX(), p2.getY(), p2.getZ());

            gl.glNormal3d(0, 1, 0);
            gl.glVertex3d(p3.getX(), p3.getY(), p3.getZ());

            gl.glEnd();
        }
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

    public boolean isHittingRotationRing(Vector3D startPoint, Vector3D direction) {
        Vector3D min = boundingBox.getMin();
        Vector3D max = boundingBox.getMax();

        startPoint = Util.preMultiplyVector3dMatrix(startPoint.subtract(translation), Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J)).add(rotationTranslationDiff);
        direction = Util.preMultiplyVector3dMatrix(direction, Util.createRotationMatrix(rotationAngle, Vector3D.PLUS_J));

        Vector3D planeIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

        Vector3D centrum = (new Vector3D(max.getX(), 0, max.getZ())).subtract(new Vector3D(min.getX(), 0, min.getZ())).scalarMultiply(.5);
        double smallRadius = centrum.distance(Vector3D.ZERO) + 1;
        centrum = centrum.add(min);
        double bigRadius = smallRadius + 1;

        double distance = planeIntersectionPoint.distance(centrum);

        return distance < bigRadius;
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

    public Vector3D getCentrumOnPlane() {
        Vector3D bbMin = boundingBox.getMin();
        Vector3D bbMax = boundingBox.getMax();

        Vector3D centrum = (new Vector3D(bbMax.getX(), 0, bbMax.getZ())).subtract(new Vector3D(bbMin.getX(), 0, bbMin.getZ())).scalarMultiply(.5);
        centrum = centrum.add(bbMin);


        return Util.preMultiplyVector3dMatrix(centrum.subtract(rotationTranslationDiff), Util.createRotationMatrix(-rotationAngle, Vector3D.PLUS_J)).add(translation);
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