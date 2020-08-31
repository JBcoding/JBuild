// Generated from /home/mathias/gitrepos/jbuild/src/main/antlr4/Building.g4 by ANTLR 4.8

    package building.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuildingLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, AXIS=21, LINE_COMMENT=22, BLOCK_COMMENT=23, 
		LPAREN=24, RPAREN=25, LBRACE=26, TILDE=27, RBRACE=28, PERCENTAGE=29, COMMA=30, 
		NUMBER=31, FACE=32, ASTERIX=33, COLON=34, DOT=35, SEMICOLON=36, NAME=37, 
		VARIABLE=38, WS=39, STRING=40, PLUS=41, MINUS=42, DIVIDE=43, EQUALS=44, 
		NOT_EQUALS=45, ASSIGN=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "AXIS", "LINE_COMMENT", "BLOCK_COMMENT", "LPAREN", 
			"RPAREN", "LBRACE", "TILDE", "RBRACE", "PERCENTAGE", "COMMA", "NUMBER", 
			"FACE", "ASTERIX", "COLON", "DOT", "SEMICOLON", "NAME", "VARIABLE", "WS", 
			"STRING", "PLUS", "MINUS", "DIVIDE", "EQUALS", "NOT_EQUALS", "ASSIGN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'as'", "'plot'", "'->'", "'color'", "'translate'", 
			"'translateG'", "'rotateX'", "'rotateY'", "'rotateZ'", "'rotatePX'", 
			"'rotatePY'", "'rotatePZ'", "'scale'", "'polygon'", "'extrude'", "'split'", 
			"'if'", "'true'", "'false'", null, null, null, "'('", "')'", "'{'", "'~'", 
			"'}'", "'%'", "','", null, null, "'*'", "':'", "'.'", "';'", null, null, 
			null, null, "'+'", "'-'", "'/'", "'=='", "'!='", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "AXIS", "LINE_COMMENT", 
			"BLOCK_COMMENT", "LPAREN", "RPAREN", "LBRACE", "TILDE", "RBRACE", "PERCENTAGE", 
			"COMMA", "NUMBER", "FACE", "ASTERIX", "COLON", "DOT", "SEMICOLON", "NAME", 
			"VARIABLE", "WS", "STRING", "PLUS", "MINUS", "DIVIDE", "EQUALS", "NOT_EQUALS", 
			"ASSIGN"
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


	public BuildingLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Building.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0170\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00f0\n\27\f\27\16\27\u00f3"+
		"\13\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u00fb\n\30\f\30\16\30\u00fe"+
		"\13\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \5 \u0114\n \3 \3 \3 \7 \u0119\n \f "+
		"\16 \u011c\13 \3 \6 \u011f\n \r \16 \u0120\3 \3 \6 \u0125\n \r \16 \u0126"+
		"\5 \u0129\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0138\n!\3\"\3"+
		"\"\3#\3#\3$\3$\3%\3%\3&\3&\7&\u0144\n&\f&\16&\u0147\13&\3\'\3\'\7\'\u014b"+
		"\n\'\f\'\16\'\u014e\13\'\3(\6(\u0151\n(\r(\16(\u0152\3(\3(\3)\3)\3)\3"+
		")\7)\u015b\n)\f)\16)\u015e\13)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3."+
		"\3.\3/\3/\3/\3\u00fc\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\f"+
		"\4\2Z\\z|\4\2\f\f\17\17\3\2\63;\3\2\62;\3\2C\\\6\2\62;C\\aac|\4\2aac|"+
		"\4\2\13\f\"\"\4\2$$^^\6\2\f\f\17\17$$^^\2\u017e\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5f\3\2\2\2\7i\3\2\2\2\tn\3"+
		"\2\2\2\13q\3\2\2\2\rw\3\2\2\2\17\u0081\3\2\2\2\21\u008c\3\2\2\2\23\u0094"+
		"\3\2\2\2\25\u009c\3\2\2\2\27\u00a4\3\2\2\2\31\u00ad\3\2\2\2\33\u00b6\3"+
		"\2\2\2\35\u00bf\3\2\2\2\37\u00c5\3\2\2\2!\u00cd\3\2\2\2#\u00d5\3\2\2\2"+
		"%\u00db\3\2\2\2\'\u00de\3\2\2\2)\u00e3\3\2\2\2+\u00e9\3\2\2\2-\u00eb\3"+
		"\2\2\2/\u00f6\3\2\2\2\61\u0104\3\2\2\2\63\u0106\3\2\2\2\65\u0108\3\2\2"+
		"\2\67\u010a\3\2\2\29\u010c\3\2\2\2;\u010e\3\2\2\2=\u0110\3\2\2\2?\u0113"+
		"\3\2\2\2A\u0137\3\2\2\2C\u0139\3\2\2\2E\u013b\3\2\2\2G\u013d\3\2\2\2I"+
		"\u013f\3\2\2\2K\u0141\3\2\2\2M\u0148\3\2\2\2O\u0150\3\2\2\2Q\u0156\3\2"+
		"\2\2S\u0161\3\2\2\2U\u0163\3\2\2\2W\u0165\3\2\2\2Y\u0167\3\2\2\2[\u016a"+
		"\3\2\2\2]\u016d\3\2\2\2_`\7k\2\2`a\7o\2\2ab\7r\2\2bc\7q\2\2cd\7t\2\2d"+
		"e\7v\2\2e\4\3\2\2\2fg\7c\2\2gh\7u\2\2h\6\3\2\2\2ij\7r\2\2jk\7n\2\2kl\7"+
		"q\2\2lm\7v\2\2m\b\3\2\2\2no\7/\2\2op\7@\2\2p\n\3\2\2\2qr\7e\2\2rs\7q\2"+
		"\2st\7n\2\2tu\7q\2\2uv\7t\2\2v\f\3\2\2\2wx\7v\2\2xy\7t\2\2yz\7c\2\2z{"+
		"\7p\2\2{|\7u\2\2|}\7n\2\2}~\7c\2\2~\177\7v\2\2\177\u0080\7g\2\2\u0080"+
		"\16\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083\7t\2\2\u0083\u0084\7c\2\2\u0084"+
		"\u0085\7p\2\2\u0085\u0086\7u\2\2\u0086\u0087\7n\2\2\u0087\u0088\7c\2\2"+
		"\u0088\u0089\7v\2\2\u0089\u008a\7g\2\2\u008a\u008b\7I\2\2\u008b\20\3\2"+
		"\2\2\u008c\u008d\7t\2\2\u008d\u008e\7q\2\2\u008e\u008f\7v\2\2\u008f\u0090"+
		"\7c\2\2\u0090\u0091\7v\2\2\u0091\u0092\7g\2\2\u0092\u0093\7Z\2\2\u0093"+
		"\22\3\2\2\2\u0094\u0095\7t\2\2\u0095\u0096\7q\2\2\u0096\u0097\7v\2\2\u0097"+
		"\u0098\7c\2\2\u0098\u0099\7v\2\2\u0099\u009a\7g\2\2\u009a\u009b\7[\2\2"+
		"\u009b\24\3\2\2\2\u009c\u009d\7t\2\2\u009d\u009e\7q\2\2\u009e\u009f\7"+
		"v\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3"+
		"\7\\\2\2\u00a3\26\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\u00a7\7v\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7g\2\2"+
		"\u00aa\u00ab\7R\2\2\u00ab\u00ac\7Z\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7"+
		"t\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2"+
		"\7v\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7R\2\2\u00b4\u00b5\7[\2\2\u00b5"+
		"\32\3\2\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7v\2\2\u00b9"+
		"\u00ba\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7R\2\2"+
		"\u00bd\u00be\7\\\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7"+
		"e\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7g\2\2\u00c4\36"+
		"\3\2\2\2\u00c5\u00c6\7r\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7n\2\2\u00c8"+
		"\u00c9\7{\2\2\u00c9\u00ca\7i\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7p\2\2"+
		"\u00cc \3\2\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7z\2\2\u00cf\u00d0\7v\2"+
		"\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7f\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\"\3\2\2\2\u00d5\u00d6\7u\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8"+
		"\7n\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7v\2\2\u00da$\3\2\2\2\u00db\u00dc"+
		"\7k\2\2\u00dc\u00dd\7h\2\2\u00dd&\3\2\2\2\u00de\u00df\7v\2\2\u00df\u00e0"+
		"\7t\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7g\2\2\u00e2(\3\2\2\2\u00e3\u00e4"+
		"\7h\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7u\2\2\u00e7"+
		"\u00e8\7g\2\2\u00e8*\3\2\2\2\u00e9\u00ea\t\2\2\2\u00ea,\3\2\2\2\u00eb"+
		"\u00ec\7\61\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00f1\3\2\2\2\u00ee\u00f0\n"+
		"\3\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\b\27"+
		"\2\2\u00f5.\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7\u00f8\7,\2\2\u00f8\u00fc"+
		"\3\2\2\2\u00f9\u00fb\13\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2"+
		"\u00fc\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc"+
		"\3\2\2\2\u00ff\u0100\7,\2\2\u0100\u0101\7\61\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0103\b\30\2\2\u0103\60\3\2\2\2\u0104\u0105\7*\2\2\u0105\62\3\2\2\2\u0106"+
		"\u0107\7+\2\2\u0107\64\3\2\2\2\u0108\u0109\7}\2\2\u0109\66\3\2\2\2\u010a"+
		"\u010b\7\u0080\2\2\u010b8\3\2\2\2\u010c\u010d\7\177\2\2\u010d:\3\2\2\2"+
		"\u010e\u010f\7\'\2\2\u010f<\3\2\2\2\u0110\u0111\7.\2\2\u0111>\3\2\2\2"+
		"\u0112\u0114\7/\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0128"+
		"\3\2\2\2\u0115\u0129\7\62\2\2\u0116\u011a\t\4\2\2\u0117\u0119\t\5\2\2"+
		"\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u0129\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011f\t\5\2\2\u011e"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\3\2\2\2\u0122\u0124\5G$\2\u0123\u0125\t\5\2\2\u0124\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0129\3\2\2\2\u0128\u0115\3\2\2\2\u0128\u0116\3\2\2\2\u0128\u011e\3\2"+
		"\2\2\u0129@\3\2\2\2\u012a\u012b\7V\2\2\u012b\u012c\7Q\2\2\u012c\u0138"+
		"\7R\2\2\u012d\u012e\7D\2\2\u012e\u012f\7Q\2\2\u012f\u0130\7V\2\2\u0130"+
		"\u0131\7V\2\2\u0131\u0132\7Q\2\2\u0132\u0138\7O\2\2\u0133\u0134\7U\2\2"+
		"\u0134\u0135\7K\2\2\u0135\u0136\7F\2\2\u0136\u0138\7G\2\2\u0137\u012a"+
		"\3\2\2\2\u0137\u012d\3\2\2\2\u0137\u0133\3\2\2\2\u0138B\3\2\2\2\u0139"+
		"\u013a\7,\2\2\u013aD\3\2\2\2\u013b\u013c\7<\2\2\u013cF\3\2\2\2\u013d\u013e"+
		"\7\60\2\2\u013eH\3\2\2\2\u013f\u0140\7=\2\2\u0140J\3\2\2\2\u0141\u0145"+
		"\t\6\2\2\u0142\u0144\t\7\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146L\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0148\u014c\t\b\2\2\u0149\u014b\t\7\2\2\u014a\u0149\3\2\2\2\u014b\u014e"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014dN\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014f\u0151\t\t\2\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0155\b(\3\2\u0155P\3\2\2\2\u0156\u015c\7$\2\2\u0157\u0158\7^\2\2\u0158"+
		"\u015b\t\n\2\2\u0159\u015b\n\13\2\2\u015a\u0157\3\2\2\2\u015a\u0159\3"+
		"\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7$\2\2\u0160R\3\2\2\2\u0161"+
		"\u0162\7-\2\2\u0162T\3\2\2\2\u0163\u0164\7/\2\2\u0164V\3\2\2\2\u0165\u0166"+
		"\7\61\2\2\u0166X\3\2\2\2\u0167\u0168\7?\2\2\u0168\u0169\7?\2\2\u0169Z"+
		"\3\2\2\2\u016a\u016b\7#\2\2\u016b\u016c\7?\2\2\u016c\\\3\2\2\2\u016d\u016e"+
		"\7<\2\2\u016e\u016f\7?\2\2\u016f^\3\2\2\2\20\2\u00f1\u00fc\u0113\u011a"+
		"\u0120\u0126\u0128\u0137\u0145\u014c\u0152\u015a\u015c\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}