// Generated from AntlrSat.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrSatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, OBJ=4, NB=5, DEP=6;
	public static final int
		RULE_spawn = 0, RULE_pause = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"spawn", "pause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'spawn '", "' '", "'pause'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "OBJ", "NB", "DEP"
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
	public String getGrammarFileName() { return "AntlrSat.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AntlrSatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SpawnContext extends ParserRuleContext {
		public TerminalNode OBJ() { return getToken(AntlrSatParser.OBJ, 0); }
		public List<TerminalNode> NB() { return getTokens(AntlrSatParser.NB); }
		public TerminalNode NB(int i) {
			return getToken(AntlrSatParser.NB, i);
		}
		public TerminalNode DEP() { return getToken(AntlrSatParser.DEP, 0); }
		public SpawnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spawn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrSatListener ) ((AntlrSatListener)listener).enterSpawn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrSatListener ) ((AntlrSatListener)listener).exitSpawn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrSatVisitor ) return ((AntlrSatVisitor<? extends T>)visitor).visitSpawn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpawnContext spawn() throws RecognitionException {
		SpawnContext _localctx = new SpawnContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_spawn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			match(T__0);
			setState(5);
			match(OBJ);
			setState(6);
			match(T__1);
			setState(7);
			match(NB);
			setState(8);
			match(T__1);
			setState(9);
			match(NB);
			setState(10);
			match(T__1);
			setState(11);
			match(NB);
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(12);
				match(T__1);
				setState(13);
				match(DEP);
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

	public static class PauseContext extends ParserRuleContext {
		public PauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrSatListener ) ((AntlrSatListener)listener).enterPause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AntlrSatListener ) ((AntlrSatListener)listener).exitPause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrSatVisitor ) return ((AntlrSatVisitor<? extends T>)visitor).visitPause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PauseContext pause() throws RecognitionException {
		PauseContext _localctx = new PauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__2);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\25\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\3\3\3\3\3\2"+
		"\2\4\2\4\2\2\2\23\2\6\3\2\2\2\4\22\3\2\2\2\6\7\7\3\2\2\7\b\7\6\2\2\b\t"+
		"\7\4\2\2\t\n\7\7\2\2\n\13\7\4\2\2\13\f\7\7\2\2\f\r\7\4\2\2\r\20\7\7\2"+
		"\2\16\17\7\4\2\2\17\21\7\b\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\3\3\2\2"+
		"\2\22\23\7\5\2\2\23\5\3\2\2\2\3\20";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}