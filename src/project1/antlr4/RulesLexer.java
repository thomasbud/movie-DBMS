// Generated from /Users/engrbundle/IdeaProjects/BasicAntlrScript/src/project1/rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, OP=31, IDENTIFIER=32, 
		STR_LITERAL=33, INTEGER=34, DIGIT=35, ALPHA=36, POSDIG=37, WS=38;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "OP", "IDENTIFIER", "STR_LITERAL", 
			"INTEGER", "DIGIT", "ALPHA", "POSDIG", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<-'", "'SHOW'", "'CREATE TABLE'", "'('", "')'", "'PRIMARY KEY'", 
			"'UPDATE'", "'SET '", "'='", "','", "'WHERE'", "'INSERT INTO'", "'VALUES FROM'", 
			"'VALUES FROM RELATION'", "'DELETE FROM'", "'select'", "'project'", "'rename'", 
			"'+'", "'-'", "'*'", "'&'", "'||'", "'&&'", "'OPEN'", "'CLOSE'", "'WRITE'", 
			"'EXIT'", "'VARCHAR'", "'INTEGER'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "OP", "IDENTIFIER", "STR_LITERAL", 
			"INTEGER", "DIGIT", "ALPHA", "POSDIG", "WS"
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


	public RulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "rules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u013d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0117\n \3!\3!\3!\7!\u011c"+
		"\n!\f!\16!\u011f\13!\3\"\3\"\3\"\6\"\u0124\n\"\r\"\16\"\u0125\3\"\3\""+
		"\3#\3#\7#\u012c\n#\f#\16#\u012f\13#\3#\5#\u0132\n#\3$\3$\3%\3%\3&\3&\3"+
		"\'\3\'\3\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\7\4\2>>@@\3\2\62;\5\2C\\"+
		"aac|\3\2\63;\4\2\13\f\"\"\2\u0146\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3"+
		"O\3\2\2\2\5R\3\2\2\2\7W\3\2\2\2\td\3\2\2\2\13f\3\2\2\2\rh\3\2\2\2\17t"+
		"\3\2\2\2\21{\3\2\2\2\23\u0080\3\2\2\2\25\u0082\3\2\2\2\27\u0084\3\2\2"+
		"\2\31\u008a\3\2\2\2\33\u0096\3\2\2\2\35\u00a2\3\2\2\2\37\u00b7\3\2\2\2"+
		"!\u00c3\3\2\2\2#\u00ca\3\2\2\2%\u00d2\3\2\2\2\'\u00d9\3\2\2\2)\u00db\3"+
		"\2\2\2+\u00dd\3\2\2\2-\u00df\3\2\2\2/\u00e1\3\2\2\2\61\u00e4\3\2\2\2\63"+
		"\u00e7\3\2\2\2\65\u00ec\3\2\2\2\67\u00f2\3\2\2\29\u00f8\3\2\2\2;\u00fd"+
		"\3\2\2\2=\u0105\3\2\2\2?\u0116\3\2\2\2A\u0118\3\2\2\2C\u0120\3\2\2\2E"+
		"\u0131\3\2\2\2G\u0133\3\2\2\2I\u0135\3\2\2\2K\u0137\3\2\2\2M\u0139\3\2"+
		"\2\2OP\7>\2\2PQ\7/\2\2Q\4\3\2\2\2RS\7U\2\2ST\7J\2\2TU\7Q\2\2UV\7Y\2\2"+
		"V\6\3\2\2\2WX\7E\2\2XY\7T\2\2YZ\7G\2\2Z[\7C\2\2[\\\7V\2\2\\]\7G\2\2]^"+
		"\7\"\2\2^_\7V\2\2_`\7C\2\2`a\7D\2\2ab\7N\2\2bc\7G\2\2c\b\3\2\2\2de\7*"+
		"\2\2e\n\3\2\2\2fg\7+\2\2g\f\3\2\2\2hi\7R\2\2ij\7T\2\2jk\7K\2\2kl\7O\2"+
		"\2lm\7C\2\2mn\7T\2\2no\7[\2\2op\7\"\2\2pq\7M\2\2qr\7G\2\2rs\7[\2\2s\16"+
		"\3\2\2\2tu\7W\2\2uv\7R\2\2vw\7F\2\2wx\7C\2\2xy\7V\2\2yz\7G\2\2z\20\3\2"+
		"\2\2{|\7U\2\2|}\7G\2\2}~\7V\2\2~\177\7\"\2\2\177\22\3\2\2\2\u0080\u0081"+
		"\7?\2\2\u0081\24\3\2\2\2\u0082\u0083\7.\2\2\u0083\26\3\2\2\2\u0084\u0085"+
		"\7Y\2\2\u0085\u0086\7J\2\2\u0086\u0087\7G\2\2\u0087\u0088\7T\2\2\u0088"+
		"\u0089\7G\2\2\u0089\30\3\2\2\2\u008a\u008b\7K\2\2\u008b\u008c\7P\2\2\u008c"+
		"\u008d\7U\2\2\u008d\u008e\7G\2\2\u008e\u008f\7T\2\2\u008f\u0090\7V\2\2"+
		"\u0090\u0091\7\"\2\2\u0091\u0092\7K\2\2\u0092\u0093\7P\2\2\u0093\u0094"+
		"\7V\2\2\u0094\u0095\7Q\2\2\u0095\32\3\2\2\2\u0096\u0097\7X\2\2\u0097\u0098"+
		"\7C\2\2\u0098\u0099\7N\2\2\u0099\u009a\7W\2\2\u009a\u009b\7G\2\2\u009b"+
		"\u009c\7U\2\2\u009c\u009d\7\"\2\2\u009d\u009e\7H\2\2\u009e\u009f\7T\2"+
		"\2\u009f\u00a0\7Q\2\2\u00a0\u00a1\7O\2\2\u00a1\34\3\2\2\2\u00a2\u00a3"+
		"\7X\2\2\u00a3\u00a4\7C\2\2\u00a4\u00a5\7N\2\2\u00a5\u00a6\7W\2\2\u00a6"+
		"\u00a7\7G\2\2\u00a7\u00a8\7U\2\2\u00a8\u00a9\7\"\2\2\u00a9\u00aa\7H\2"+
		"\2\u00aa\u00ab\7T\2\2\u00ab\u00ac\7Q\2\2\u00ac\u00ad\7O\2\2\u00ad\u00ae"+
		"\7\"\2\2\u00ae\u00af\7T\2\2\u00af\u00b0\7G\2\2\u00b0\u00b1\7N\2\2\u00b1"+
		"\u00b2\7C\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7Q\2\2"+
		"\u00b5\u00b6\7P\2\2\u00b6\36\3\2\2\2\u00b7\u00b8\7F\2\2\u00b8\u00b9\7"+
		"G\2\2\u00b9\u00ba\7N\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc\7V\2\2\u00bc\u00bd"+
		"\7G\2\2\u00bd\u00be\7\"\2\2\u00be\u00bf\7H\2\2\u00bf\u00c0\7T\2\2\u00c0"+
		"\u00c1\7Q\2\2\u00c1\u00c2\7O\2\2\u00c2 \3\2\2\2\u00c3\u00c4\7u\2\2\u00c4"+
		"\u00c5\7g\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7e\2\2"+
		"\u00c8\u00c9\7v\2\2\u00c9\"\3\2\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7t"+
		"\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7l\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0"+
		"\7e\2\2\u00d0\u00d1\7v\2\2\u00d1$\3\2\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7o\2\2\u00d7"+
		"\u00d8\7g\2\2\u00d8&\3\2\2\2\u00d9\u00da\7-\2\2\u00da(\3\2\2\2\u00db\u00dc"+
		"\7/\2\2\u00dc*\3\2\2\2\u00dd\u00de\7,\2\2\u00de,\3\2\2\2\u00df\u00e0\7"+
		"(\2\2\u00e0.\3\2\2\2\u00e1\u00e2\7~\2\2\u00e2\u00e3\7~\2\2\u00e3\60\3"+
		"\2\2\2\u00e4\u00e5\7(\2\2\u00e5\u00e6\7(\2\2\u00e6\62\3\2\2\2\u00e7\u00e8"+
		"\7Q\2\2\u00e8\u00e9\7R\2\2\u00e9\u00ea\7G\2\2\u00ea\u00eb\7P\2\2\u00eb"+
		"\64\3\2\2\2\u00ec\u00ed\7E\2\2\u00ed\u00ee\7N\2\2\u00ee\u00ef\7Q\2\2\u00ef"+
		"\u00f0\7U\2\2\u00f0\u00f1\7G\2\2\u00f1\66\3\2\2\2\u00f2\u00f3\7Y\2\2\u00f3"+
		"\u00f4\7T\2\2\u00f4\u00f5\7K\2\2\u00f5\u00f6\7V\2\2\u00f6\u00f7\7G\2\2"+
		"\u00f78\3\2\2\2\u00f8\u00f9\7G\2\2\u00f9\u00fa\7Z\2\2\u00fa\u00fb\7K\2"+
		"\2\u00fb\u00fc\7V\2\2\u00fc:\3\2\2\2\u00fd\u00fe\7X\2\2\u00fe\u00ff\7"+
		"C\2\2\u00ff\u0100\7T\2\2\u0100\u0101\7E\2\2\u0101\u0102\7J\2\2\u0102\u0103"+
		"\7C\2\2\u0103\u0104\7T\2\2\u0104<\3\2\2\2\u0105\u0106\7K\2\2\u0106\u0107"+
		"\7P\2\2\u0107\u0108\7V\2\2\u0108\u0109\7G\2\2\u0109\u010a\7I\2\2\u010a"+
		"\u010b\7G\2\2\u010b\u010c\7T\2\2\u010c>\3\2\2\2\u010d\u010e\7?\2\2\u010e"+
		"\u0117\7?\2\2\u010f\u0110\7#\2\2\u0110\u0117\7?\2\2\u0111\u0117\t\2\2"+
		"\2\u0112\u0113\7>\2\2\u0113\u0117\7?\2\2\u0114\u0115\7@\2\2\u0115\u0117"+
		"\7?\2\2\u0116\u010d\3\2\2\2\u0116\u010f\3\2\2\2\u0116\u0111\3\2\2\2\u0116"+
		"\u0112\3\2\2\2\u0116\u0114\3\2\2\2\u0117@\3\2\2\2\u0118\u011d\5I%\2\u0119"+
		"\u011c\5I%\2\u011a\u011c\5G$\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2"+
		"\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011eB\3"+
		"\2\2\2\u011f\u011d\3\2\2\2\u0120\u0123\7$\2\2\u0121\u0124\5I%\2\u0122"+
		"\u0124\5G$\2\u0123\u0121\3\2\2\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2"+
		"\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128"+
		"\7$\2\2\u0128D\3\2\2\2\u0129\u012d\5K&\2\u012a\u012c\5G$\2\u012b\u012a"+
		"\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0132\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\7\62\2\2\u0131\u0129\3"+
		"\2\2\2\u0131\u0130\3\2\2\2\u0132F\3\2\2\2\u0133\u0134\t\3\2\2\u0134H\3"+
		"\2\2\2\u0135\u0136\t\4\2\2\u0136J\3\2\2\2\u0137\u0138\t\5\2\2\u0138L\3"+
		"\2\2\2\u0139\u013a\t\6\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b\'\2\2\u013c"+
		"N\3\2\2\2\n\2\u0116\u011b\u011d\u0123\u0125\u012d\u0131\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}