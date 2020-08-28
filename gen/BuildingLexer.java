// Generated from /home/mathias/gitrepos/jbuild/src/main/antlr4/Building.g4 by ANTLR 4.8
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
		T__17=18, AXIS=19, LINE_COMMENT=20, BLOCK_COMMENT=21, LPAREN=22, RPAREN=23, 
		LBRACE=24, TILDE=25, RBRACE=26, PERCENTAGE=27, COMMA=28, NUMBER=29, FACE=30, 
		ASTERIX=31, COLON=32, DOT=33, SEMICOLON=34, NAME=35, VARIABLE=36, WS=37, 
		STRING=38, PLUS=39, MINUS=40, DIVIDE=41, EQUALS=42, NOT_EQUALS=43, ASSIGN=44;
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
			"T__17", "AXIS", "LINE_COMMENT", "BLOCK_COMMENT", "LPAREN", "RPAREN", 
			"LBRACE", "TILDE", "RBRACE", "PERCENTAGE", "COMMA", "NUMBER", "FACE", 
			"ASTERIX", "COLON", "DOT", "SEMICOLON", "NAME", "VARIABLE", "WS", "STRING", 
			"PLUS", "MINUS", "DIVIDE", "EQUALS", "NOT_EQUALS", "ASSIGN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'plot'", "'->'", "'color'", "'translate'", "'translateG'", "'rotateX'", 
			"'rotateY'", "'rotateZ'", "'rotatePX'", "'rotatePY'", "'rotatePZ'", "'scale'", 
			"'polygon'", "'extrude'", "'split'", "'if'", "'true'", "'false'", null, 
			null, null, "'('", "')'", "'{'", "'~'", "'}'", "'%'", "','", null, null, 
			"'*'", "':'", "'.'", "';'", null, null, null, null, "'+'", "'-'", "'/'", 
			"'=='", "'!='", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "AXIS", "LINE_COMMENT", "BLOCK_COMMENT", 
			"LPAREN", "RPAREN", "LBRACE", "TILDE", "RBRACE", "PERCENTAGE", "COMMA", 
			"NUMBER", "FACE", "ASTERIX", "COLON", "DOT", "SEMICOLON", "NAME", "VARIABLE", 
			"WS", "STRING", "PLUS", "MINUS", "DIVIDE", "EQUALS", "NOT_EQUALS", "ASSIGN"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0162\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00e2\n\25\f\25\16\25\u00e5"+
		"\13\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00ed\n\26\f\26\16\26\u00f0"+
		"\13\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\5\36\u0106\n\36\3\36\3\36\3\36\7\36"+
		"\u010b\n\36\f\36\16\36\u010e\13\36\3\36\6\36\u0111\n\36\r\36\16\36\u0112"+
		"\3\36\3\36\6\36\u0117\n\36\r\36\16\36\u0118\5\36\u011b\n\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u012a\n\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\7$\u0136\n$\f$\16$\u0139\13$\3%\3%\7"+
		"%\u013d\n%\f%\16%\u0140\13%\3&\6&\u0143\n&\r&\16&\u0144\3&\3&\3\'\3\'"+
		"\3\'\3\'\7\'\u014d\n\'\f\'\16\'\u0150\13\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3"+
		"+\3+\3+\3,\3,\3,\3-\3-\3-\3\u00ee\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3"+
		"\2\f\4\2Z\\z|\4\2\f\f\17\17\3\2\63;\3\2\62;\3\2C\\\6\2\62;C\\aac|\4\2"+
		"aac|\4\2\13\f\"\"\4\2$$^^\6\2\f\f\17\17$$^^\2\u0170\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\3[\3\2\2\2\5`\3\2\2\2\7c\3\2\2\2\ti\3\2\2\2\13s\3\2\2\2"+
		"\r~\3\2\2\2\17\u0086\3\2\2\2\21\u008e\3\2\2\2\23\u0096\3\2\2\2\25\u009f"+
		"\3\2\2\2\27\u00a8\3\2\2\2\31\u00b1\3\2\2\2\33\u00b7\3\2\2\2\35\u00bf\3"+
		"\2\2\2\37\u00c7\3\2\2\2!\u00cd\3\2\2\2#\u00d0\3\2\2\2%\u00d5\3\2\2\2\'"+
		"\u00db\3\2\2\2)\u00dd\3\2\2\2+\u00e8\3\2\2\2-\u00f6\3\2\2\2/\u00f8\3\2"+
		"\2\2\61\u00fa\3\2\2\2\63\u00fc\3\2\2\2\65\u00fe\3\2\2\2\67\u0100\3\2\2"+
		"\29\u0102\3\2\2\2;\u0105\3\2\2\2=\u0129\3\2\2\2?\u012b\3\2\2\2A\u012d"+
		"\3\2\2\2C\u012f\3\2\2\2E\u0131\3\2\2\2G\u0133\3\2\2\2I\u013a\3\2\2\2K"+
		"\u0142\3\2\2\2M\u0148\3\2\2\2O\u0153\3\2\2\2Q\u0155\3\2\2\2S\u0157\3\2"+
		"\2\2U\u0159\3\2\2\2W\u015c\3\2\2\2Y\u015f\3\2\2\2[\\\7r\2\2\\]\7n\2\2"+
		"]^\7q\2\2^_\7v\2\2_\4\3\2\2\2`a\7/\2\2ab\7@\2\2b\6\3\2\2\2cd\7e\2\2de"+
		"\7q\2\2ef\7n\2\2fg\7q\2\2gh\7t\2\2h\b\3\2\2\2ij\7v\2\2jk\7t\2\2kl\7c\2"+
		"\2lm\7p\2\2mn\7u\2\2no\7n\2\2op\7c\2\2pq\7v\2\2qr\7g\2\2r\n\3\2\2\2st"+
		"\7v\2\2tu\7t\2\2uv\7c\2\2vw\7p\2\2wx\7u\2\2xy\7n\2\2yz\7c\2\2z{\7v\2\2"+
		"{|\7g\2\2|}\7I\2\2}\f\3\2\2\2~\177\7t\2\2\177\u0080\7q\2\2\u0080\u0081"+
		"\7v\2\2\u0081\u0082\7c\2\2\u0082\u0083\7v\2\2\u0083\u0084\7g\2\2\u0084"+
		"\u0085\7Z\2\2\u0085\16\3\2\2\2\u0086\u0087\7t\2\2\u0087\u0088\7q\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7c\2\2\u008a\u008b\7v\2\2\u008b\u008c\7g\2\2"+
		"\u008c\u008d\7[\2\2\u008d\20\3\2\2\2\u008e\u008f\7t\2\2\u008f\u0090\7"+
		"q\2\2\u0090\u0091\7v\2\2\u0091\u0092\7c\2\2\u0092\u0093\7v\2\2\u0093\u0094"+
		"\7g\2\2\u0094\u0095\7\\\2\2\u0095\22\3\2\2\2\u0096\u0097\7t\2\2\u0097"+
		"\u0098\7q\2\2\u0098\u0099\7v\2\2\u0099\u009a\7c\2\2\u009a\u009b\7v\2\2"+
		"\u009b\u009c\7g\2\2\u009c\u009d\7R\2\2\u009d\u009e\7Z\2\2\u009e\24\3\2"+
		"\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3"+
		"\7c\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7R\2\2\u00a6"+
		"\u00a7\7[\2\2\u00a7\26\3\2\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7q\2\2\u00aa"+
		"\u00ab\7v\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7g\2\2"+
		"\u00ae\u00af\7R\2\2\u00af\u00b0\7\\\2\2\u00b0\30\3\2\2\2\u00b1\u00b2\7"+
		"u\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6"+
		"\7g\2\2\u00b6\32\3\2\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba"+
		"\7n\2\2\u00ba\u00bb\7{\2\2\u00bb\u00bc\7i\2\2\u00bc\u00bd\7q\2\2\u00bd"+
		"\u00be\7p\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7z\2\2\u00c1"+
		"\u00c2\7v\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\7f\2\2"+
		"\u00c5\u00c6\7g\2\2\u00c6\36\3\2\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7"+
		"r\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7v\2\2\u00cc "+
		"\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7h\2\2\u00cf\"\3\2\2\2\u00d0\u00d1"+
		"\7v\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4\7g\2\2\u00d4"+
		"$\3\2\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8"+
		"\u00d9\7u\2\2\u00d9\u00da\7g\2\2\u00da&\3\2\2\2\u00db\u00dc\t\2\2\2\u00dc"+
		"(\3\2\2\2\u00dd\u00de\7\61\2\2\u00de\u00df\7\61\2\2\u00df\u00e3\3\2\2"+
		"\2\u00e0\u00e2\n\3\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e7\b\25\2\2\u00e7*\3\2\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ea\7,\2\2"+
		"\u00ea\u00ee\3\2\2\2\u00eb\u00ed\13\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f2\7,\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f4\3\2"+
		"\2\2\u00f4\u00f5\b\26\2\2\u00f5,\3\2\2\2\u00f6\u00f7\7*\2\2\u00f7.\3\2"+
		"\2\2\u00f8\u00f9\7+\2\2\u00f9\60\3\2\2\2\u00fa\u00fb\7}\2\2\u00fb\62\3"+
		"\2\2\2\u00fc\u00fd\7\u0080\2\2\u00fd\64\3\2\2\2\u00fe\u00ff\7\177\2\2"+
		"\u00ff\66\3\2\2\2\u0100\u0101\7\'\2\2\u01018\3\2\2\2\u0102\u0103\7.\2"+
		"\2\u0103:\3\2\2\2\u0104\u0106\7/\2\2\u0105\u0104\3\2\2\2\u0105\u0106\3"+
		"\2\2\2\u0106\u011a\3\2\2\2\u0107\u011b\7\62\2\2\u0108\u010c\t\4\2\2\u0109"+
		"\u010b\t\5\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u011b\3\2\2\2\u010e\u010c\3\2\2\2\u010f"+
		"\u0111\t\5\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\5C\"\2\u0115"+
		"\u0117\t\5\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0107\3\2\2\2\u011a"+
		"\u0108\3\2\2\2\u011a\u0110\3\2\2\2\u011b<\3\2\2\2\u011c\u011d\7V\2\2\u011d"+
		"\u011e\7Q\2\2\u011e\u012a\7R\2\2\u011f\u0120\7D\2\2\u0120\u0121\7Q\2\2"+
		"\u0121\u0122\7V\2\2\u0122\u0123\7V\2\2\u0123\u0124\7Q\2\2\u0124\u012a"+
		"\7O\2\2\u0125\u0126\7U\2\2\u0126\u0127\7K\2\2\u0127\u0128\7F\2\2\u0128"+
		"\u012a\7G\2\2\u0129\u011c\3\2\2\2\u0129\u011f\3\2\2\2\u0129\u0125\3\2"+
		"\2\2\u012a>\3\2\2\2\u012b\u012c\7,\2\2\u012c@\3\2\2\2\u012d\u012e\7<\2"+
		"\2\u012eB\3\2\2\2\u012f\u0130\7\60\2\2\u0130D\3\2\2\2\u0131\u0132\7=\2"+
		"\2\u0132F\3\2\2\2\u0133\u0137\t\6\2\2\u0134\u0136\t\7\2\2\u0135\u0134"+
		"\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"H\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013e\t\b\2\2\u013b\u013d\t\7\2\2"+
		"\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013fJ\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\t\t\2\2\u0142"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0146\3\2\2\2\u0146\u0147\b&\3\2\u0147L\3\2\2\2\u0148\u014e"+
		"\7$\2\2\u0149\u014a\7^\2\2\u014a\u014d\t\n\2\2\u014b\u014d\n\13\2\2\u014c"+
		"\u0149\3\2\2\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0152\7$\2\2\u0152N\3\2\2\2\u0153\u0154\7-\2\2\u0154P\3\2\2\2\u0155\u0156"+
		"\7/\2\2\u0156R\3\2\2\2\u0157\u0158\7\61\2\2\u0158T\3\2\2\2\u0159\u015a"+
		"\7?\2\2\u015a\u015b\7?\2\2\u015bV\3\2\2\2\u015c\u015d\7#\2\2\u015d\u015e"+
		"\7?\2\2\u015eX\3\2\2\2\u015f\u0160\7<\2\2\u0160\u0161\7?\2\2\u0161Z\3"+
		"\2\2\2\20\2\u00e3\u00ee\u0105\u010c\u0112\u0118\u011a\u0129\u0137\u013e"+
		"\u0144\u014c\u014e\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}