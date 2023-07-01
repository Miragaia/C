// Generated from FracLang.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FracLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, Fraction=13, STRING=14, COMMENT=15, WS=16, Error=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "ID", "Fraction", "STRING", "COMMENT", "WS", "Error"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'display'", "'<='", "'+'", "'-'", "'*'", "':'", "'('", 
			"')'", "'reduce'", "'read'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "Fraction", "STRING", "COMMENT", "WS", "Error"
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


	public FracLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FracLang.g4"; }

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
		"\u0004\u0000\u0011|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0004\u000bJ\b\u000b\u000b\u000b\f\u000bK\u0001\f\u0004"+
		"\fO\b\f\u000b\f\f\fP\u0001\f\u0001\f\u0004\fU\b\f\u000b\f\f\fV\u0003\f"+
		"Y\b\f\u0001\r\u0001\r\u0005\r]\b\r\n\r\f\r`\t\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0004\u000ef\b\u000e\u000b\u000e\f\u000eg\u0001\u000e"+
		"\u0005\u000ek\b\u000e\n\u000e\f\u000en\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000fu\b\u000f\u000b\u000f"+
		"\f\u000fv\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0002^l\u0000"+
		"\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0003\u0001\u0000az\u0001"+
		"\u000009\u0003\u0000\t\n\r\r  \u0083\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000"+
		"\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005-\u0001\u0000\u0000\u0000"+
		"\u00070\u0001\u0000\u0000\u0000\t2\u0001\u0000\u0000\u0000\u000b4\u0001"+
		"\u0000\u0000\u0000\r6\u0001\u0000\u0000\u0000\u000f8\u0001\u0000\u0000"+
		"\u0000\u0011:\u0001\u0000\u0000\u0000\u0013<\u0001\u0000\u0000\u0000\u0015"+
		"C\u0001\u0000\u0000\u0000\u0017I\u0001\u0000\u0000\u0000\u0019N\u0001"+
		"\u0000\u0000\u0000\u001bZ\u0001\u0000\u0000\u0000\u001de\u0001\u0000\u0000"+
		"\u0000\u001ft\u0001\u0000\u0000\u0000!z\u0001\u0000\u0000\u0000#$\u0005"+
		";\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005d\u0000\u0000&\'\u0005"+
		"i\u0000\u0000\'(\u0005s\u0000\u0000()\u0005p\u0000\u0000)*\u0005l\u0000"+
		"\u0000*+\u0005a\u0000\u0000+,\u0005y\u0000\u0000,\u0004\u0001\u0000\u0000"+
		"\u0000-.\u0005<\u0000\u0000./\u0005=\u0000\u0000/\u0006\u0001\u0000\u0000"+
		"\u000001\u0005+\u0000\u00001\b\u0001\u0000\u0000\u000023\u0005-\u0000"+
		"\u00003\n\u0001\u0000\u0000\u000045\u0005*\u0000\u00005\f\u0001\u0000"+
		"\u0000\u000067\u0005:\u0000\u00007\u000e\u0001\u0000\u0000\u000089\u0005"+
		"(\u0000\u00009\u0010\u0001\u0000\u0000\u0000:;\u0005)\u0000\u0000;\u0012"+
		"\u0001\u0000\u0000\u0000<=\u0005r\u0000\u0000=>\u0005e\u0000\u0000>?\u0005"+
		"d\u0000\u0000?@\u0005u\u0000\u0000@A\u0005c\u0000\u0000AB\u0005e\u0000"+
		"\u0000B\u0014\u0001\u0000\u0000\u0000CD\u0005r\u0000\u0000DE\u0005e\u0000"+
		"\u0000EF\u0005a\u0000\u0000FG\u0005d\u0000\u0000G\u0016\u0001\u0000\u0000"+
		"\u0000HJ\u0007\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\u0018"+
		"\u0001\u0000\u0000\u0000MO\u0007\u0001\u0000\u0000NM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000QX\u0001\u0000\u0000\u0000RT\u0005/\u0000\u0000SU\u0007\u0001"+
		"\u0000\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000"+
		"XR\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u001a\u0001\u0000"+
		"\u0000\u0000Z^\u0005\"\u0000\u0000[]\t\u0000\u0000\u0000\\[\u0001\u0000"+
		"\u0000\u0000]`\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"ab\u0005\"\u0000\u0000b\u001c\u0001\u0000\u0000\u0000cd\u0005-\u0000\u0000"+
		"df\u0005-\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hl\u0001\u0000\u0000"+
		"\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\n\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qr\u0006\u000e\u0000\u0000r\u001e\u0001\u0000\u0000\u0000"+
		"su\u0007\u0002\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xy\u0006\u000f\u0000\u0000y \u0001\u0000\u0000\u0000z{\t\u0000"+
		"\u0000\u0000{\"\u0001\u0000\u0000\u0000\t\u0000KPVX^glv\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}