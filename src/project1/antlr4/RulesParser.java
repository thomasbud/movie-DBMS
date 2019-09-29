// Generated from /Users/engrbundle/IdeaProjects/BasicAntlrScript/src/project1/rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RulesParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_query = 2, RULE_show_cmd = 3, 
		RULE_create_cmd = 4, RULE_update_cmd = 5, RULE_insert_cmd = 6, RULE_delete_cmd = 7, 
		RULE_expr = 8, RULE_atomic_expr = 9, RULE_selection = 10, RULE_projection = 11, 
		RULE_renaming = 12, RULE_union = 13, RULE_difference = 14, RULE_product = 15, 
		RULE_natural_join = 16, RULE_condition = 17, RULE_conjunction = 18, RULE_comparison = 19, 
		RULE_operand = 20, RULE_literal = 21, RULE_attribute_list = 22, RULE_typed_attribute_list = 23, 
		RULE_open_cmd = 24, RULE_close_cmd = 25, RULE_write_cmd = 26, RULE_exit_cmd = 27, 
		RULE_attribute_name = 28, RULE_relation_name = 29, RULE_type = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "query", "show_cmd", "create_cmd", "update_cmd", 
			"insert_cmd", "delete_cmd", "expr", "atomic_expr", "selection", "projection", 
			"renaming", "union", "difference", "product", "natural_join", "condition", 
			"conjunction", "comparison", "operand", "literal", "attribute_list", 
			"typed_attribute_list", "open_cmd", "close_cmd", "write_cmd", "exit_cmd", 
			"attribute_name", "relation_name", "type"
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

	@Override
	public String getGrammarFileName() { return "rules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << T__11) | (1L << T__14) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(64);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(62);
					query();
					}
					break;
				case T__1:
				case T__2:
				case T__6:
				case T__11:
				case T__14:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
					{
					setState(63);
					command();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class CommandContext extends ParserRuleContext {
		public Open_cmdContext open_cmd() {
			return getRuleContext(Open_cmdContext.class,0);
		}
		public Close_cmdContext close_cmd() {
			return getRuleContext(Close_cmdContext.class,0);
		}
		public Write_cmdContext write_cmd() {
			return getRuleContext(Write_cmdContext.class,0);
		}
		public Exit_cmdContext exit_cmd() {
			return getRuleContext(Exit_cmdContext.class,0);
		}
		public Show_cmdContext show_cmd() {
			return getRuleContext(Show_cmdContext.class,0);
		}
		public Create_cmdContext create_cmd() {
			return getRuleContext(Create_cmdContext.class,0);
		}
		public Update_cmdContext update_cmd() {
			return getRuleContext(Update_cmdContext.class,0);
		}
		public Insert_cmdContext insert_cmd() {
			return getRuleContext(Insert_cmdContext.class,0);
		}
		public Delete_cmdContext delete_cmd() {
			return getRuleContext(Delete_cmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				open_cmd();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				close_cmd();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				write_cmd();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				exit_cmd();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				show_cmd();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				create_cmd();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(75);
				update_cmd();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 8);
				{
				setState(76);
				insert_cmd();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				delete_cmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class QueryContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			relation_name();
			setState(81);
			match(T__0);
			setState(82);
			expr();
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

	public static class Show_cmdContext extends ParserRuleContext {
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public Show_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterShow_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitShow_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitShow_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_cmdContext show_cmd() throws RecognitionException {
		Show_cmdContext _localctx = new Show_cmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_show_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__1);
			setState(85);
			atomic_expr();
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

	public static class Create_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Typed_attribute_listContext typed_attribute_list() {
			return getRuleContext(Typed_attribute_listContext.class,0);
		}
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Create_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterCreate_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitCreate_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitCreate_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_cmdContext create_cmd() throws RecognitionException {
		Create_cmdContext _localctx = new Create_cmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_create_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__2);
			setState(88);
			relation_name();
			setState(89);
			match(T__3);
			setState(90);
			typed_attribute_list();
			setState(91);
			match(T__4);
			setState(92);
			match(T__5);
			setState(93);
			match(T__3);
			setState(94);
			attribute_list();
			setState(95);
			match(T__4);
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

	public static class Update_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Update_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterUpdate_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitUpdate_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitUpdate_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_cmdContext update_cmd() throws RecognitionException {
		Update_cmdContext _localctx = new Update_cmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_update_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__6);
			setState(98);
			relation_name();
			setState(99);
			match(T__7);
			setState(100);
			attribute_name();
			setState(101);
			match(T__8);
			setState(102);
			literal();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(103);
				match(T__9);
				setState(104);
				attribute_name();
				setState(105);
				match(T__8);
				setState(106);
				literal();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(T__10);
			setState(114);
			condition();
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

	public static class Insert_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Insert_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterInsert_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitInsert_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitInsert_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_cmdContext insert_cmd() throws RecognitionException {
		Insert_cmdContext _localctx = new Insert_cmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_insert_cmd);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(T__11);
				setState(117);
				relation_name();
				setState(118);
				match(T__12);
				setState(119);
				literal();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(120);
					match(T__9);
					setState(121);
					literal();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(T__11);
				setState(128);
				relation_name();
				setState(129);
				match(T__13);
				setState(130);
				expr();
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

	public static class Delete_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Delete_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterDelete_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitDelete_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitDelete_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_cmdContext delete_cmd() throws RecognitionException {
		Delete_cmdContext _localctx = new Delete_cmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_delete_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__14);
			setState(135);
			relation_name();
			setState(136);
			match(T__10);
			setState(137);
			condition();
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
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public Natural_joinContext natural_join() {
			return getRuleContext(Natural_joinContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				atomic_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				selection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				projection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				renaming();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				union();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(144);
				difference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(145);
				product();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(146);
				natural_join();
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

	public static class Atomic_exprContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Atomic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterAtomic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitAtomic_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitAtomic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atomic_exprContext atomic_expr() throws RecognitionException {
		Atomic_exprContext _localctx = new Atomic_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atomic_expr);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				relation_name();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__3);
				setState(151);
				expr();
				setState(152);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SelectionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__15);
			setState(157);
			match(T__3);
			setState(158);
			condition();
			setState(159);
			match(T__4);
			setState(160);
			atomic_expr();
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

	public static class ProjectionContext extends ParserRuleContext {
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__16);
			setState(163);
			match(T__3);
			setState(164);
			attribute_list();
			setState(165);
			match(T__3);
			setState(166);
			atomic_expr();
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

	public static class RenamingContext extends ParserRuleContext {
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterRenaming(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitRenaming(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__17);
			setState(169);
			match(T__3);
			setState(170);
			attribute_list();
			setState(171);
			match(T__4);
			setState(172);
			atomic_expr();
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

	public static class UnionContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			atomic_expr();
			setState(175);
			match(T__18);
			setState(176);
			atomic_expr();
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

	public static class DifferenceContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			atomic_expr();
			setState(179);
			match(T__19);
			setState(180);
			atomic_expr();
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

	public static class ProductContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			atomic_expr();
			setState(183);
			match(T__20);
			setState(184);
			atomic_expr();
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

	public static class Natural_joinContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public Natural_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natural_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterNatural_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitNatural_join(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitNatural_join(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Natural_joinContext natural_join() throws RecognitionException {
		Natural_joinContext _localctx = new Natural_joinContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_natural_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			atomic_expr();
			setState(187);
			match(T__21);
			setState(188);
			atomic_expr();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			conjunction();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(191);
				match(T__22);
				setState(192);
				conjunction();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			comparison();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(199);
				match(T__23);
				setState(200);
				comparison();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OP() { return getToken(RulesParser.OP, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comparison);
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case STR_LITERAL:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				operand();
				setState(207);
				match(OP);
				setState(208);
				operand();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(T__3);
				setState(211);
				condition();
				setState(212);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class OperandContext extends ParserRuleContext {
		public Attribute_nameContext attribute_name() {
			return getRuleContext(Attribute_nameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_operand);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				attribute_name();
				}
				break;
			case STR_LITERAL:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STR_LITERAL() { return getToken(RulesParser.STR_LITERAL, 0); }
		public TerminalNode INTEGER() { return getToken(RulesParser.INTEGER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==STR_LITERAL || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Attribute_listContext extends ParserRuleContext {
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public Attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterAttribute_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitAttribute_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitAttribute_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_listContext attribute_list() throws RecognitionException {
		Attribute_listContext _localctx = new Attribute_listContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attribute_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			attribute_name();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(223);
				match(T__9);
				setState(224);
				attribute_name();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Typed_attribute_listContext extends ParserRuleContext {
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Typed_attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_attribute_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterTyped_attribute_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitTyped_attribute_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitTyped_attribute_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typed_attribute_listContext typed_attribute_list() throws RecognitionException {
		Typed_attribute_listContext _localctx = new Typed_attribute_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typed_attribute_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			attribute_name();
			setState(231);
			type();
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(232);
				match(T__9);
				setState(233);
				attribute_name();
				setState(234);
				type();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Open_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Open_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterOpen_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitOpen_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitOpen_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_cmdContext open_cmd() throws RecognitionException {
		Open_cmdContext _localctx = new Open_cmdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_open_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__24);
			setState(242);
			relation_name();
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

	public static class Close_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Close_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterClose_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitClose_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitClose_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Close_cmdContext close_cmd() throws RecognitionException {
		Close_cmdContext _localctx = new Close_cmdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_close_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__25);
			setState(245);
			relation_name();
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

	public static class Write_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Write_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterWrite_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitWrite_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitWrite_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_cmdContext write_cmd() throws RecognitionException {
		Write_cmdContext _localctx = new Write_cmdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_write_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__26);
			setState(248);
			relation_name();
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

	public static class Exit_cmdContext extends ParserRuleContext {
		public Exit_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterExit_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitExit_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitExit_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exit_cmdContext exit_cmd() throws RecognitionException {
		Exit_cmdContext _localctx = new Exit_cmdContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exit_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__27);
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

	public static class Attribute_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RulesParser.IDENTIFIER, 0); }
		public Attribute_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterAttribute_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitAttribute_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitAttribute_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_nameContext attribute_name() throws RecognitionException {
		Attribute_nameContext _localctx = new Attribute_nameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_attribute_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(IDENTIFIER);
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

	public static class Relation_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RulesParser.IDENTIFIER, 0); }
		public Relation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterRelation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitRelation_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitRelation_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relation_nameContext relation_name() throws RecognitionException {
		Relation_nameContext _localctx = new Relation_nameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_relation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(IDENTIFIER);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(RulesParser.INTEGER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener) ((RulesListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor) return ((RulesVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(T__28);
				setState(257);
				match(T__3);
				setState(258);
				match(INTEGER);
				setState(259);
				match(T__4);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(T__29);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\7\2C\n\2\f\2\16\2F\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3Q"+
		"\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7o\n\7\f\7\16\7r\13\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b}\n\b\f\b\16\b\u0080\13\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u0087\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0096\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u009d\n\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00c4\n\23\f\23\16\23\u00c7\13\23"+
		"\3\24\3\24\3\24\7\24\u00cc\n\24\f\24\16\24\u00cf\13\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u00d9\n\25\3\26\3\26\5\26\u00dd\n\26\3"+
		"\27\3\27\3\30\3\30\3\30\7\30\u00e4\n\30\f\30\16\30\u00e7\13\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\7\31\u00ef\n\31\f\31\16\31\u00f2\13\31\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		" \3 \3 \3 \3 \5 \u0108\n \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>\2\3\3\2#$\2\u0106\2D\3\2\2\2\4P\3\2\2\2\6"+
		"R\3\2\2\2\bV\3\2\2\2\nY\3\2\2\2\fc\3\2\2\2\16\u0086\3\2\2\2\20\u0088\3"+
		"\2\2\2\22\u0095\3\2\2\2\24\u009c\3\2\2\2\26\u009e\3\2\2\2\30\u00a4\3\2"+
		"\2\2\32\u00aa\3\2\2\2\34\u00b0\3\2\2\2\36\u00b4\3\2\2\2 \u00b8\3\2\2\2"+
		"\"\u00bc\3\2\2\2$\u00c0\3\2\2\2&\u00c8\3\2\2\2(\u00d8\3\2\2\2*\u00dc\3"+
		"\2\2\2,\u00de\3\2\2\2.\u00e0\3\2\2\2\60\u00e8\3\2\2\2\62\u00f3\3\2\2\2"+
		"\64\u00f6\3\2\2\2\66\u00f9\3\2\2\28\u00fc\3\2\2\2:\u00fe\3\2\2\2<\u0100"+
		"\3\2\2\2>\u0107\3\2\2\2@C\5\6\4\2AC\5\4\3\2B@\3\2\2\2BA\3\2\2\2CF\3\2"+
		"\2\2DB\3\2\2\2DE\3\2\2\2E\3\3\2\2\2FD\3\2\2\2GQ\5\62\32\2HQ\5\64\33\2"+
		"IQ\5\66\34\2JQ\58\35\2KQ\5\b\5\2LQ\5\n\6\2MQ\5\f\7\2NQ\5\16\b\2OQ\5\20"+
		"\t\2PG\3\2\2\2PH\3\2\2\2PI\3\2\2\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PM\3\2"+
		"\2\2PN\3\2\2\2PO\3\2\2\2Q\5\3\2\2\2RS\5<\37\2ST\7\3\2\2TU\5\22\n\2U\7"+
		"\3\2\2\2VW\7\4\2\2WX\5\24\13\2X\t\3\2\2\2YZ\7\5\2\2Z[\5<\37\2[\\\7\6\2"+
		"\2\\]\5\60\31\2]^\7\7\2\2^_\7\b\2\2_`\7\6\2\2`a\5.\30\2ab\7\7\2\2b\13"+
		"\3\2\2\2cd\7\t\2\2de\5<\37\2ef\7\n\2\2fg\5:\36\2gh\7\13\2\2hp\5,\27\2"+
		"ij\7\f\2\2jk\5:\36\2kl\7\13\2\2lm\5,\27\2mo\3\2\2\2ni\3\2\2\2or\3\2\2"+
		"\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\7\r\2\2tu\5$\23\2u\r\3\2"+
		"\2\2vw\7\16\2\2wx\5<\37\2xy\7\17\2\2y~\5,\27\2z{\7\f\2\2{}\5,\27\2|z\3"+
		"\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0087\3\2\2\2\u0080~"+
		"\3\2\2\2\u0081\u0082\7\16\2\2\u0082\u0083\5<\37\2\u0083\u0084\7\20\2\2"+
		"\u0084\u0085\5\22\n\2\u0085\u0087\3\2\2\2\u0086v\3\2\2\2\u0086\u0081\3"+
		"\2\2\2\u0087\17\3\2\2\2\u0088\u0089\7\21\2\2\u0089\u008a\5<\37\2\u008a"+
		"\u008b\7\r\2\2\u008b\u008c\5$\23\2\u008c\21\3\2\2\2\u008d\u0096\5\24\13"+
		"\2\u008e\u0096\5\26\f\2\u008f\u0096\5\30\r\2\u0090\u0096\5\32\16\2\u0091"+
		"\u0096\5\34\17\2\u0092\u0096\5\36\20\2\u0093\u0096\5 \21\2\u0094\u0096"+
		"\5\"\22\2\u0095\u008d\3\2\2\2\u0095\u008e\3\2\2\2\u0095\u008f\3\2\2\2"+
		"\u0095\u0090\3\2\2\2\u0095\u0091\3\2\2\2\u0095\u0092\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0094\3\2\2\2\u0096\23\3\2\2\2\u0097\u009d\5<\37\2\u0098"+
		"\u0099\7\6\2\2\u0099\u009a\5\22\n\2\u009a\u009b\7\7\2\2\u009b\u009d\3"+
		"\2\2\2\u009c\u0097\3\2\2\2\u009c\u0098\3\2\2\2\u009d\25\3\2\2\2\u009e"+
		"\u009f\7\22\2\2\u009f\u00a0\7\6\2\2\u00a0\u00a1\5$\23\2\u00a1\u00a2\7"+
		"\7\2\2\u00a2\u00a3\5\24\13\2\u00a3\27\3\2\2\2\u00a4\u00a5\7\23\2\2\u00a5"+
		"\u00a6\7\6\2\2\u00a6\u00a7\5.\30\2\u00a7\u00a8\7\6\2\2\u00a8\u00a9\5\24"+
		"\13\2\u00a9\31\3\2\2\2\u00aa\u00ab\7\24\2\2\u00ab\u00ac\7\6\2\2\u00ac"+
		"\u00ad\5.\30\2\u00ad\u00ae\7\7\2\2\u00ae\u00af\5\24\13\2\u00af\33\3\2"+
		"\2\2\u00b0\u00b1\5\24\13\2\u00b1\u00b2\7\25\2\2\u00b2\u00b3\5\24\13\2"+
		"\u00b3\35\3\2\2\2\u00b4\u00b5\5\24\13\2\u00b5\u00b6\7\26\2\2\u00b6\u00b7"+
		"\5\24\13\2\u00b7\37\3\2\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00ba\7\27\2\2"+
		"\u00ba\u00bb\5\24\13\2\u00bb!\3\2\2\2\u00bc\u00bd\5\24\13\2\u00bd\u00be"+
		"\7\30\2\2\u00be\u00bf\5\24\13\2\u00bf#\3\2\2\2\u00c0\u00c5\5&\24\2\u00c1"+
		"\u00c2\7\31\2\2\u00c2\u00c4\5&\24\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6%\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\u00cd\5(\25\2\u00c9\u00ca\7\32\2\2\u00ca\u00cc\5(\25\2"+
		"\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\'\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\5*\26\2\u00d1"+
		"\u00d2\7!\2\2\u00d2\u00d3\5*\26\2\u00d3\u00d9\3\2\2\2\u00d4\u00d5\7\6"+
		"\2\2\u00d5\u00d6\5$\23\2\u00d6\u00d7\7\7\2\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00d0\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d9)\3\2\2\2\u00da\u00dd\5:\36\2"+
		"\u00db\u00dd\5,\27\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd+\3"+
		"\2\2\2\u00de\u00df\t\2\2\2\u00df-\3\2\2\2\u00e0\u00e5\5:\36\2\u00e1\u00e2"+
		"\7\f\2\2\u00e2\u00e4\5:\36\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6/\3\2\2\2\u00e7\u00e5\3\2\2\2"+
		"\u00e8\u00e9\5:\36\2\u00e9\u00f0\5> \2\u00ea\u00eb\7\f\2\2\u00eb\u00ec"+
		"\5:\36\2\u00ec\u00ed\5> \2\u00ed\u00ef\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\61\3\2\2"+
		"\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\7\33\2\2\u00f4\u00f5\5<\37\2\u00f5"+
		"\63\3\2\2\2\u00f6\u00f7\7\34\2\2\u00f7\u00f8\5<\37\2\u00f8\65\3\2\2\2"+
		"\u00f9\u00fa\7\35\2\2\u00fa\u00fb\5<\37\2\u00fb\67\3\2\2\2\u00fc\u00fd"+
		"\7\36\2\2\u00fd9\3\2\2\2\u00fe\u00ff\7\"\2\2\u00ff;\3\2\2\2\u0100\u0101"+
		"\7\"\2\2\u0101=\3\2\2\2\u0102\u0103\7\37\2\2\u0103\u0104\7\6\2\2\u0104"+
		"\u0105\7$\2\2\u0105\u0108\7\7\2\2\u0106\u0108\7 \2\2\u0107\u0102\3\2\2"+
		"\2\u0107\u0106\3\2\2\2\u0108?\3\2\2\2\21BDPp~\u0086\u0095\u009c\u00c5"+
		"\u00cd\u00d8\u00dc\u00e5\u00f0\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}