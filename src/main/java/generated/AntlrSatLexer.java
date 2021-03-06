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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OBJ=9, 
		NB=10, DEP=11, COLOR=12, WS=13, VAR=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "OBJ", 
			"NB", "DEP", "COLOR", "WS", "VAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' = '", "'create '", "' '", "'remove '", "'speed '", "'movement '", 
			"'pause'", "'color '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "OBJ", "NB", "DEP", 
			"COLOR", "WS", "VAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\6\13W\n\13\r\13"+
		"\16\13X\3\f\3\f\3\f\3\f\3\f\3\f\5\fa\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rr\n\r\3\16\6\16u\n\16\r\16\16\16v\3"+
		"\16\3\16\3\17\6\17|\n\17\r\17\16\17}\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\6\4\2DDUU\3\2\62;\5\2\13"+
		"\f\17\17\"\"\4\2C\\c|\2\u0084\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3"+
		"\37\3\2\2\2\5#\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13\65\3\2\2\2\r<\3\2\2\2"+
		"\17F\3\2\2\2\21L\3\2\2\2\23S\3\2\2\2\25V\3\2\2\2\27`\3\2\2\2\31q\3\2\2"+
		"\2\33t\3\2\2\2\35{\3\2\2\2\37 \7\"\2\2 !\7?\2\2!\"\7\"\2\2\"\4\3\2\2\2"+
		"#$\7e\2\2$%\7t\2\2%&\7g\2\2&\'\7c\2\2\'(\7v\2\2()\7g\2\2)*\7\"\2\2*\6"+
		"\3\2\2\2+,\7\"\2\2,\b\3\2\2\2-.\7t\2\2./\7g\2\2/\60\7o\2\2\60\61\7q\2"+
		"\2\61\62\7x\2\2\62\63\7g\2\2\63\64\7\"\2\2\64\n\3\2\2\2\65\66\7u\2\2\66"+
		"\67\7r\2\2\678\7g\2\289\7g\2\29:\7f\2\2:;\7\"\2\2;\f\3\2\2\2<=\7o\2\2"+
		"=>\7q\2\2>?\7x\2\2?@\7g\2\2@A\7o\2\2AB\7g\2\2BC\7p\2\2CD\7v\2\2DE\7\""+
		"\2\2E\16\3\2\2\2FG\7r\2\2GH\7c\2\2HI\7w\2\2IJ\7u\2\2JK\7g\2\2K\20\3\2"+
		"\2\2LM\7e\2\2MN\7q\2\2NO\7n\2\2OP\7q\2\2PQ\7t\2\2QR\7\"\2\2R\22\3\2\2"+
		"\2ST\t\2\2\2T\24\3\2\2\2UW\t\3\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2"+
		"\2\2Y\26\3\2\2\2Z[\7j\2\2[\\\7q\2\2\\a\7t\2\2]^\7x\2\2^_\7g\2\2_a\7t\2"+
		"\2`Z\3\2\2\2`]\3\2\2\2a\30\3\2\2\2bc\7d\2\2cd\7n\2\2de\7w\2\2er\7g\2\2"+
		"fg\7i\2\2gh\7t\2\2hi\7g\2\2ij\7g\2\2jr\7p\2\2kl\7{\2\2lm\7g\2\2mn\7n\2"+
		"\2no\7n\2\2op\7q\2\2pr\7y\2\2qb\3\2\2\2qf\3\2\2\2qk\3\2\2\2r\32\3\2\2"+
		"\2su\t\4\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\b\16"+
		"\2\2y\34\3\2\2\2z|\t\5\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\36"+
		"\3\2\2\2\b\2X`qv}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}