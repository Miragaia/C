// Generated from /Users/duartecruz/Library/CloudStorage/OneDrive-UniversidadedeAveiro/LEI - Duarte Cruz/2º Ano/2º Semestre/C/Teste/Testes Práticos/Teste_Nao_sei_quando_/Resolução/BigIntCalc.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BigIntCalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUMBER=9, 
		ID=10, COMMENT=11, WS=12, ERROR=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUMBER", 
			"ID", "COMMENT", "WS", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'show'", "'->'", "'+'", "'-'", "'*'", "'div'", "'mod'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NUMBER", "ID", 
			"COMMENT", "WS", "ERROR"
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


	public BigIntCalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BigIntCalc.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17R\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\6\n\67\n"+
		"\n\r\n\16\n8\3\13\3\13\7\13=\n\13\f\13\16\13@\13\13\3\f\3\f\7\fD\n\f\f"+
		"\f\16\fG\13\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3E\2\17\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\6\3\2\62"+
		";\3\2c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\2T\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3"+
		"\35\3\2\2\2\5\37\3\2\2\2\7$\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2\2\2"+
		"\17-\3\2\2\2\21\61\3\2\2\2\23\66\3\2\2\2\25:\3\2\2\2\27A\3\2\2\2\31L\3"+
		"\2\2\2\33P\3\2\2\2\35\36\7=\2\2\36\4\3\2\2\2\37 \7u\2\2 !\7j\2\2!\"\7"+
		"q\2\2\"#\7y\2\2#\6\3\2\2\2$%\7/\2\2%&\7@\2\2&\b\3\2\2\2\'(\7-\2\2(\n\3"+
		"\2\2\2)*\7/\2\2*\f\3\2\2\2+,\7,\2\2,\16\3\2\2\2-.\7f\2\2./\7k\2\2/\60"+
		"\7x\2\2\60\20\3\2\2\2\61\62\7o\2\2\62\63\7q\2\2\63\64\7f\2\2\64\22\3\2"+
		"\2\2\65\67\t\2\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\24"+
		"\3\2\2\2:>\t\3\2\2;=\t\4\2\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?"+
		"\26\3\2\2\2@>\3\2\2\2AE\7%\2\2BD\13\2\2\2CB\3\2\2\2DG\3\2\2\2EF\3\2\2"+
		"\2EC\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\f\2\2IJ\3\2\2\2JK\b\f\2\2K\30\3\2"+
		"\2\2LM\t\5\2\2MN\3\2\2\2NO\b\r\2\2O\32\3\2\2\2PQ\13\2\2\2Q\34\3\2\2\2"+
		"\6\28>E\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}