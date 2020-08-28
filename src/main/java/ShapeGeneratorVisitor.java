import AST.*;
import javafx.util.Pair;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ShapeGeneratorVisitor implements ASTVisitor<List<Shape>> {
    Shape currentShape;
    Map<String, ShapeDeclarationNode> rulesMap;
    SymbolTable symbolTable = new SymbolTable();
    Random rnd = new Random();


    @Override
    public List<Shape> visit(SimpleCommandNode node) {
        node.getArguments().accept(this);
        switch (node.getCommand()) {
            case "color":
                double red = (Double)node.getArguments().getArguments().get(0).getValue();
                double green = (Double)node.getArguments().getArguments().get(1).getValue();
                double blue = (Double)node.getArguments().getArguments().get(2).getValue();
                currentShape.setColor(new Color((int)red, (int)green, (int)blue));
                break;
            case "translate":
                double x = (Double)node.getArguments().getArguments().get(0).getValue();
                double y = (Double)node.getArguments().getArguments().get(1).getValue();
                double z = (Double)node.getArguments().getArguments().get(2).getValue();
                currentShape.translate(new Vector3D(x, y, z));
                break;
            case "translateG":
                x = (Double)node.getArguments().getArguments().get(0).getValue();
                y = (Double)node.getArguments().getArguments().get(1).getValue();
                z = (Double)node.getArguments().getArguments().get(2).getValue();
                currentShape.translateGlobal(new Vector3D(x, y, z));
                break;
            case "rotateX":
                double amount = (Double)node.getArguments().getArguments().get(0).getValue();
                currentShape.rotateCenter(Vector3D.PLUS_I, amount * (Math.PI / 180));
                break;
            case "rotateY":
                amount = (Double)node.getArguments().getArguments().get(0).getValue();
                currentShape.rotateCenter(Vector3D.PLUS_J, amount * (Math.PI / 180));
                break;
            case "rotateZ":
                amount = (Double)node.getArguments().getArguments().get(0).getValue();
                currentShape.rotateCenter(Vector3D.PLUS_K, amount * (Math.PI / 180));
                break;
            case "rotatePX":
                amount = (Double)node.getArguments().getArguments().get(0).getValue();
                Pair<Double, Double> point = (Pair<Double, Double>)node.getArguments().getArguments().get(1).getValue();
                currentShape.rotateAroundPoint(Vector3D.PLUS_I, new Vector2D(point.getKey(), point.getValue()), amount * (Math.PI / 180));
                break;
            case "rotatePY":
                amount = (Double)node.getArguments().getArguments().get(0).getValue();
                point = (Pair<Double, Double>)node.getArguments().getArguments().get(1).getValue();
                currentShape.rotateAroundPoint(Vector3D.PLUS_J, new Vector2D(point.getKey(), point.getValue()), amount * (Math.PI / 180));
                break;
            case "rotatePZ":
                amount = (Double)node.getArguments().getArguments().get(0).getValue();
                point = (Pair<Double, Double>)node.getArguments().getArguments().get(1).getValue();
                currentShape.rotateAroundPoint(Vector3D.PLUS_K, new Vector2D(point.getKey(), point.getValue()), amount * (Math.PI / 180));
                break;
            case "scale":
                x = (Double)node.getArguments().getArguments().get(0).getValue();
                y = (Double)node.getArguments().getArguments().get(1).getValue();
                currentShape.scale(new Vector2D(x, y));
                break;
            case "polygon":
                List<Vector3D> coordinates = new ArrayList<>();
                for (ExpressionNode en : node.getArguments().getArguments()) {
                    Pair<Double, Double> p = (Pair<Double, Double>)en.getValue();
                    coordinates.add(new Vector3D(p.getKey(), p.getValue(), 0));
                }
                currentShape = new Polygon(currentShape, coordinates);
                break;
        }
        return new ArrayList<Shape>(){{add(currentShape);}};
    }

    @Override
    public List<Shape> visit(PolyStatementsNode node) {
        symbolTable.push();
        List<Shape> shapes = (List<Shape>) node.getCommand().accept(this);
        if (node.getNext() == null) {
            symbolTable.pop();
            return shapes;
        }
        List<Shape> remaining = (List<Shape>) node.getNext().accept(this);
        symbolTable.pop();
        return remaining;
    }

    @Override
    public List<Shape> visit(AssignmentNode assignmentNode) {
        assignmentNode.getExpression().accept(this);
        symbolTable.set(assignmentNode.getVariable(), assignmentNode.getExpression().getValue(), assignmentNode.getExpression().getType());
        return null;
    }

    @Override
    public List<Shape> visit(LiteralNode node) {
        return null;
    }

    @Override
    public List<Shape> visit(NotEqualNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.BOOL);

        // also works for pairs, since their equals also is cleverly implemented
        node.setValue(!node.getLeft().getValue().equals(node.getRight().getType()));

        if (node.getLeft().getType() == Type.NUMBER && node.getRight().getType() == Type.NUMBER) {
            node.setValue(!(Math.abs((Double)node.getLeft().getValue() - (Double)node.getRight().getValue()) < 0.00001d));
        }

        return null;
    }

    @Override
    public List<Shape> visit(EqualNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.BOOL);

        // also works for pairs, since their equals also is cleverly implemented
        node.setValue(node.getLeft().getValue().equals(node.getRight().getType()));

        if (node.getLeft().getType() == Type.NUMBER && node.getRight().getType() == Type.NUMBER) {
            node.setValue(Math.abs((Double)node.getLeft().getValue() - (Double)node.getRight().getValue()) < 0.00001d);
        }

        return null;
    }

    @Override
    public List<Shape> visit(AdditionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.NUMBER);
        node.setValue((double) node.getLeft().getValue() + (double) node.getRight().getValue());
        return null;
    }

    @Override
    public List<Shape> visit(SubtractionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.NUMBER);
        node.setValue((double) node.getLeft().getValue() - (double) node.getRight().getValue());
        return null;
    }

    @Override
    public List<Shape> visit(DivideNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.NUMBER);
        node.setValue((double) node.getLeft().getValue() / (double) node.getRight().getValue());
        return null;
    }

    @Override
    public List<Shape> visit(MultiplyNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.NUMBER);
        node.setValue((double) node.getLeft().getValue() * (double) node.getRight().getValue());
        return null;
    }

    @Override
    public List<Shape> visit(ModuloNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        node.setType(Type.NUMBER);
        node.setValue((int) node.getLeft().getValue() % (int) node.getRight().getValue());
        return null;
    }

    @Override
    public List<Shape> visit(ShapeDeclarationNode node) {
        return (List<Shape>) node.getStatements().accept(this);
    }

    @Override
    public List<Shape> visit(BuildingNode node) {
        List<Vector3D> coordinates = new ArrayList<>();
        for (ExpressionNode en : node.getCoordinates()) {
            en.accept(this);
            Pair<Double, Double> p = (Pair<Double, Double>)en.getValue();
            coordinates.add(new Vector3D(p.getKey(), p.getValue(), 0));
        }
        Polygon p = new Polygon(coordinates);
        // rotate from xy plane to xz plane
        p.setRotation(Util.createRotationMatrix(Math.PI / 2, new Vector3D(1, 0, 0)));
        currentShape = p;

        return (List<Shape>)rulesMap.get(node.getStartRule()).accept(this);
    }

    @Override
    public List<Shape> visit(ArgumentsNode node) {
        for (ExpressionNode en : node.getArguments()) {
            en.accept(this);
        }
        return null;
    }

    @Override
    public List<Shape> visit(ExtrudeCommandNode extrudeCommandNode) {
        extrudeCommandNode.getArgs().accept(this);
        double extrudeAmount = (double) extrudeCommandNode.getArgs().getArguments().get(0).getValue();
        List<Shape> shapes = currentShape.extrude(extrudeAmount);
        List<Shape> finalShapes = new ArrayList<>();
        for (Shape face : shapes) {
            symbolTable.set("_face_index", (double) face.getFaceIndex(), Type.NUMBER);
            boolean match = false;
            for (FaceDeclarationNode fdn : extrudeCommandNode.getFaces()) {
                if (face.getFaceType().toString().equals(fdn.getType().toString())) {
                    currentShape = face;
                    finalShapes.addAll((List<Shape>) fdn.getStatements().accept(this));
                    match = true;
                    break;
                }
            }
            if (!match) {
                finalShapes.add(face);
            }
        }
        return finalShapes;
    }

    @Override
    public List<Shape> visit(IfNode ifNode) {
        ifNode.getExpresion().accept(this);
        if (ifNode.getExpresion().getValue().equals((Boolean) true)) {
            return (List<Shape>) ifNode.getTrueBranch().accept(this);
        } else {
            return (List<Shape>) ifNode.getFalseBranch().accept(this);
        }
    }

    @Override
    public List<Shape> visit(PairNode pairNode) {
        pairNode.getLeft().accept(this);
        pairNode.getRight().accept(this);
        pairNode.setType(Type.PAIR);
        pairNode.setValue(new Pair<Double, Double>((Double) pairNode.getLeft().getValue(), (Double) pairNode.getRight().getValue()));
        return null;
    }

    @Override
    public List<Shape> visit(PolyNameCommandNode polyNameCommandNode) {
        if (rulesMap.containsKey(polyNameCommandNode.getName())) {
            return (List<Shape>) rulesMap.get(polyNameCommandNode.getName()).accept(this);
        } else {
            return new ArrayList<Shape>() {{add(currentShape);}};
        }
    }

    @Override
    public List<Shape> visit(VariableNode variableNode) {
        Pair<Object, Type> value = symbolTable.get(variableNode.getName());
        variableNode.setValue(value.getKey());
        variableNode.setType(value.getValue());
        return null;
    }

    @Override
    public List<Shape> visit(FaceDeclarationNode faceDeclarationNode) {
        return null;
    }

    @Override
    public List<Shape> visit(SplitDeclarationNode splitDeclarationNode) {
        return null;
    }

    @Override
    public List<Shape> visit(SplitCommandNode splitCommandNode) {
        Axis2D axis = splitCommandNode.getAxis() == Axis.X ? Axis2D.X : Axis2D.Y;
        UnitLength[] parts = new UnitLength[splitCommandNode.getSplits().size()];

        for (int i = 0; i < splitCommandNode.getSplits().size(); i++) {
            SplitDeclarationNode split = splitCommandNode.getSplits().get(i);
            split.getSize().accept(this);
            Unit u;
            switch (split.getSize().getType()) {
                case NUMBER:
                    u = Unit.METER;
                    break;
                case PERCENTAGE:
                    u = Unit.PERCENTAGE;
                    break;
                case FRACTION:
                    u = Unit.REM;
                    break;
                default:
                    throw new IllegalArgumentException("Opvaskemaskine <3");
            }

            double length = (double) split.getSize().getValue();
            UnitLength part = new UnitLength(length, u);

            parts[i] = part;
        }

        List<Shape> shapes = currentShape.split(axis, parts, splitCommandNode.isRepeat(), splitCommandNode.isIncludePartialSections());

        List<Shape> finalShapes = new ArrayList<>();
        for (int i = 0; i < shapes.size(); i ++) {
            Shape face = shapes.get(i);
            symbolTable.set("_split_index", (double) face.getSplitIndex(), Type.NUMBER);
            if (face.isPartial()) {
                finalShapes.add(face);
            } else {
                SplitDeclarationNode sdn = splitCommandNode.getSplits().get(i % splitCommandNode.getSplits().size());
                currentShape = face;
                finalShapes.addAll((List<Shape>) sdn.getStatements().accept(this));
            }
        }
        return finalShapes;
    }

    @Override
    public List<Shape> visit(FunctionCallNode functionCallNode) {
        functionCallNode.getArguments().accept(this);

        if (functionCallNode.getFunctionName().equals("random")) {
            double rangeMin = (double) functionCallNode.getArguments().getArguments().get(0).getValue();
            double rangeMax = (double) functionCallNode.getArguments().getArguments().get(1).getValue();
            functionCallNode.setValue(rangeMin + (rangeMax - rangeMin) * rnd.nextDouble());
        }
        return null;
    }

    @Override
    public List<Shape> visit(ProgramNode programNode) {
        symbolTable.push();
        List<Shape> shapes;
        rulesMap = new HashMap<>();
        for (ShapeDeclarationNode shapeDeclarationNode : programNode.getRules()) {
            rulesMap.put(shapeDeclarationNode.getName(), shapeDeclarationNode);
        }

        for (AssignmentNode as : programNode.getGlobalVariables()) {
            as.accept(this);
        }

        shapes = (List<Shape>)programNode.getBuilding().accept(this);

        return shapes;
    }
}
