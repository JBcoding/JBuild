package AST;

import building.antlr.BuildingBaseVisitor;
import building.antlr.BuildingLexer;
import building.antlr.BuildingParser;
import editor.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.filechooser.FileSystemView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BuildAstVisitor extends BuildingBaseVisitor<AST>  {

    String basePath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();

    public BuildAstVisitor() {
    }

    public BuildAstVisitor(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public AST visitProgram(BuildingParser.ProgramContext ctx) {
        ProgramNode program = new ProgramNode();

        List<AssignmentNode> assignments = new ArrayList<>();
        List<ShapeDeclarationNode> rules = new ArrayList<>();

        for (BuildingParser.ImportStatementContext importStatement : ctx.importStatement()) {
            ProgramNode importedProgram = (ProgramNode) importStatement.accept(this);
            assignments.addAll(importedProgram.getGlobalVariables());
            rules.addAll(importedProgram.getRules());
        }

        List<BuildingNode> buildings = new ArrayList<BuildingNode>();
        for (BuildingParser.PlotDeclContext plot : ctx.plotDecl()) {
            buildings.add((BuildingNode) plot.accept(this));
        }

        for (BuildingParser.ShapeDeclarationContext ruleCtx : ctx.shapeDeclaration()) {
            rules.add((ShapeDeclarationNode) ruleCtx.accept(this));
        }

        for (BuildingParser.AssignmentContext ruleCtx : ctx.assignment()) {
            assignments.add((AssignmentNode) ruleCtx.accept(this));
        }

        program.setBuildings(buildings);
        program.setRules(rules);
        program.setGlobalVariables(assignments);

        return program;
    }

    @Override
    public AST visitImportStatement(BuildingParser.ImportStatementContext ctx) {
        String fileName = ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1);

        Path filePath = Paths.get(basePath, fileName);

        BuildingLexer lexer = null;
        try {
            lexer = new BuildingLexer(CharStreams.fromStream(new FileInputStream(filePath.toString()), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BuildingParser parser = new BuildingParser(tokenStream);
        BuildingParser.ProgramContext unit = parser.program();
        String newBasePath = basePath;
        if (fileName.contains("/")) {
            List<String> list = new ArrayList<>(Arrays.asList(fileName.split("/")));
            list.remove(list.size() - 1);
            newBasePath = basePath + "/" + String.join("/", list);
        }

        BuildAstVisitor astCreator = new BuildAstVisitor(newBasePath);
        ProgramNode imported_program = (ProgramNode) unit.accept(astCreator);
        QualifyNamesVisitor qualifier = new QualifyNamesVisitor(ctx.NAME().getText());
        imported_program.accept(qualifier);

        return imported_program;
    }

    @Override
    public AST visitValVariable(BuildingParser.ValVariableContext ctx) {
        VariableNode variable = new VariableNode();
        variable.setName(ctx.getText());
        return variable;
    }

    @Override
    public AST visitPolyCommandAssignment(BuildingParser.PolyCommandAssignmentContext ctx) {
        return ctx.assignment().accept(this);
    }

    @Override
    public AST visitAssignment(BuildingParser.AssignmentContext ctx) {
        AssignmentNode node = new AssignmentNode();
        node.setVariable(ctx.qualifiedVariable().getText());
        node.setExpression((ExpressionNode) ctx.expression().accept(this));
        return node;
    }

    @Override
    public AST visitPlotDecl(BuildingParser.PlotDeclContext ctx) {
        BuildingNode building = new BuildingNode();
        building.setStartRule(ctx.qualifiedName().getText());

        ArgumentsNode args = (ArgumentsNode) ctx.arguments().accept(this);
        building.setCoordinates(args.getArguments());
        return building;
    }

    @Override
    public AST visitShapeDeclaration(BuildingParser.ShapeDeclarationContext ctx) {
        ShapeDeclarationNode node = new ShapeDeclarationNode();
        node.setName(ctx.NAME().getText());
        PolyStatementsNode stmts = (PolyStatementsNode) ctx.polyStatements().accept(this);
        node.setStatements(stmts);
        return node;
    }

    @Override
    public AST visitPolyStatementsMultiple(BuildingParser.PolyStatementsMultipleContext ctx) {
        PolyStatementsNode node = new PolyStatementsNode();
        PolyCommand command = (PolyCommand) ctx.polyCommand().accept(this);
        PolyStatementsNode next = (PolyStatementsNode) ctx.polyStatements().accept(this);

        node.setCommand(command);
        node.setNext(next);

        return node;
    }

    @Override
    public AST visitPolyStatementSingle(BuildingParser.PolyStatementSingleContext ctx) {
        PolyStatementsNode node = new PolyStatementsNode();
        node.setCommand((PolyCommand) ctx.polyCommand().accept(this));
        node.setNext(null);
        return node;
    }

    @Override
    public AST visitPolyStatementFinal(BuildingParser.PolyStatementFinalContext ctx) {
        PolyStatementsNode node = new PolyStatementsNode();
        node.setCommand((PolyCommand) ctx.polyFinalCommand().accept(this));
        node.setNext(null);
        return node;
    }

    @Override
    public AST visitPolyCommandName(BuildingParser.PolyCommandNameContext ctx) {
        PolyNameCommandNode node = new PolyNameCommandNode();
        node.setName(ctx.getText());
        return node;
    }

    @Override
    public AST visitPolyCommandSimple(BuildingParser.PolyCommandSimpleContext ctx) {
        SimpleCommandNode node = new SimpleCommandNode();
        node.setCommand(ctx.simpleCommand().getText());

        ArgumentsNode args = (ArgumentsNode) ctx.arguments().accept(this);
        node.setArguments(args);
        return node;
    }

    @Override
    public AST visitSimpleCommand(BuildingParser.SimpleCommandContext ctx) {
        return null;
    }


    @Override
    public AST visitExtrudeSimple(BuildingParser.ExtrudeSimpleContext ctx) {
        ExtrudeCommandNode node = new ExtrudeCommandNode();
        ArgumentsNode args = (ArgumentsNode) ctx.arguments().accept(this);
        node.setArgs(args);
        node.setFaces(new ArrayList<>());
        return node;
    }

    @Override
    public AST visitExtrudeFull(BuildingParser.ExtrudeFullContext ctx) {
        ExtrudeCommandNode node = new ExtrudeCommandNode();
        ArgumentsNode args = (ArgumentsNode) ctx.arguments().accept(this);

        List<FaceDeclarationNode> faces = new ArrayList<>();

        for (BuildingParser.FaceDeclContext childCtx : ctx.faceDecl()) {
            faces.add((FaceDeclarationNode) childCtx.accept(this));
        }

        node.setFaces(faces);
        node.setArgs(args);

        return node;
    }


    @Override
    public AST visitFaceDecl(BuildingParser.FaceDeclContext ctx) {
        FaceType ft;
        switch (ctx.FACE().getText()) {
            case "TOP":
                ft = FaceType.TOP;
                break;
            case "BOTTOM":
                ft = FaceType.BOTTOM;
                break;
            case "SIDE":
                ft = FaceType.SIDE;
                break;
            default:
                ft = FaceType.SIDE;
        }
        FaceDeclarationNode node = new FaceDeclarationNode();
        node.setType(ft);
        PolyStatementsNode statements = (PolyStatementsNode) ctx.enclosedPolystatements().accept(this);
        node.setStatements(statements);
        return node;
    }

    @Override
    public AST visitEnclosedPolystatements(BuildingParser.EnclosedPolystatementsContext ctx) {
        return ctx.polyStatements().accept(this);
    }

    @Override
    public AST visitSplitCommand(BuildingParser.SplitCommandContext ctx) {
        SplitCommandNode node = new SplitCommandNode();
        node.setRepeat(false);
        node.setIncludePartialSections(true);

        if (ctx.AXIS().getText().toLowerCase().equals("x")) {
            node.setAxis(Axis.X);
        } else {
            node.setAxis(Axis.Y);
        }

        List<SplitDeclarationNode> splits = new ArrayList<>();


        for (BuildingParser.SplitDeclContext childCtx : ctx.splitDecl()) {
            splits.add((SplitDeclarationNode) childCtx.accept(this));
        }

        node.setSplits(splits);
        if (ctx.splitRepeating() != null) {
            node.setRepeat(true);
        }
        return node;
    }

    @Override
    public AST visitSplitRepeating(BuildingParser.SplitRepeatingContext ctx) {
        return null;
    }

    @Override
    public AST visitSplitDecl(BuildingParser.SplitDeclContext ctx) {
        SplitDeclarationNode node = new SplitDeclarationNode();
        ExpressionNode size = (ExpressionNode) ctx.expression().accept(this);
        PolyStatementsNode statements = (PolyStatementsNode) ctx.enclosedPolystatements().accept(this);

        node.setSize(size);
        node.setStatements(statements);

        return node;
    }

    @Override
    public AST visitArguments(BuildingParser.ArgumentsContext ctx) {
        ArgumentsNode node = new ArgumentsNode();
        List<ExpressionNode> args = new ArrayList<>();
        for (ParseTree child : ctx.expression()){
            args.add((ExpressionNode) child.accept(this));
        }
        node.setArguments(args);

        return node;
    }

    @Override
    public AST visitIfCommand(BuildingParser.IfCommandContext ctx) {
        ExpressionNode expr = (ExpressionNode) ctx.expression().accept(this);
        PolyStatementsNode trueBranch = (PolyStatementsNode) ctx.polyStatements(0).accept(this);
        PolyStatementsNode falseBranch = (PolyStatementsNode) ctx.polyStatements(1).accept(this);

        IfNode node = new IfNode();
        node.setExpresion(expr);
        node.setTrueBranch(trueBranch);
        node.setFalseBranch(falseBranch);

        return node;
    }

    @Override
    public AST visitExpressionPar(BuildingParser.ExpressionParContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public AST visitExpressionVal(BuildingParser.ExpressionValContext ctx) {
        return ctx.value().accept(this);
    }

    @Override
    public AST visitExpressionAddSub(BuildingParser.ExpressionAddSubContext ctx) {
        ExpressionNode left = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode right = (ExpressionNode) ctx.expression(1).accept(this);

        BinaryOperationNode node;
        switch (ctx.op.getType()) {
            case BuildingParser.PLUS:
                node = new AdditionNode();
                break;
            case BuildingParser.MINUS:
                node = new SubtractionNode();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        }
        node.setLeft(left);
        node.setRight(right);

        return node;
    }

    @Override
    public AST visitExpressionPair(BuildingParser.ExpressionPairContext ctx) {
        PairNode node = new PairNode();

        ExpressionNode left = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode right = (ExpressionNode) ctx.expression(1).accept(this);

        node.setLeft(left);
        node.setRight(right);

        return node;
    }

    @Override
    public AST visitExpressionMulDivMod(BuildingParser.ExpressionMulDivModContext ctx) {
        ExpressionNode left = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode right = (ExpressionNode) ctx.expression(1).accept(this);

        BinaryOperationNode node;
        switch (ctx.op.getType()) {
            case BuildingParser.ASTERIX:
                node = new MultiplyNode();
                break;
            case BuildingParser.DIVIDE:
                node = new DivideNode();
                break;
            case BuildingParser.PERCENTAGE:
                node = new ModuloNode();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        }
        node.setLeft(left);
        node.setRight(right);

        return node;
    }

    @Override
    public AST visitExpressionFunctionCall(BuildingParser.ExpressionFunctionCallContext ctx) {
        FunctionCallNode function = new FunctionCallNode();
        function.setFunctionName(ctx.qualifiedVariable().getText());
        function.setArguments((ArgumentsNode) ctx.arguments().accept(this));
        return function;
    }

    @Override
    public AST visitExpressionEqNeq(BuildingParser.ExpressionEqNeqContext ctx) {
        ExpressionNode left = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode right = (ExpressionNode) ctx.expression(1).accept(this);

        BinaryOperationNode node;
        switch (ctx.op.getType()) {
            case BuildingParser.EQUALS:
                node = new EqualNode();
                break;
            case BuildingParser.NOT_EQUALS:
                node = new NotEqualNode();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ctx.op.getType());
        }
        node.setLeft(left);
        node.setRight(right);

        return node;
    }

    @Override
    public AST visitValTrue(BuildingParser.ValTrueContext ctx) {
        LiteralNode node = new LiteralNode();
        node.setType(Type.BOOL);
        node.setValue(false);
        return node;
    }

    @Override
    public AST visitValFalse(BuildingParser.ValFalseContext ctx) {
        LiteralNode node = new LiteralNode();
        node.setType(Type.BOOL);
        node.setValue(false);
        return node;
    }

    @Override
    public AST visitValNumber(BuildingParser.ValNumberContext ctx) {
        LiteralNode node = new LiteralNode();
        node.setType(Type.NUMBER);
        node.setValue(Double.parseDouble(ctx.NUMBER().toString()));
        return node;
    }

    @Override
    public AST visitValString(BuildingParser.ValStringContext ctx) {
        LiteralNode node = new LiteralNode();
        node.setType(Type.STRING);
        node.setValue(ctx.STRING().toString());
        return node;
    }

    @Override
    public AST visitValPercentage(BuildingParser.ValPercentageContext ctx) {
        LiteralNode node = new LiteralNode();
        node.setType(Type.PERCENTAGE);
        node.setValue(Double.parseDouble(ctx.NUMBER().toString()));
        return node;
    }

    @Override
    public AST visitValFraction(BuildingParser.ValFractionContext ctx) {
        LiteralNode node = new LiteralNode();
        node.setType(Type.FRACTION);
        node.setValue(Double.parseDouble(ctx.NUMBER().toString()));
        return node;
    }

    @Override
    public AST visitPolyExtrudeCommand(BuildingParser.PolyExtrudeCommandContext ctx) {
        return ctx.extrudeCommand().accept(this);
    }

    @Override
    public AST visitPolySplitCommand(BuildingParser.PolySplitCommandContext ctx) {
        return ctx.splitCommand().accept(this);
    }

    @Override
    public AST visitPolyIfCommand(BuildingParser.PolyIfCommandContext ctx) {
        return ctx.ifCommand().accept(this);
    }


}
