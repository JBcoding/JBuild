// Generated from /home/mathias/gitrepos/jbuild/src/main/antlr4/Building.g4 by ANTLR 4.8

    package building.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuildingParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, AXIS=23, LINE_COMMENT=24, 
		BLOCK_COMMENT=25, LPAREN=26, RPAREN=27, LBRACE=28, TILDE=29, RBRACE=30, 
		PERCENTAGE=31, COMMA=32, NUMBER=33, FACE=34, ASTERIX=35, COLON=36, DOT=37, 
		SEMICOLON=38, NAME=39, VARIABLE=40, WS=41, STRING=42, PLUS=43, MINUS=44, 
		DIVIDE=45, EQUALS=46, NOT_EQUALS=47, ASSIGN=48;
	public static final int
		RULE_program = 0, RULE_importStatement = 1, RULE_plotDecl = 2, RULE_shapeDeclaration = 3, 
		RULE_polyStatements = 4, RULE_polyCommand = 5, RULE_simpleCommand = 6, 
		RULE_assignment = 7, RULE_qualifiedName = 8, RULE_qualifiedVariable = 9, 
		RULE_qualifier = 10, RULE_polyFinalCommand = 11, RULE_extrudeCommand = 12, 
		RULE_faceDecl = 13, RULE_enclosedPolystatements = 14, RULE_splitCommand = 15, 
		RULE_splitRepeating = 16, RULE_splitDecl = 17, RULE_arguments = 18, RULE_ifCommand = 19, 
		RULE_expression = 20, RULE_value = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "importStatement", "plotDecl", "shapeDeclaration", "polyStatements", 
			"polyCommand", "simpleCommand", "assignment", "qualifiedName", "qualifiedVariable", 
			"qualifier", "polyFinalCommand", "extrudeCommand", "faceDecl", "enclosedPolystatements", 
			"splitCommand", "splitRepeating", "splitDecl", "arguments", "ifCommand", 
			"expression", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'as'", "'plot'", "'->'", "'color'", "'translate'", 
			"'translateG'", "'rotateX'", "'rotateY'", "'rotateZ'", "'rotatePX'", 
			"'rotatePY'", "'rotatePZ'", "'scale'", "'polygon'", "'oshape'", "'lshape'", 
			"'extrude'", "'split'", "'if'", "'true'", "'false'", null, null, null, 
			"'('", "')'", "'{'", "'~'", "'}'", "'%'", "','", null, null, "'*'", "':'", 
			"'.'", "';'", null, null, null, null, "'+'", "'-'", "'/'", "'=='", "'!='", 
			"':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "AXIS", 
			"LINE_COMMENT", "BLOCK_COMMENT", "LPAREN", "RPAREN", "LBRACE", "TILDE", 
			"RBRACE", "PERCENTAGE", "COMMA", "NUMBER", "FACE", "ASTERIX", "COLON", 
			"DOT", "SEMICOLON", "NAME", "VARIABLE", "WS", "STRING", "PLUS", "MINUS", 
			"DIVIDE", "EQUALS", "NOT_EQUALS", "ASSIGN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Building.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BuildingParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BuildingParser.EOF, 0); }
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<ShapeDeclarationContext> shapeDeclaration() {
			return getRuleContexts(ShapeDeclarationContext.class);
		}
		public ShapeDeclarationContext shapeDeclaration(int i) {
			return getRuleContext(ShapeDeclarationContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(BuildingParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(BuildingParser.SEMICOLON, i);
		}
		public List<PlotDeclContext> plotDecl() {
			return getRuleContexts(PlotDeclContext.class);
		}
		public PlotDeclContext plotDecl(int i) {
			return getRuleContext(PlotDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(44);
				importStatement();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NAME) | (1L << VARIABLE))) != 0)) {
				{
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(50);
					shapeDeclaration();
					}
					break;
				case 2:
					{
					setState(51);
					assignment();
					setState(52);
					match(SEMICOLON);
					}
					break;
				case 3:
					{
					setState(54);
					plotDecl();
					}
					break;
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BuildingParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(BuildingParser.NAME, 0); }
		public TerminalNode SEMICOLON() { return getToken(BuildingParser.SEMICOLON, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(63);
			match(STRING);
			setState(64);
			match(T__1);
			setState(65);
			match(NAME);
			setState(66);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlotDeclContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PlotDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plotDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPlotDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPlotDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPlotDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlotDeclContext plotDecl() throws RecognitionException {
		PlotDeclContext _localctx = new PlotDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_plotDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__2);
			setState(69);
			arguments();
			setState(70);
			match(T__3);
			setState(71);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShapeDeclarationContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BuildingParser.NAME, 0); }
		public PolyStatementsContext polyStatements() {
			return getRuleContext(PolyStatementsContext.class,0);
		}
		public ShapeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shapeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterShapeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitShapeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitShapeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeDeclarationContext shapeDeclaration() throws RecognitionException {
		ShapeDeclarationContext _localctx = new ShapeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shapeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(NAME);
			setState(74);
			match(T__3);
			setState(75);
			polyStatements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolyStatementsContext extends ParserRuleContext {
		public PolyStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polyStatements; }
	 
		public PolyStatementsContext() { }
		public void copyFrom(PolyStatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PolyStatementFinalContext extends PolyStatementsContext {
		public PolyFinalCommandContext polyFinalCommand() {
			return getRuleContext(PolyFinalCommandContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BuildingParser.SEMICOLON, 0); }
		public PolyStatementFinalContext(PolyStatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyStatementFinal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyStatementFinal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyStatementFinal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolyStatementSingleContext extends PolyStatementsContext {
		public PolyCommandContext polyCommand() {
			return getRuleContext(PolyCommandContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BuildingParser.SEMICOLON, 0); }
		public PolyStatementSingleContext(PolyStatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyStatementSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyStatementSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyStatementSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolyStatementsMultipleContext extends PolyStatementsContext {
		public PolyCommandContext polyCommand() {
			return getRuleContext(PolyCommandContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BuildingParser.SEMICOLON, 0); }
		public PolyStatementsContext polyStatements() {
			return getRuleContext(PolyStatementsContext.class,0);
		}
		public PolyStatementsMultipleContext(PolyStatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyStatementsMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyStatementsMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyStatementsMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyStatementsContext polyStatements() throws RecognitionException {
		PolyStatementsContext _localctx = new PolyStatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_polyStatements);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new PolyStatementsMultipleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				polyCommand();
				setState(78);
				match(SEMICOLON);
				setState(79);
				polyStatements();
				}
				break;
			case 2:
				_localctx = new PolyStatementSingleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				polyCommand();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(82);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 3:
				_localctx = new PolyStatementFinalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				polyFinalCommand();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(86);
					match(SEMICOLON);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolyCommandContext extends ParserRuleContext {
		public PolyCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polyCommand; }
	 
		public PolyCommandContext() { }
		public void copyFrom(PolyCommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PolyCommandAssignmentContext extends PolyCommandContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PolyCommandAssignmentContext(PolyCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyCommandAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyCommandAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyCommandAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolyCommandSimpleContext extends PolyCommandContext {
		public SimpleCommandContext simpleCommand() {
			return getRuleContext(SimpleCommandContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PolyCommandSimpleContext(PolyCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyCommandSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyCommandSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyCommandSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyCommandContext polyCommand() throws RecognitionException {
		PolyCommandContext _localctx = new PolyCommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_polyCommand);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
				_localctx = new PolyCommandSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				simpleCommand();
				setState(92);
				arguments();
				}
				break;
			case NAME:
			case VARIABLE:
				_localctx = new PolyCommandAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleCommandContext extends ParserRuleContext {
		public SimpleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterSimpleCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitSimpleCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSimpleCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCommandContext simpleCommand() throws RecognitionException {
		SimpleCommandContext _localctx = new SimpleCommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simpleCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public QualifiedVariableContext qualifiedVariable() {
			return getRuleContext(QualifiedVariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(BuildingParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			qualifiedVariable();
			setState(100);
			match(ASSIGN);
			setState(101);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public QualifierContext qualifier() {
			return getRuleContext(QualifierContext.class,0);
		}
		public TerminalNode NAME() { return getToken(BuildingParser.NAME, 0); }
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_qualifiedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			qualifier();
			setState(104);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedVariableContext extends ParserRuleContext {
		public QualifierContext qualifier() {
			return getRuleContext(QualifierContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(BuildingParser.VARIABLE, 0); }
		public QualifiedVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterQualifiedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitQualifiedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitQualifiedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedVariableContext qualifiedVariable() throws RecognitionException {
		QualifiedVariableContext _localctx = new QualifiedVariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_qualifiedVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			qualifier();
			setState(107);
			match(VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifierContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(BuildingParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(BuildingParser.NAME, i);
		}
		public List<TerminalNode> DOT() { return getTokens(BuildingParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(BuildingParser.DOT, i);
		}
		public QualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifierContext qualifier() throws RecognitionException {
		QualifierContext _localctx = new QualifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_qualifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(109);
				match(NAME);
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(110);
						match(DOT);
						setState(111);
						match(NAME);
						}
						} 
					}
					setState(116);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(117);
				match(DOT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolyFinalCommandContext extends ParserRuleContext {
		public PolyFinalCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polyFinalCommand; }
	 
		public PolyFinalCommandContext() { }
		public void copyFrom(PolyFinalCommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PolyExtrudeCommandContext extends PolyFinalCommandContext {
		public ExtrudeCommandContext extrudeCommand() {
			return getRuleContext(ExtrudeCommandContext.class,0);
		}
		public PolyExtrudeCommandContext(PolyFinalCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyExtrudeCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyExtrudeCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyExtrudeCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolySplitCommandContext extends PolyFinalCommandContext {
		public SplitCommandContext splitCommand() {
			return getRuleContext(SplitCommandContext.class,0);
		}
		public PolySplitCommandContext(PolyFinalCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolySplitCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolySplitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolySplitCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolyIfCommandContext extends PolyFinalCommandContext {
		public IfCommandContext ifCommand() {
			return getRuleContext(IfCommandContext.class,0);
		}
		public PolyIfCommandContext(PolyFinalCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyIfCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyIfCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyIfCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolyCommandNameContext extends PolyFinalCommandContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PolyCommandNameContext(PolyFinalCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterPolyCommandName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitPolyCommandName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyCommandName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyFinalCommandContext polyFinalCommand() throws RecognitionException {
		PolyFinalCommandContext _localctx = new PolyFinalCommandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_polyFinalCommand);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				_localctx = new PolyCommandNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				qualifiedName();
				}
				break;
			case T__17:
				_localctx = new PolyExtrudeCommandContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				extrudeCommand();
				}
				break;
			case T__18:
				_localctx = new PolySplitCommandContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				splitCommand();
				}
				break;
			case T__19:
				_localctx = new PolyIfCommandContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				ifCommand();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtrudeCommandContext extends ParserRuleContext {
		public ExtrudeCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extrudeCommand; }
	 
		public ExtrudeCommandContext() { }
		public void copyFrom(ExtrudeCommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExtrudeFullContext extends ExtrudeCommandContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(BuildingParser.LBRACE, 0); }
		public List<FaceDeclContext> faceDecl() {
			return getRuleContexts(FaceDeclContext.class);
		}
		public FaceDeclContext faceDecl(int i) {
			return getRuleContext(FaceDeclContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(BuildingParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BuildingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BuildingParser.COMMA, i);
		}
		public ExtrudeFullContext(ExtrudeCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExtrudeFull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExtrudeFull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExtrudeFull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtrudeSimpleContext extends ExtrudeCommandContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExtrudeSimpleContext(ExtrudeCommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExtrudeSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExtrudeSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExtrudeSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtrudeCommandContext extrudeCommand() throws RecognitionException {
		ExtrudeCommandContext _localctx = new ExtrudeCommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_extrudeCommand);
		int _la;
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ExtrudeSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(T__17);
				setState(127);
				arguments();
				}
				break;
			case 2:
				_localctx = new ExtrudeFullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__17);
				setState(129);
				arguments();
				setState(130);
				match(LBRACE);
				setState(131);
				faceDecl();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(132);
					match(COMMA);
					setState(133);
					faceDecl();
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(139);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FaceDeclContext extends ParserRuleContext {
		public TerminalNode FACE() { return getToken(BuildingParser.FACE, 0); }
		public TerminalNode COLON() { return getToken(BuildingParser.COLON, 0); }
		public EnclosedPolystatementsContext enclosedPolystatements() {
			return getRuleContext(EnclosedPolystatementsContext.class,0);
		}
		public FaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_faceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterFaceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitFaceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitFaceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FaceDeclContext faceDecl() throws RecognitionException {
		FaceDeclContext _localctx = new FaceDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_faceDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(FACE);
			setState(144);
			match(COLON);
			setState(145);
			enclosedPolystatements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnclosedPolystatementsContext extends ParserRuleContext {
		public PolyStatementsContext polyStatements() {
			return getRuleContext(PolyStatementsContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public EnclosedPolystatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosedPolystatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterEnclosedPolystatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitEnclosedPolystatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitEnclosedPolystatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnclosedPolystatementsContext enclosedPolystatements() throws RecognitionException {
		EnclosedPolystatementsContext _localctx = new EnclosedPolystatementsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enclosedPolystatements);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				polyStatements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				qualifiedName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplitCommandContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BuildingParser.LPAREN, 0); }
		public TerminalNode AXIS() { return getToken(BuildingParser.AXIS, 0); }
		public TerminalNode RPAREN() { return getToken(BuildingParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(BuildingParser.LBRACE, 0); }
		public List<SplitDeclContext> splitDecl() {
			return getRuleContexts(SplitDeclContext.class);
		}
		public SplitDeclContext splitDecl(int i) {
			return getRuleContext(SplitDeclContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(BuildingParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BuildingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BuildingParser.COMMA, i);
		}
		public SplitRepeatingContext splitRepeating() {
			return getRuleContext(SplitRepeatingContext.class,0);
		}
		public SplitCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterSplitCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitSplitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSplitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitCommandContext splitCommand() throws RecognitionException {
		SplitCommandContext _localctx = new SplitCommandContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_splitCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__18);
			setState(152);
			match(LPAREN);
			setState(153);
			match(AXIS);
			setState(154);
			match(RPAREN);
			setState(155);
			match(LBRACE);
			setState(156);
			splitDecl();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(157);
				match(COMMA);
				setState(158);
				splitDecl();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			match(RBRACE);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASTERIX) {
				{
				setState(165);
				splitRepeating();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplitRepeatingContext extends ParserRuleContext {
		public TerminalNode ASTERIX() { return getToken(BuildingParser.ASTERIX, 0); }
		public SplitRepeatingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitRepeating; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterSplitRepeating(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitSplitRepeating(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSplitRepeating(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitRepeatingContext splitRepeating() throws RecognitionException {
		SplitRepeatingContext _localctx = new SplitRepeatingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_splitRepeating);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(ASTERIX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplitDeclContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BuildingParser.COLON, 0); }
		public EnclosedPolystatementsContext enclosedPolystatements() {
			return getRuleContext(EnclosedPolystatementsContext.class,0);
		}
		public SplitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterSplitDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitSplitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSplitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitDeclContext splitDecl() throws RecognitionException {
		SplitDeclContext _localctx = new SplitDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_splitDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			expression(0);
			setState(171);
			match(COLON);
			setState(172);
			enclosedPolystatements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BuildingParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BuildingParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BuildingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BuildingParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LPAREN);
			setState(175);
			expression(0);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(176);
				match(COMMA);
				setState(177);
				expression(0);
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfCommandContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BuildingParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuildingParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(BuildingParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(BuildingParser.LBRACE, i);
		}
		public List<PolyStatementsContext> polyStatements() {
			return getRuleContexts(PolyStatementsContext.class);
		}
		public PolyStatementsContext polyStatements(int i) {
			return getRuleContext(PolyStatementsContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(BuildingParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(BuildingParser.RBRACE, i);
		}
		public IfCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterIfCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitIfCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitIfCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfCommandContext ifCommand() throws RecognitionException {
		IfCommandContext _localctx = new IfCommandContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__19);
			setState(186);
			match(LPAREN);
			setState(187);
			expression(0);
			setState(188);
			match(RPAREN);
			setState(189);
			match(LBRACE);
			setState(190);
			polyStatements();
			setState(191);
			match(RBRACE);
			setState(192);
			match(LBRACE);
			setState(193);
			polyStatements();
			setState(194);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionParContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BuildingParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BuildingParser.RPAREN, 0); }
		public ExpressionParContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionValContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExpressionValContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAddSubContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BuildingParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BuildingParser.MINUS, 0); }
		public ExpressionAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionPairContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(BuildingParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(BuildingParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(BuildingParser.RPAREN, 0); }
		public ExpressionPairContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionMulDivModContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASTERIX() { return getToken(BuildingParser.ASTERIX, 0); }
		public TerminalNode DIVIDE() { return getToken(BuildingParser.DIVIDE, 0); }
		public TerminalNode PERCENTAGE() { return getToken(BuildingParser.PERCENTAGE, 0); }
		public ExpressionMulDivModContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionFunctionCallContext extends ExpressionContext {
		public QualifiedVariableContext qualifiedVariable() {
			return getRuleContext(QualifiedVariableContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionFunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionEqNeqContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(BuildingParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(BuildingParser.NOT_EQUALS, 0); }
		public ExpressionEqNeqContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterExpressionEqNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitExpressionEqNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionEqNeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExpressionParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197);
				match(LPAREN);
				setState(198);
				expression(0);
				setState(199);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExpressionPairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(LPAREN);
				setState(202);
				expression(0);
				setState(203);
				match(COMMA);
				setState(204);
				expression(0);
				setState(205);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new ExpressionValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				value();
				}
				break;
			case 4:
				{
				_localctx = new ExpressionFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				qualifiedVariable();
				setState(209);
				arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(222);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMulDivModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(214);
						((ExpressionMulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PERCENTAGE) | (1L << ASTERIX) | (1L << DIVIDE))) != 0)) ) {
							((ExpressionMulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(217);
						((ExpressionAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionEqNeqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(220);
						((ExpressionEqNeqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQUALS) ) {
							((ExpressionEqNeqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValTrueContext extends ValueContext {
		public ValTrueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValNumberContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(BuildingParser.NUMBER, 0); }
		public ValNumberContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValVariableContext extends ValueContext {
		public TerminalNode VARIABLE() { return getToken(BuildingParser.VARIABLE, 0); }
		public ValVariableContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValPercentageContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(BuildingParser.NUMBER, 0); }
		public TerminalNode PERCENTAGE() { return getToken(BuildingParser.PERCENTAGE, 0); }
		public ValPercentageContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValPercentage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValPercentage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValPercentage(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValFractionContext extends ValueContext {
		public TerminalNode TILDE() { return getToken(BuildingParser.TILDE, 0); }
		public TerminalNode NUMBER() { return getToken(BuildingParser.NUMBER, 0); }
		public ValFractionContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValFraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValFalseContext extends ValueContext {
		public ValFalseContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValStringContext extends ValueContext {
		public TerminalNode STRING() { return getToken(BuildingParser.STRING, 0); }
		public ValStringContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).enterValString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuildingListener ) ((BuildingListener)listener).exitValString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new ValTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(T__20);
				}
				break;
			case 2:
				_localctx = new ValFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(T__21);
				}
				break;
			case 3:
				_localctx = new ValNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				match(NUMBER);
				}
				break;
			case 4:
				_localctx = new ValStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new ValPercentageContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				match(NUMBER);
				setState(232);
				match(PERCENTAGE);
				}
				break;
			case 6:
				_localctx = new ValFractionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(233);
				match(TILDE);
				setState(234);
				match(NUMBER);
				}
				break;
			case 7:
				_localctx = new ValVariableContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(235);
				match(VARIABLE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u00f1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\3\2\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6V\n\6\3\6\3\6\5\6Z\n\6\5\6\\\n\6\3\7\3\7\3\7\3\7\5\7b\n"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\7\f"+
		"s\n\f\f\f\16\fv\13\f\3\f\5\fy\n\f\3\r\3\r\3\r\3\r\5\r\177\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0089\n\16\f\16\16\16\u008c\13\16"+
		"\3\16\3\16\5\16\u0090\n\16\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u0098\n"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00a2\n\21\f\21\16\21"+
		"\u00a5\13\21\3\21\3\21\5\21\u00a9\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\7\24\u00b5\n\24\f\24\16\24\u00b8\13\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00d6"+
		"\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00e1\n\26\f\26"+
		"\16\26\u00e4\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00ef"+
		"\n\27\3\27\2\3*\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\6"+
		"\3\2\7\23\5\2!!%%//\3\2-.\3\2\60\61\2\u00fa\2\61\3\2\2\2\4@\3\2\2\2\6"+
		"F\3\2\2\2\bK\3\2\2\2\n[\3\2\2\2\fa\3\2\2\2\16c\3\2\2\2\20e\3\2\2\2\22"+
		"i\3\2\2\2\24l\3\2\2\2\26x\3\2\2\2\30~\3\2\2\2\32\u008f\3\2\2\2\34\u0091"+
		"\3\2\2\2\36\u0097\3\2\2\2 \u0099\3\2\2\2\"\u00aa\3\2\2\2$\u00ac\3\2\2"+
		"\2&\u00b0\3\2\2\2(\u00bb\3\2\2\2*\u00d5\3\2\2\2,\u00ee\3\2\2\2.\60\5\4"+
		"\3\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62;\3\2\2\2\63"+
		"\61\3\2\2\2\64:\5\b\5\2\65\66\5\20\t\2\66\67\7(\2\2\67:\3\2\2\28:\5\6"+
		"\4\29\64\3\2\2\29\65\3\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<"+
		">\3\2\2\2=;\3\2\2\2>?\7\2\2\3?\3\3\2\2\2@A\7\3\2\2AB\7,\2\2BC\7\4\2\2"+
		"CD\7)\2\2DE\7(\2\2E\5\3\2\2\2FG\7\5\2\2GH\5&\24\2HI\7\6\2\2IJ\5\22\n\2"+
		"J\7\3\2\2\2KL\7)\2\2LM\7\6\2\2MN\5\n\6\2N\t\3\2\2\2OP\5\f\7\2PQ\7(\2\2"+
		"QR\5\n\6\2R\\\3\2\2\2SU\5\f\7\2TV\7(\2\2UT\3\2\2\2UV\3\2\2\2V\\\3\2\2"+
		"\2WY\5\30\r\2XZ\7(\2\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[O\3\2\2\2[S\3\2"+
		"\2\2[W\3\2\2\2\\\13\3\2\2\2]^\5\16\b\2^_\5&\24\2_b\3\2\2\2`b\5\20\t\2"+
		"a]\3\2\2\2a`\3\2\2\2b\r\3\2\2\2cd\t\2\2\2d\17\3\2\2\2ef\5\24\13\2fg\7"+
		"\62\2\2gh\5*\26\2h\21\3\2\2\2ij\5\26\f\2jk\7)\2\2k\23\3\2\2\2lm\5\26\f"+
		"\2mn\7*\2\2n\25\3\2\2\2ot\7)\2\2pq\7\'\2\2qs\7)\2\2rp\3\2\2\2sv\3\2\2"+
		"\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wy\7\'\2\2xo\3\2\2\2xy\3\2\2"+
		"\2y\27\3\2\2\2z\177\5\22\n\2{\177\5\32\16\2|\177\5 \21\2}\177\5(\25\2"+
		"~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\31\3\2\2\2\u0080\u0081\7"+
		"\24\2\2\u0081\u0090\5&\24\2\u0082\u0083\7\24\2\2\u0083\u0084\5&\24\2\u0084"+
		"\u0085\7\36\2\2\u0085\u008a\5\34\17\2\u0086\u0087\7\"\2\2\u0087\u0089"+
		"\5\34\17\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2"+
		"\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e"+
		"\7 \2\2\u008e\u0090\3\2\2\2\u008f\u0080\3\2\2\2\u008f\u0082\3\2\2\2\u0090"+
		"\33\3\2\2\2\u0091\u0092\7$\2\2\u0092\u0093\7&\2\2\u0093\u0094\5\36\20"+
		"\2\u0094\35\3\2\2\2\u0095\u0098\5\n\6\2\u0096\u0098\5\22\n\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0096\3\2\2\2\u0098\37\3\2\2\2\u0099\u009a\7\25\2\2\u009a"+
		"\u009b\7\34\2\2\u009b\u009c\7\31\2\2\u009c\u009d\7\35\2\2\u009d\u009e"+
		"\7\36\2\2\u009e\u00a3\5$\23\2\u009f\u00a0\7\"\2\2\u00a0\u00a2\5$\23\2"+
		"\u00a1\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\7 \2\2\u00a7"+
		"\u00a9\5\"\22\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9!\3\2\2\2"+
		"\u00aa\u00ab\7%\2\2\u00ab#\3\2\2\2\u00ac\u00ad\5*\26\2\u00ad\u00ae\7&"+
		"\2\2\u00ae\u00af\5\36\20\2\u00af%\3\2\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00b6"+
		"\5*\26\2\u00b2\u00b3\7\"\2\2\u00b3\u00b5\5*\26\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\35\2\2\u00ba\'\3\2\2\2\u00bb\u00bc"+
		"\7\26\2\2\u00bc\u00bd\7\34\2\2\u00bd\u00be\5*\26\2\u00be\u00bf\7\35\2"+
		"\2\u00bf\u00c0\7\36\2\2\u00c0\u00c1\5\n\6\2\u00c1\u00c2\7 \2\2\u00c2\u00c3"+
		"\7\36\2\2\u00c3\u00c4\5\n\6\2\u00c4\u00c5\7 \2\2\u00c5)\3\2\2\2\u00c6"+
		"\u00c7\b\26\1\2\u00c7\u00c8\7\34\2\2\u00c8\u00c9\5*\26\2\u00c9\u00ca\7"+
		"\35\2\2\u00ca\u00d6\3\2\2\2\u00cb\u00cc\7\34\2\2\u00cc\u00cd\5*\26\2\u00cd"+
		"\u00ce\7\"\2\2\u00ce\u00cf\5*\26\2\u00cf\u00d0\7\35\2\2\u00d0\u00d6\3"+
		"\2\2\2\u00d1\u00d6\5,\27\2\u00d2\u00d3\5\24\13\2\u00d3\u00d4\5&\24\2\u00d4"+
		"\u00d6\3\2\2\2\u00d5\u00c6\3\2\2\2\u00d5\u00cb\3\2\2\2\u00d5\u00d1\3\2"+
		"\2\2\u00d5\u00d2\3\2\2\2\u00d6\u00e2\3\2\2\2\u00d7\u00d8\f\b\2\2\u00d8"+
		"\u00d9\t\3\2\2\u00d9\u00e1\5*\26\t\u00da\u00db\f\7\2\2\u00db\u00dc\t\4"+
		"\2\2\u00dc\u00e1\5*\26\b\u00dd\u00de\f\6\2\2\u00de\u00df\t\5\2\2\u00df"+
		"\u00e1\5*\26\7\u00e0\u00d7\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00dd\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"+\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00ef\7\27\2\2\u00e6\u00ef\7\30\2"+
		"\2\u00e7\u00ef\7#\2\2\u00e8\u00ef\7,\2\2\u00e9\u00ea\7#\2\2\u00ea\u00ef"+
		"\7!\2\2\u00eb\u00ec\7\37\2\2\u00ec\u00ef\7#\2\2\u00ed\u00ef\7*\2\2\u00ee"+
		"\u00e5\3\2\2\2\u00ee\u00e6\3\2\2\2\u00ee\u00e7\3\2\2\2\u00ee\u00e8\3\2"+
		"\2\2\u00ee\u00e9\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef"+
		"-\3\2\2\2\26\619;UY[atx~\u008a\u008f\u0097\u00a3\u00a8\u00b6\u00d5\u00e0"+
		"\u00e2\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}