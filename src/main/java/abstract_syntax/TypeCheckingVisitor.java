package abstract_syntax;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import renderer.SymbolTable;

import java.util.*;
import java.util.stream.Collectors;

/* class is parameterised with a list of error messages */
public class TypeCheckingVisitor extends BaseVisitor<List<String>> {
    SymbolTable symbolTable = new SymbolTable();

    private enum DataType {
        PAIR, NUMBER, BOOL, STRING, PERCENTAGE, FRACTION, POLYGON, POLYHEDRON, SIZE;

        public static DataType fromType(Type t) {
            switch (t) {
                case PAIR:
                    return PAIR;
                case NUMBER:
                    return NUMBER;
                case BOOL:
                    return BOOL;
                case STRING:
                    return STRING;
                case PERCENTAGE:
                    return PERCENTAGE;
                case FRACTION:
                    return FRACTION;
                default:
                    throw new ValueException("Unexpected value for DataType");
            }
        }

        public Type toType() {
            switch (this) {
                case PAIR:
                    return Type.PAIR;
                case NUMBER:
                    return Type.NUMBER;
                case BOOL:
                    return Type.BOOL;
                case STRING:
                    return Type.STRING;
                case PERCENTAGE:
                    return Type.PERCENTAGE;
                case FRACTION:
                    return Type.FRACTION;
                default:
                    throw new ValueException("Unexpected value for Type");
            }
        }
    }

    private HashMap<AST, DataType> types = new HashMap<>();

    private DataType getType(AST node) {
       return types.get(node);
    }

    private void setType(AST node, DataType type) {
        types.put(node, type);
    }

    private boolean hasType(AST node, DataType ...  type) {
        return Arrays.asList(type).contains(types.get(node));
    }

    @Override
    public List<String> visit(SimpleCommandNode node) {
        Map<String, FunctionSignature> functions = new HashMap<>();

        functions.put("color", new FunctionSignature(new DataType[] {DataType.NUMBER, DataType.NUMBER, DataType.NUMBER}, DataType.POLYGON));
        functions.put("translate", new FunctionSignature(new DataType[] {DataType.NUMBER, DataType.NUMBER, DataType.NUMBER}, DataType.POLYGON));
        functions.put("translateG", new FunctionSignature(new DataType[] {DataType.NUMBER, DataType.NUMBER, DataType.NUMBER}, DataType.POLYGON));
        functions.put("rotateX", new FunctionSignature(new DataType[] {DataType.NUMBER}, DataType.POLYGON));
        functions.put("rotateY", new FunctionSignature(new DataType[] {DataType.NUMBER}, DataType.POLYGON));
        functions.put("rotateZ", new FunctionSignature(new DataType[] {DataType.NUMBER}, DataType.POLYGON));
        functions.put("rotatePX", new FunctionSignature(new DataType[] {DataType.PAIR, DataType.NUMBER}, DataType.POLYGON));
        functions.put("rotatePY", new FunctionSignature(new DataType[] {DataType.PAIR, DataType.NUMBER}, DataType.POLYGON));
        functions.put("rotatePZ", new FunctionSignature(new DataType[] {DataType.PAIR, DataType.NUMBER}, DataType.POLYGON));
        functions.put("scale", new FunctionSignature(new DataType[] {DataType.NUMBER}, DataType.POLYGON));
        functions.put("oshape", new FunctionSignature(new DataType[] {}, DataType.POLYHEDRON));
        functions.put("lshape", new FunctionSignature(new DataType[] {}, DataType.POLYHEDRON));

        // Handle polygon and lshape seperately

        if (node.getCommand().equals("polygon")) {
            return new ArrayList<>();
        } else if (node.getCommand().equals("lshape")) {
            return new ArrayList<>();
        } else {
            if (!functions.containsKey(node.getCommand())) {
                return new ArrayList<String>() {{add("Unknown function " + node.getCommand());}};
            }
            FunctionSignature signature = functions.get(node.getCommand());

            List<String> errs = new ArrayList<>();
            errs.addAll((List<String>) node.getArguments().accept(this));

            if (errs.size() > 0) {
                return errs;
            }

            int numberOfArgs = node.getArguments().getArguments().size();

            if (numberOfArgs != signature.getParameterTypes().length) {
                return new ArrayList<String>() {{add(String.format("Invalid number of parameters for function %s. Expected %d got %d.", node.getCommand(), signature.getParameterTypes().length, numberOfArgs));}};
            }

            for (int i = 0; i < numberOfArgs; i++) {
                ExpressionNode exp = node.getArguments().getArguments().get(i);
                if (!hasType(exp, signature.getParameterTypes()[i])) {
                    errs.add(String.format("Invalid argument. Expected type %s got %s.", signature.getParameterTypes()[i], getType(exp)));
                }
            }

            setType(node, signature.getReturnType());

            return errs;
        }

    }

    @Override
    public List<String> visit(PolyStatementsNode node) {
        symbolTable.push();
        List<String> errs = (List<String>) node.getCommand().accept(this);
        if (errs.size() > 0) {
            return errs;
        }
        if (node.getNext() == null) {
            symbolTable.pop();
            return errs;
        } /*else if (hasType(node.getCommand(), DataType.POLYHEDRON)) {
            symbolTable.pop();
            return new ArrayList<String>() {{ add("Unexpected continuation on polyhedron shape"); }};
            TODO: Handle case where next command is extrude or split

        } */ else {
            errs.addAll((List<String>) node.getNext().accept(this));
            symbolTable.pop();
        }
        return errs;
    }

    @Override
    public List<String> visit(LiteralNode node) {
        setType(node, DataType.fromType(node.getType()));
        return new ArrayList<>();
    }

    private List<String> checkBinaryOperator(AST left, AST right, DataType[] supported_types, String operator) {
        List<String> errLeft = (List<String>) left.accept(this);
        List<String> errRight = (List<String>) right.accept(this);

        if (errLeft.size() > 0) return errLeft;
        if (errRight.size() > 0) return errLeft;

        DataType tLeft = getType(left);
        DataType tRight = getType(right);

        if (tLeft != tRight) {
            return new ArrayList<String>() {{add("Left and right side arguments of '" + operator + "' doesn't match");}};
        }

        if (Arrays.asList(supported_types).contains(tLeft)) {
            return new ArrayList<>();
        } else {
            return new ArrayList<String>() {{add("Invalid operands for '" + operator + "'. Supported types are " + Arrays.stream(supported_types).map(DataType::toString).collect(Collectors.joining(", ")));}};
        }
    }

    @Override
    public List<String> visit(NotEqualNode node) {
        setType(node, DataType.BOOL);
        return checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER, DataType.PAIR, DataType.BOOL, DataType.STRING}, "!=");
    }


    @Override
    public List<String> visit(EqualNode node) {
        setType(node, DataType.BOOL);
        return checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER, DataType.PAIR, DataType.BOOL, DataType.STRING}, "==");
    }

    @Override
    public List<String> visit(AdditionNode node) {
        List<String> errs = checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER, DataType.STRING}, "+");
        if (hasType(node.getLeft(), DataType.STRING)) {
            setType(node, DataType.STRING);
        } else {
            setType(node, DataType.NUMBER);
        }
        return errs;
    }

    @Override
    public List<String> visit(SubtractionNode node) {
        setType(node, DataType.NUMBER);
        return checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER}, "-");
    }

    @Override
    public List<String> visit(DivideNode node) {
        setType(node, DataType.NUMBER);
        return checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER}, "/");
    }

    @Override
    public List<String> visit(MultiplyNode node) {
        setType(node, DataType.NUMBER);
        return checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER}, "*");
    }

    @Override
    public List<String> visit(ModuloNode node) {
        setType(node, DataType.NUMBER);
        return checkBinaryOperator(node.getLeft(), node.getRight(), new DataType[]{DataType.NUMBER}, "%");
    }

    @Override
    public List<String> visit(ShapeDeclarationNode node) {
        return (List<String>) node.getStatements().accept(this);
    }

    private List<String> checkExpressionList(List<ExpressionNode> exprs) {
        List<String> errs = new ArrayList<>();
        for (ExpressionNode exp : exprs) {
            errs.addAll((List<String>) exp.accept(this));
        }
        return errs;
    }

    @Override
    public List<String> visit(BuildingNode node) {
        return checkExpressionList(node.getCoordinates());
    }

    @Override
    public List<String> visit(ArgumentsNode node) {
        return checkExpressionList(node.getArguments());
    }

    @Override
    public List<String> visit(ExtrudeCommandNode extrudeCommandNode) {
        List<String> errs = (List<String>) extrudeCommandNode.getArgs().accept(this);
        if (errs.size() > 0) return errs;
        extrudeCommandNode.getFaces().forEach(x -> errs.addAll((List<String>) x.accept(this)));
        return errs;
    }

    @Override
    public List<String> visit(IfNode ifNode) {
        List<String> errs = (List<String>) ifNode.getExpresion().accept(this);
        if (errs.size() > 0) {
            return errs;
        }
        if (!hasType(ifNode.getExpresion(), DataType.BOOL)) {
            return new ArrayList<String>() {{ add("Invalid type for if expression. Expression must be BOOL instead of " + getType(ifNode.getExpresion())); }};
        }

        errs.addAll((List<String>) ifNode.getTrueBranch().accept(this));
        errs.addAll((List<String>) ifNode.getFalseBranch().accept(this));

        return errs;
    }

    @Override
    public List<String> visit(PairNode pairNode) {
        List<String> errs = (List<String>) pairNode.getLeft().accept(this);
        errs.addAll((List<String>) pairNode.getRight().accept(this));
        return errs;
    }

    @Override
    public List<String> visit(PolyNameCommandNode polyNameCommandNode) {
        return new ArrayList<>();
    }

    @Override
    public List<String> visit(FaceDeclarationNode faceDeclarationNode) {
        return (List<String>) faceDeclarationNode.getStatements().accept(this);
    }

    @Override
    public List<String> visit(SplitDeclarationNode splitDeclarationNode) {
        List<String> errs = (List<String>) splitDeclarationNode.getSize().accept(this);
        if (errs.size() > 0) return errs;
        if (!hasType(splitDeclarationNode.getSize(), DataType.PERCENTAGE, DataType.FRACTION, DataType.NUMBER)) {
            return new ArrayList<String>() {{add("Invalid split size. Must be percentage, fraction or a number");}};
        }
        return (List<String>) splitDeclarationNode.getStatements().accept(this);
    }

    @Override
    public List<String> visit(SplitCommandNode splitCommandNode) {
        List<String> errs = new ArrayList<>();
        splitCommandNode.getSplits().forEach(x -> errs.addAll((List<String>) x.accept(this)));
        return errs;
    }

    @Override
    public List<String> visit(ProgramNode programNode) {
        symbolTable.push();
        symbolTable.set("_face_index", null, DataType.NUMBER.toType());
        symbolTable.set("_split_index", null, DataType.NUMBER.toType());
        List<String> errs = new ArrayList<>();
        programNode.getBuildings().forEach(x -> errs.addAll((List<String>) x.accept(this)));
        programNode.getGlobalVariables().forEach(x -> errs.addAll((List<String>) x.accept(this)));
        programNode.getRules().forEach(x -> errs.addAll((List<String>) x.accept(this)));
        return errs;
    }

    @Override
    public List<String> visit(VariableNode variableNode) {
        try {
            DataType type = DataType.fromType(symbolTable.get(variableNode.getName()).getValue());
            setType(variableNode, type);
        } catch (IllegalStateException e) {
            return new ArrayList<String>() {{add("Unknown variable " + variableNode.getName());}};
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> visit(AssignmentNode assignmentNode) {
        List<String> errs = (List<String>) assignmentNode.getExpression().accept(this);
        if (errs.size() > 0) {
            return errs;
        }
        symbolTable.set(assignmentNode.getVariable(), null, getType(assignmentNode.getExpression()).toType());
        return errs;
    }

    @Override
    public List<String> visit(FunctionCallNode functionCallNode) {
        Map<String, FunctionSignature> functions = new HashMap<>();

        functions.put("random", new FunctionSignature(new DataType[] {DataType.NUMBER, DataType.NUMBER}, DataType.NUMBER));

        if (!functions.containsKey(functionCallNode.getFunctionName())) {
            return new ArrayList<String>() {{add("Unknown function " + functionCallNode.getFunctionName());}};
        }
        FunctionSignature signature = functions.get(functionCallNode.getFunctionName());

        List<String> errs = new ArrayList<>();
        errs.addAll((List<String>) functionCallNode.getArguments().accept(this));

        if (errs.size() > 0) {
            return errs;
        }

        int numberOfArgs = functionCallNode.getArguments().getArguments().size();

        if (numberOfArgs != signature.getParameterTypes().length) {
            return new ArrayList<String>() {{add(String.format("Invalid number of parameters for function %s. Expected %d got %d.", functionCallNode.getFunctionName(), signature.getParameterTypes().length, numberOfArgs));}};
        }

        for (int i = 0; i < numberOfArgs; i++) {
            ExpressionNode exp = functionCallNode.getArguments().getArguments().get(i);
            if (!hasType(exp, signature.getParameterTypes()[i])) {
                errs.add(String.format("Invalid argument. Expected type %s got %s.", signature.getParameterTypes()[i], getType(exp)));
            }
        }

        setType(functionCallNode, signature.getReturnType());

        return errs;
    }

    private class FunctionSignature {
        private DataType returnType;
        private DataType[] parameterTypes;

        public FunctionSignature(DataType[] parameterTypes, DataType returnType) {
            this.returnType = returnType;
            this.parameterTypes = parameterTypes;
        }

        public DataType getReturnType() {
            return returnType;
        }

        public void setReturnType(DataType returnType) {
            this.returnType = returnType;
        }

        public DataType[] getParameterTypes() {
            return parameterTypes;
        }

        public void setParameterTypes(DataType[] parameterTypes) {
            this.parameterTypes = parameterTypes;
        }
    }
}
