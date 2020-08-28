// Generated from /Users/madsbjoern/Documents/Git/JBuild/src/main/antlr4/Building.g4 by ANTLR 4.8
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
		T__17=18, AXIS=19, LPAREN=20, RPAREN=21, LBRACE=22, TILDE=23, RBRACE=24, 
		PERCENTAGE=25, COMMA=26, NUMBER=27, FACE=28, ASTERIX=29, COLON=30, DOT=31, 
		SEMICOLON=32, NAME=33, VARIABLE=34, WS=35, STRING=36, PLUS=37, MINUS=38, 
		DIVIDE=39, EQUALS=40, NOT_EQUALS=41, ASSIGN=42;
	public static final int
		RULE_program = 0, RULE_plotDecl = 1, RULE_shapeDeclaration = 2, RULE_polyStatements = 3, 
		RULE_polyCommand = 4, RULE_simpleCommand = 5, RULE_assignment = 6, RULE_polyFinalCommand = 7, 
		RULE_extrudeCommand = 8, RULE_faceDecl = 9, RULE_enclosedPolystatements = 10, 
		RULE_splitCommand = 11, RULE_splitRepeating = 12, RULE_splitDecl = 13, 
		RULE_arguments = 14, RULE_ifCommand = 15, RULE_expression = 16, RULE_value = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "plotDecl", "shapeDeclaration", "polyStatements", "polyCommand", 
			"simpleCommand", "assignment", "polyFinalCommand", "extrudeCommand", 
			"faceDecl", "enclosedPolystatements", "splitCommand", "splitRepeating", 
			"splitDecl", "arguments", "ifCommand", "expression", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'plot'", "'->'", "'color'", "'translate'", "'translateG'", "'rotateX'", 
			"'rotateY'", "'rotateZ'", "'rotatePX'", "'rotatePY'", "'rotatePZ'", "'scale'", 
			"'polygon'", "'extrude'", "'split'", "'if'", "'true'", "'false'", null, 
			"'('", "')'", "'{'", "'~'", "'}'", "'%'", "','", null, null, "'*'", "':'", 
			"'.'", "';'", null, null, null, null, "'+'", "'-'", "'/'", "'=='", "'!='", 
			"':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "AXIS", "LPAREN", "RPAREN", 
			"LBRACE", "TILDE", "RBRACE", "PERCENTAGE", "COMMA", "NUMBER", "FACE", 
			"ASTERIX", "COLON", "DOT", "SEMICOLON", "NAME", "VARIABLE", "WS", "STRING", 
			"PLUS", "MINUS", "DIVIDE", "EQUALS", "NOT_EQUALS", "ASSIGN"
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
		public PlotDeclContext plotDecl() {
			return getRuleContext(PlotDeclContext.class,0);
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
		public List<ShapeDeclarationContext> shapeDeclaration() {
			return getRuleContexts(ShapeDeclarationContext.class);
		}
		public ShapeDeclarationContext shapeDeclaration(int i) {
			return getRuleContext(ShapeDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VARIABLE) {
				{
				{
				setState(36);
				assignment();
				setState(37);
				match(SEMICOLON);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			plotDecl();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(45);
				shapeDeclaration();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PlotDeclContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode NAME() { return getToken(BuildingParser.NAME, 0); }
		public PlotDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plotDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPlotDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlotDeclContext plotDecl() throws RecognitionException {
		PlotDeclContext _localctx = new PlotDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_plotDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__0);
			setState(52);
			arguments();
			setState(53);
			match(T__1);
			setState(54);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitShapeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeDeclarationContext shapeDeclaration() throws RecognitionException {
		ShapeDeclarationContext _localctx = new ShapeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_shapeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(NAME);
			setState(57);
			match(T__1);
			setState(58);
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
		public PolyStatementFinalContext(PolyStatementsContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyStatementsMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyStatementsContext polyStatements() throws RecognitionException {
		PolyStatementsContext _localctx = new PolyStatementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_polyStatements);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new PolyStatementsMultipleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				polyCommand();
				setState(61);
				match(SEMICOLON);
				setState(62);
				polyStatements();
				}
				break;
			case 2:
				_localctx = new PolyStatementSingleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				polyCommand();
				setState(65);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new PolyStatementFinalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				polyFinalCommand();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyCommandSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyCommandContext polyCommand() throws RecognitionException {
		PolyCommandContext _localctx = new PolyCommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_polyCommand);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				_localctx = new PolyCommandSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				simpleCommand();
				setState(71);
				arguments();
				}
				break;
			case VARIABLE:
				_localctx = new PolyCommandAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSimpleCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCommandContext simpleCommand() throws RecognitionException {
		SimpleCommandContext _localctx = new SimpleCommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_simpleCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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
		public TerminalNode VARIABLE() { return getToken(BuildingParser.VARIABLE, 0); }
		public TerminalNode ASSIGN() { return getToken(BuildingParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(VARIABLE);
			setState(79);
			match(ASSIGN);
			setState(80);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyIfCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolyCommandNameContext extends PolyFinalCommandContext {
		public TerminalNode NAME() { return getToken(BuildingParser.NAME, 0); }
		public PolyCommandNameContext(PolyFinalCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitPolyCommandName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolyFinalCommandContext polyFinalCommand() throws RecognitionException {
		PolyFinalCommandContext _localctx = new PolyFinalCommandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_polyFinalCommand);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				_localctx = new PolyCommandNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(NAME);
				}
				break;
			case T__13:
				_localctx = new PolyExtrudeCommandContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				extrudeCommand();
				}
				break;
			case T__14:
				_localctx = new PolySplitCommandContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				splitCommand();
				}
				break;
			case T__15:
				_localctx = new PolyIfCommandContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExtrudeSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtrudeCommandContext extrudeCommand() throws RecognitionException {
		ExtrudeCommandContext _localctx = new ExtrudeCommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_extrudeCommand);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ExtrudeSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(T__13);
				setState(89);
				arguments();
				}
				break;
			case 2:
				_localctx = new ExtrudeFullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(T__13);
				setState(91);
				arguments();
				setState(92);
				match(LBRACE);
				setState(93);
				faceDecl();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(94);
					match(COMMA);
					setState(95);
					faceDecl();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitFaceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FaceDeclContext faceDecl() throws RecognitionException {
		FaceDeclContext _localctx = new FaceDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_faceDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(FACE);
			setState(106);
			match(COLON);
			setState(107);
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
		public TerminalNode NAME() { return getToken(BuildingParser.NAME, 0); }
		public EnclosedPolystatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosedPolystatements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitEnclosedPolystatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnclosedPolystatementsContext enclosedPolystatements() throws RecognitionException {
		EnclosedPolystatementsContext _localctx = new EnclosedPolystatementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enclosedPolystatements);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				polyStatements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(NAME);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSplitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitCommandContext splitCommand() throws RecognitionException {
		SplitCommandContext _localctx = new SplitCommandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_splitCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__14);
			setState(114);
			match(LPAREN);
			setState(115);
			match(AXIS);
			setState(116);
			match(RPAREN);
			setState(117);
			match(LBRACE);
			setState(118);
			splitDecl();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				splitDecl();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(RBRACE);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASTERIX) {
				{
				setState(127);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSplitRepeating(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitRepeatingContext splitRepeating() throws RecognitionException {
		SplitRepeatingContext _localctx = new SplitRepeatingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_splitRepeating);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitSplitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitDeclContext splitDecl() throws RecognitionException {
		SplitDeclContext _localctx = new SplitDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_splitDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			expression(0);
			setState(133);
			match(COLON);
			setState(134);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(LPAREN);
			setState(137);
			expression(0);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(138);
				match(COMMA);
				setState(139);
				expression(0);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitIfCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfCommandContext ifCommand() throws RecognitionException {
		IfCommandContext _localctx = new IfCommandContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__15);
			setState(148);
			match(LPAREN);
			setState(149);
			expression(0);
			setState(150);
			match(RPAREN);
			setState(151);
			match(LBRACE);
			setState(152);
			polyStatements();
			setState(153);
			match(RBRACE);
			setState(154);
			match(LBRACE);
			setState(155);
			polyStatements();
			setState(156);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitExpressionMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionFunctionCallContext extends ExpressionContext {
		public TerminalNode VARIABLE() { return getToken(BuildingParser.VARIABLE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionFunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ExpressionParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(159);
				match(LPAREN);
				setState(160);
				expression(0);
				setState(161);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExpressionPairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(LPAREN);
				setState(164);
				expression(0);
				setState(165);
				match(COMMA);
				setState(166);
				expression(0);
				setState(167);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new ExpressionValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				value();
				}
				break;
			case 4:
				{
				_localctx = new ExpressionFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(VARIABLE);
				setState(171);
				arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(183);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMulDivModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(175);
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
						setState(176);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(178);
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
						setState(179);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionEqNeqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(181);
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
						setState(182);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValNumberContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(BuildingParser.NUMBER, 0); }
		public ValNumberContext(ValueContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValFraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValFalseContext extends ValueContext {
		public ValFalseContext(ValueContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitValString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_value);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ValTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(T__16);
				}
				break;
			case 2:
				_localctx = new ValFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__17);
				}
				break;
			case 3:
				_localctx = new ValNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(NUMBER);
				}
				break;
			case 4:
				_localctx = new ValStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new ValPercentageContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(192);
				match(NUMBER);
				setState(193);
				match(PERCENTAGE);
				}
				break;
			case 6:
				_localctx = new ValFractionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				match(TILDE);
				setState(195);
				match(NUMBER);
				}
				break;
			case 7:
				_localctx = new ValVariableContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(196);
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
		case 16:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00ca\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\7\2\61\n\2\f\2"+
		"\16\2\64\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\5\tY\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nc\n\n\f\n"+
		"\16\nf\13\n\3\n\3\n\5\nj\n\n\3\13\3\13\3\13\3\13\3\f\3\f\5\fr\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\r\3\r\5\r\u0083"+
		"\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u008f\n\20"+
		"\f\20\16\20\u0092\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u00af\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u00ba\n\22\f\22\16\22\u00bd\13\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00c8\n\23\3\23\2\3\"\24\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$\2\6\3\2\5\17\5\2\33\33\37\37))\3\2\'(\3\2"+
		"*+\2\u00d1\2+\3\2\2\2\4\65\3\2\2\2\6:\3\2\2\2\bF\3\2\2\2\nL\3\2\2\2\f"+
		"N\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2\22i\3\2\2\2\24k\3\2\2\2\26q\3\2\2\2"+
		"\30s\3\2\2\2\32\u0084\3\2\2\2\34\u0086\3\2\2\2\36\u008a\3\2\2\2 \u0095"+
		"\3\2\2\2\"\u00ae\3\2\2\2$\u00c7\3\2\2\2&\'\5\16\b\2\'(\7\"\2\2(*\3\2\2"+
		"\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2.\62\5\4"+
		"\3\2/\61\5\6\4\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\3\3\2\2\2\64\62\3\2\2\2\65\66\7\3\2\2\66\67\5\36\20\2\678\7\4\2\2"+
		"89\7#\2\29\5\3\2\2\2:;\7#\2\2;<\7\4\2\2<=\5\b\5\2=\7\3\2\2\2>?\5\n\6\2"+
		"?@\7\"\2\2@A\5\b\5\2AG\3\2\2\2BC\5\n\6\2CD\7\"\2\2DG\3\2\2\2EG\5\20\t"+
		"\2F>\3\2\2\2FB\3\2\2\2FE\3\2\2\2G\t\3\2\2\2HI\5\f\7\2IJ\5\36\20\2JM\3"+
		"\2\2\2KM\5\16\b\2LH\3\2\2\2LK\3\2\2\2M\13\3\2\2\2NO\t\2\2\2O\r\3\2\2\2"+
		"PQ\7$\2\2QR\7,\2\2RS\5\"\22\2S\17\3\2\2\2TY\7#\2\2UY\5\22\n\2VY\5\30\r"+
		"\2WY\5 \21\2XT\3\2\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\21\3\2\2\2Z[\7\20"+
		"\2\2[j\5\36\20\2\\]\7\20\2\2]^\5\36\20\2^_\7\30\2\2_d\5\24\13\2`a\7\34"+
		"\2\2ac\5\24\13\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3"+
		"\2\2\2gh\7\32\2\2hj\3\2\2\2iZ\3\2\2\2i\\\3\2\2\2j\23\3\2\2\2kl\7\36\2"+
		"\2lm\7 \2\2mn\5\26\f\2n\25\3\2\2\2or\5\b\5\2pr\7#\2\2qo\3\2\2\2qp\3\2"+
		"\2\2r\27\3\2\2\2st\7\21\2\2tu\7\26\2\2uv\7\25\2\2vw\7\27\2\2wx\7\30\2"+
		"\2x}\5\34\17\2yz\7\34\2\2z|\5\34\17\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2"+
		"}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0082\7\32\2\2\u0081\u0083"+
		"\5\32\16\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\31\3\2\2\2\u0084"+
		"\u0085\7\37\2\2\u0085\33\3\2\2\2\u0086\u0087\5\"\22\2\u0087\u0088\7 \2"+
		"\2\u0088\u0089\5\26\f\2\u0089\35\3\2\2\2\u008a\u008b\7\26\2\2\u008b\u0090"+
		"\5\"\22\2\u008c\u008d\7\34\2\2\u008d\u008f\5\"\22\2\u008e\u008c\3\2\2"+
		"\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\27\2\2\u0094\37\3\2\2\2\u0095"+
		"\u0096\7\22\2\2\u0096\u0097\7\26\2\2\u0097\u0098\5\"\22\2\u0098\u0099"+
		"\7\27\2\2\u0099\u009a\7\30\2\2\u009a\u009b\5\b\5\2\u009b\u009c\7\32\2"+
		"\2\u009c\u009d\7\30\2\2\u009d\u009e\5\b\5\2\u009e\u009f\7\32\2\2\u009f"+
		"!\3\2\2\2\u00a0\u00a1\b\22\1\2\u00a1\u00a2\7\26\2\2\u00a2\u00a3\5\"\22"+
		"\2\u00a3\u00a4\7\27\2\2\u00a4\u00af\3\2\2\2\u00a5\u00a6\7\26\2\2\u00a6"+
		"\u00a7\5\"\22\2\u00a7\u00a8\7\34\2\2\u00a8\u00a9\5\"\22\2\u00a9\u00aa"+
		"\7\27\2\2\u00aa\u00af\3\2\2\2\u00ab\u00af\5$\23\2\u00ac\u00ad\7$\2\2\u00ad"+
		"\u00af\5\36\20\2\u00ae\u00a0\3\2\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00ab\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00bb\3\2\2\2\u00b0\u00b1\f\b\2\2\u00b1"+
		"\u00b2\t\3\2\2\u00b2\u00ba\5\"\22\t\u00b3\u00b4\f\7\2\2\u00b4\u00b5\t"+
		"\4\2\2\u00b5\u00ba\5\"\22\b\u00b6\u00b7\f\6\2\2\u00b7\u00b8\t\5\2\2\u00b8"+
		"\u00ba\5\"\22\7\u00b9\u00b0\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9\u00b6\3"+
		"\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"#\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c8\7\23\2\2\u00bf\u00c8\7\24\2"+
		"\2\u00c0\u00c8\7\35\2\2\u00c1\u00c8\7&\2\2\u00c2\u00c3\7\35\2\2\u00c3"+
		"\u00c8\7\33\2\2\u00c4\u00c5\7\31\2\2\u00c5\u00c8\7\35\2\2\u00c6\u00c8"+
		"\7$\2\2\u00c7\u00be\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c0\3\2\2\2\u00c7"+
		"\u00c1\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c7\u00c6\3\2"+
		"\2\2\u00c8%\3\2\2\2\21+\62FLXdiq}\u0082\u0090\u00ae\u00b9\u00bb\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}