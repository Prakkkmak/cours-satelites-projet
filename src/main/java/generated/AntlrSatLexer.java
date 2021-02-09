// Generated from AntlrSat.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrSatLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, OBJ=6, NB=7, DEP=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "OBJ", "NB", "DEP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'stop'", "'!'", "'create '", "' '", "'pause'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "OBJ", "NB", "DEP", "WS"
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


	public AntlrSatLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AntlrSat.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13E\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\b\6\b\60\n\b\r\b\16\b\61\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t=\n\t\3\n\6\n@\n\n\r\n\16\nA\3\n\3\n\2\2\13\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\5\4\2DDUU\3\2\62;\5\2\13\f\17"+
		"\17\"\"\2H\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32"+
		"\3\2\2\2\7\34\3\2\2\2\t$\3\2\2\2\13&\3\2\2\2\r,\3\2\2\2\17/\3\2\2\2\21"+
		"<\3\2\2\2\23?\3\2\2\2\25\26\7u\2\2\26\27\7v\2\2\27\30\7q\2\2\30\31\7r"+
		"\2\2\31\4\3\2\2\2\32\33\7#\2\2\33\6\3\2\2\2\34\35\7e\2\2\35\36\7t\2\2"+
		"\36\37\7g\2\2\37 \7c\2\2 !\7v\2\2!\"\7g\2\2\"#\7\"\2\2#\b\3\2\2\2$%\7"+
		"\"\2\2%\n\3\2\2\2&\'\7r\2\2\'(\7c\2\2()\7w\2\2)*\7u\2\2*+\7g\2\2+\f\3"+
		"\2\2\2,-\t\2\2\2-\16\3\2\2\2.\60\t\3\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3"+
		"\2\2\2\61\62\3\2\2\2\62\20\3\2\2\2\63\64\7j\2\2\64\65\7q\2\2\65=\7t\2"+
		"\2\66\67\7u\2\2\678\7k\2\28=\7p\2\29:\7x\2\2:;\7g\2\2;=\7t\2\2<\63\3\2"+
		"\2\2<\66\3\2\2\2<9\3\2\2\2=\22\3\2\2\2>@\t\4\2\2?>\3\2\2\2@A\3\2\2\2A"+
		"?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\b\n\2\2D\24\3\2\2\2\6\2\61<A\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}