// Generated from /home/frostywolf/Documents/Univ/2022-2023/Sem2/C/Bloco03-Compilador/Ex09StorZuquete/Fractions.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FractionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, Literal=14, ID=15, Integer=16, 
		NEWLINE=17, WS=18, COMMENT=19;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_assignment = 2, RULE_expr = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "assignment", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'-'", "'+'", "'('", "')'", "'^'", "'*'", "':'", 
			"'reduce'", "'print'", "'copy'", "'paste'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "Literal", "ID", "Integer", "NEWLINE", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "Fractions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FractionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FractionsParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Literal) | (1L << ID) | (1L << Integer) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Literal) | (1L << ID) | (1L << Integer) | (1L << NEWLINE))) != 0)) {
					{
					setState(8);
					stat();
					}
				}

				setState(11);
				match(T__0);
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(FractionsParser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Literal) | (1L << ID) | (1L << Integer))) != 0)) {
					{
					setState(19);
					expr(0);
					}
				}

				setState(22);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(23);
					assignment();
					}
				}

				setState(26);
				match(NEWLINE);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FractionsParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(ID);
			setState(30);
			match(T__1);
			setState(31);
			expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprUnNegContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprUnNegContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprUnPosContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprUnPosContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprParentContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParentContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprPrintContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprPrintContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprCopyContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprCopyContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprPasteContext extends ExprContext {
		public ExprPasteContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprPowerContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprPowerContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprReduceContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprReduceContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprMultDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprAddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprLiteralContext extends ExprContext {
		public TerminalNode Literal() { return getToken(FractionsParser.Literal, 0); }
		public ExprLiteralContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprIntegerContext extends ExprContext {
		public TerminalNode Integer() { return getToken(FractionsParser.Integer, 0); }
		public ExprIntegerContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprIdContext extends ExprContext {
		public TerminalNode ID() { return getToken(FractionsParser.ID, 0); }
		public ExprIdContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(34);
				match(T__2);
				setState(35);
				expr(13);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnPosContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(T__3);
				setState(37);
				expr(12);
				}
				break;
			case 3:
				{
				_localctx = new ExprPowerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(T__4);
				setState(39);
				expr(0);
				setState(40);
				match(T__5);
				setState(41);
				match(T__6);
				setState(42);
				expr(11);
				}
				break;
			case 4:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(Literal);
				}
				break;
			case 5:
				{
				_localctx = new ExprIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(Integer);
				}
				break;
			case 6:
				{
				_localctx = new ExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new ExprParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(T__4);
				setState(48);
				expr(0);
				setState(49);
				match(T__5);
				}
				break;
			case 8:
				{
				_localctx = new ExprReduceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(T__9);
				setState(52);
				expr(4);
				}
				break;
			case 9:
				{
				_localctx = new ExprPrintContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				match(T__10);
				setState(54);
				expr(3);
				}
				break;
			case 10:
				{
				_localctx = new ExprCopyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				match(T__11);
				setState(56);
				expr(2);
				}
				break;
			case 11:
				{
				_localctx = new ExprPasteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				match(T__12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(61);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__8) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(62);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(64);
						((ExprAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((ExprAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(65);
						expr(10);
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25J\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\5\2\f\n\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3\2\3"+
		"\2\3\3\5\3\27\n\3\3\3\3\3\5\3\33\n\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5E\n\5"+
		"\f\5\16\5H\13\5\3\5\2\3\b\6\2\4\6\b\2\4\3\2\n\13\3\2\5\6\2V\2\20\3\2\2"+
		"\2\4\35\3\2\2\2\6\37\3\2\2\2\b<\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\13\f"+
		"\3\2\2\2\f\r\3\2\2\2\r\17\7\3\2\2\16\13\3\2\2\2\17\22\3\2\2\2\20\16\3"+
		"\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\20\3\2\2\2\23\24\7\2\2\3\24\3\3"+
		"\2\2\2\25\27\5\b\5\2\26\25\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\36\7"+
		"\23\2\2\31\33\5\6\4\2\32\31\3\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2\34\36"+
		"\7\23\2\2\35\26\3\2\2\2\35\32\3\2\2\2\36\5\3\2\2\2\37 \7\21\2\2 !\7\4"+
		"\2\2!\"\5\b\5\2\"\7\3\2\2\2#$\b\5\1\2$%\7\5\2\2%=\5\b\5\17&\'\7\6\2\2"+
		"\'=\5\b\5\16()\7\7\2\2)*\5\b\5\2*+\7\b\2\2+,\7\t\2\2,-\5\b\5\r-=\3\2\2"+
		"\2.=\7\20\2\2/=\7\22\2\2\60=\7\21\2\2\61\62\7\7\2\2\62\63\5\b\5\2\63\64"+
		"\7\b\2\2\64=\3\2\2\2\65\66\7\f\2\2\66=\5\b\5\6\678\7\r\2\28=\5\b\5\59"+
		":\7\16\2\2:=\5\b\5\4;=\7\17\2\2<#\3\2\2\2<&\3\2\2\2<(\3\2\2\2<.\3\2\2"+
		"\2</\3\2\2\2<\60\3\2\2\2<\61\3\2\2\2<\65\3\2\2\2<\67\3\2\2\2<9\3\2\2\2"+
		"<;\3\2\2\2=F\3\2\2\2>?\f\f\2\2?@\t\2\2\2@E\5\b\5\rAB\f\13\2\2BC\t\3\2"+
		"\2CE\5\b\5\fD>\3\2\2\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\t\3\2"+
		"\2\2HF\3\2\2\2\n\13\20\26\32\35<DF";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}