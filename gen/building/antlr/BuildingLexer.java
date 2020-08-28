// Generated from /Users/madsbjoern/Documents/Git/JBuild/src/main/antlr4/Building.g4 by ANTLR 4.8
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
		T__17=18, AXIS=19, LPAREN=20, RPAREN=21, LBRACE=22, TILDE=23, RBRACE=24, 
		PERCENTAGE=25, COMMA=26, NUMBER=27, FACE=28, ASTERIX=29, COLON=30, DOT=31, 
		SEMICOLON=32, NAME=33, VARIABLE=34, WS=35, STRING=36, PLUS=37, MINUS=38, 
		DIVIDE=39, EQUALS=40, NOT_EQUALS=41, ASSIGN=42;
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
			"T__17", "AXIS", "LPAREN", "RPAREN", "LBRACE", "TILDE", "RBRACE", "PERCENTAGE", 
			"COMMA", "NUMBER", "FACE", "ASTERIX", "COLON", "DOT", "SEMICOLON", "NAME", 
			"VARIABLE", "WS", "STRING", "PLUS", "MINUS", "DIVIDE", "EQUALS", "NOT_EQUALS", 
			"ASSIGN"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0145\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\5\34\u00e9\n\34\3\34\3\34\3\34\7\34\u00ee\n\34\f\34\16\34\u00f1"+
		"\13\34\3\34\6\34\u00f4\n\34\r\34\16\34\u00f5\3\34\3\34\6\34\u00fa\n\34"+
		"\r\34\16\34\u00fb\5\34\u00fe\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\5\35\u010d\n\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\7\"\u0119\n\"\f\"\16\"\u011c\13\"\3#\3#\7#\u0120\n#\f"+
		"#\16#\u0123\13#\3$\6$\u0126\n$\r$\16$\u0127\3$\3$\3%\3%\3%\3%\7%\u0130"+
		"\n%\f%\16%\u0133\13%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\13\4\2Z\\z|\3\2\63;\3\2\62"+
		";\3\2C\\\6\2\62;C\\aac|\4\2aac|\4\2\13\f\"\"\4\2$$^^\6\2\f\f\17\17$$^"+
		"^\2\u0151\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5\\\3\2\2\2\7_\3\2\2\2\te\3\2\2\2\13o\3"+
		"\2\2\2\rz\3\2\2\2\17\u0082\3\2\2\2\21\u008a\3\2\2\2\23\u0092\3\2\2\2\25"+
		"\u009b\3\2\2\2\27\u00a4\3\2\2\2\31\u00ad\3\2\2\2\33\u00b3\3\2\2\2\35\u00bb"+
		"\3\2\2\2\37\u00c3\3\2\2\2!\u00c9\3\2\2\2#\u00cc\3\2\2\2%\u00d1\3\2\2\2"+
		"\'\u00d7\3\2\2\2)\u00d9\3\2\2\2+\u00db\3\2\2\2-\u00dd\3\2\2\2/\u00df\3"+
		"\2\2\2\61\u00e1\3\2\2\2\63\u00e3\3\2\2\2\65\u00e5\3\2\2\2\67\u00e8\3\2"+
		"\2\29\u010c\3\2\2\2;\u010e\3\2\2\2=\u0110\3\2\2\2?\u0112\3\2\2\2A\u0114"+
		"\3\2\2\2C\u0116\3\2\2\2E\u011d\3\2\2\2G\u0125\3\2\2\2I\u012b\3\2\2\2K"+
		"\u0136\3\2\2\2M\u0138\3\2\2\2O\u013a\3\2\2\2Q\u013c\3\2\2\2S\u013f\3\2"+
		"\2\2U\u0142\3\2\2\2WX\7r\2\2XY\7n\2\2YZ\7q\2\2Z[\7v\2\2[\4\3\2\2\2\\]"+
		"\7/\2\2]^\7@\2\2^\6\3\2\2\2_`\7e\2\2`a\7q\2\2ab\7n\2\2bc\7q\2\2cd\7t\2"+
		"\2d\b\3\2\2\2ef\7v\2\2fg\7t\2\2gh\7c\2\2hi\7p\2\2ij\7u\2\2jk\7n\2\2kl"+
		"\7c\2\2lm\7v\2\2mn\7g\2\2n\n\3\2\2\2op\7v\2\2pq\7t\2\2qr\7c\2\2rs\7p\2"+
		"\2st\7u\2\2tu\7n\2\2uv\7c\2\2vw\7v\2\2wx\7g\2\2xy\7I\2\2y\f\3\2\2\2z{"+
		"\7t\2\2{|\7q\2\2|}\7v\2\2}~\7c\2\2~\177\7v\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7Z\2\2\u0081\16\3\2\2\2\u0082\u0083\7t\2\2\u0083\u0084\7q\2\2\u0084"+
		"\u0085\7v\2\2\u0085\u0086\7c\2\2\u0086\u0087\7v\2\2\u0087\u0088\7g\2\2"+
		"\u0088\u0089\7[\2\2\u0089\20\3\2\2\2\u008a\u008b\7t\2\2\u008b\u008c\7"+
		"q\2\2\u008c\u008d\7v\2\2\u008d\u008e\7c\2\2\u008e\u008f\7v\2\2\u008f\u0090"+
		"\7g\2\2\u0090\u0091\7\\\2\2\u0091\22\3\2\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7v\2\2\u0095\u0096\7c\2\2\u0096\u0097\7v\2\2"+
		"\u0097\u0098\7g\2\2\u0098\u0099\7R\2\2\u0099\u009a\7Z\2\2\u009a\24\3\2"+
		"\2\2\u009b\u009c\7t\2\2\u009c\u009d\7q\2\2\u009d\u009e\7v\2\2\u009e\u009f"+
		"\7c\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7R\2\2\u00a2"+
		"\u00a3\7[\2\2\u00a3\26\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\u00a7\7v\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7g\2\2"+
		"\u00aa\u00ab\7R\2\2\u00ab\u00ac\7\\\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7"+
		"u\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2"+
		"\7g\2\2\u00b2\32\3\2\2\2\u00b3\u00b4\7r\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6"+
		"\7n\2\2\u00b6\u00b7\7{\2\2\u00b7\u00b8\7i\2\2\u00b8\u00b9\7q\2\2\u00b9"+
		"\u00ba\7p\2\2\u00ba\34\3\2\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7z\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7f\2\2"+
		"\u00c1\u00c2\7g\2\2\u00c2\36\3\2\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7"+
		"r\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7v\2\2\u00c8 "+
		"\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7h\2\2\u00cb\"\3\2\2\2\u00cc\u00cd"+
		"\7v\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7g\2\2\u00d0"+
		"$\3\2\2\2\u00d1\u00d2\7h\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7n\2\2\u00d4"+
		"\u00d5\7u\2\2\u00d5\u00d6\7g\2\2\u00d6&\3\2\2\2\u00d7\u00d8\t\2\2\2\u00d8"+
		"(\3\2\2\2\u00d9\u00da\7*\2\2\u00da*\3\2\2\2\u00db\u00dc\7+\2\2\u00dc,"+
		"\3\2\2\2\u00dd\u00de\7}\2\2\u00de.\3\2\2\2\u00df\u00e0\7\u0080\2\2\u00e0"+
		"\60\3\2\2\2\u00e1\u00e2\7\177\2\2\u00e2\62\3\2\2\2\u00e3\u00e4\7\'\2\2"+
		"\u00e4\64\3\2\2\2\u00e5\u00e6\7.\2\2\u00e6\66\3\2\2\2\u00e7\u00e9\7/\2"+
		"\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00fd\3\2\2\2\u00ea\u00fe"+
		"\7\62\2\2\u00eb\u00ef\t\3\2\2\u00ec\u00ee\t\4\2\2\u00ed\u00ec\3\2\2\2"+
		"\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00fe"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f4\t\4\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f9\5? \2\u00f8\u00fa\t\4\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd"+
		"\u00ea\3\2\2\2\u00fd\u00eb\3\2\2\2\u00fd\u00f3\3\2\2\2\u00fe8\3\2\2\2"+
		"\u00ff\u0100\7V\2\2\u0100\u0101\7Q\2\2\u0101\u010d\7R\2\2\u0102\u0103"+
		"\7D\2\2\u0103\u0104\7Q\2\2\u0104\u0105\7V\2\2\u0105\u0106\7V\2\2\u0106"+
		"\u0107\7Q\2\2\u0107\u010d\7O\2\2\u0108\u0109\7U\2\2\u0109\u010a\7K\2\2"+
		"\u010a\u010b\7F\2\2\u010b\u010d\7G\2\2\u010c\u00ff\3\2\2\2\u010c\u0102"+
		"\3\2\2\2\u010c\u0108\3\2\2\2\u010d:\3\2\2\2\u010e\u010f\7,\2\2\u010f<"+
		"\3\2\2\2\u0110\u0111\7<\2\2\u0111>\3\2\2\2\u0112\u0113\7\60\2\2\u0113"+
		"@\3\2\2\2\u0114\u0115\7=\2\2\u0115B\3\2\2\2\u0116\u011a\t\5\2\2\u0117"+
		"\u0119\t\6\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011bD\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0121"+
		"\t\7\2\2\u011e\u0120\t\6\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122F\3\2\2\2\u0123\u0121\3\2\2\2"+
		"\u0124\u0126\t\b\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b$\2\2\u012a"+
		"H\3\2\2\2\u012b\u0131\7$\2\2\u012c\u012d\7^\2\2\u012d\u0130\t\t\2\2\u012e"+
		"\u0130\n\n\2\2\u012f\u012c\3\2\2\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2"+
		"\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0135\7$\2\2\u0135J\3\2\2\2\u0136\u0137\7-\2\2\u0137"+
		"L\3\2\2\2\u0138\u0139\7/\2\2\u0139N\3\2\2\2\u013a\u013b\7\61\2\2\u013b"+
		"P\3\2\2\2\u013c\u013d\7?\2\2\u013d\u013e\7?\2\2\u013eR\3\2\2\2\u013f\u0140"+
		"\7#\2\2\u0140\u0141\7?\2\2\u0141T\3\2\2\2\u0142\u0143\7<\2\2\u0143\u0144"+
		"\7?\2\2\u0144V\3\2\2\2\16\2\u00e8\u00ef\u00f5\u00fb\u00fd\u010c\u011a"+
		"\u0121\u0127\u012f\u0131\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}