// Generated from Calculette.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, RETURN=33, TYPE=34, IDENTIFIANT=35, NEWLINE=36, WS=37, ENTIER=38, 
		DOUBLE=39, COMMENTAIRE=40, COMMENTAIRELIGNE=41, UNMATCH=42;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_declaration = 2, RULE_assignation = 3, 
		RULE_readlnInstruction = 4, RULE_printlnInstruction = 5, RULE_instruction = 6, 
		RULE_args = 7, RULE_expression = 8, RULE_bloc = 9, RULE_whileInstruction = 10, 
		RULE_forInstruction = 11, RULE_condition = 12, RULE_ifElse = 13, RULE_params = 14, 
		RULE_fonction = 15, RULE_finInstruction = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "declaration", "assignation", "readlnInstruction", 
			"printlnInstruction", "instruction", "args", "expression", "bloc", "whileInstruction", 
			"forInstruction", "condition", "ifElse", "params", "fonction", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+='", "'readln'", "'('", "')'", "'println'", "','", "'-'", 
			"'*'", "'/'", "'%'", "'+'", "'{'", "'}'", "'while'", "'for'", "';'", 
			"'True'", "'False'", "'<'", "'>'", "'=='", "'<>'", "'<='", "'>='", "'&&'", 
			"'!'", "'||'", "'if'", "'else'", "'fun'", "'->'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "RETURN", "TYPE", 
			"IDENTIFIANT", "NEWLINE", "WS", "ENTIER", "DOUBLE", "COMMENTAIRE", "COMMENTAIRELIGNE", 
			"UNMATCH"
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
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    //Déclaration de variables privées
	    private int _cur_label = 0;
	    private String newLabel() { return "Label" + (_cur_label++); }; 
	    private TablesSymboles tablesSymboles = new TablesSymboles();

	    // Fonction pour évaluer une expression arithmétique
	    private String evalexpr(String x, String op, String y, String type) {
	        if (type.equals("int")) {
	            switch (op) {
	                case "*": return x + y + "MUL\n";
	                case "/": return x + y + "DIV\n";
	                case "+": return x + y + "ADD\n";
	                case "-": return x + y + "SUB\n";
	                case "%": return x + y + "MOD\n";
	                default:
	                    System.err.println("Operateur arithmetique incorrect : '" + op + "'");
	                    throw new IllegalArgumentException("Operateur arithmétique incorrect : '" + op + "'");
	            }
	        } else if (type.equals("double")) {
	            switch (op) {
	                case "*": return x + y + "FMUL\n";
	                case "/": return x + y + "FDIV\n";
	                case "+": return x + y + "FADD\n";
	                case "-": return x + y + "FSUB\n";
	                default:
	                    System.err.println("Operateur arithmetique incorrect : '" + op + "'");
	                    throw new IllegalArgumentException("Operateur arithmétique incorrect : '" + op + "'");
	            }
	        } else {
	            System.err.println("Type d'opérande incorrect : '" + type + "'");
	            throw new IllegalArgumentException("Type d'opérande incorrect : '" + type + "'");
	        }
	    }

	    // Fonction pour évaluer une condition
	    private String evalCondition(String leftCode, String operator, String rightCode, String type) {
	        String code = leftCode + rightCode;
	        if (type.equals("int")) {
	            switch (operator) {
	                case "<": code += "INF\n"; break;
	                case ">": code += "SUP\n"; break;
	                case "==": code += "EQUAL\n"; break;
	                case "<>": code += "NEQ\n"; break;
	                case "<=": code += "INFEQ\n"; break;
	                case ">=": code += "SUPEQ\n"; break;
	                default:
	                    System.err.println("Operateur relationnel incorrect : '" + operator + "'");
	                    throw new IllegalArgumentException("Operateur relationnel incorrect : '" + operator + "'");
	            }
	        } else if (type.equals("double")) {
	            switch (operator) {
	                case "<": code += "FINF\n"; break;
	                case ">": code += "FSUP\n"; break;
	                case "==": code += "FEQUAL\n"; break;
	                case "<>": code += "FNEQ\n"; break;
	                case "<=": code += "FINFEQ\n"; break;
	                case ">=": code += "FSUPEQ\n"; break;
	                default:
	                    System.err.println("Operateur relationnel incorrect : '" + operator + "'");
	                    throw new IllegalArgumentException("Operateur relationnel incorrect : '" + operator + "'");
	            }
	        } else {
	            System.err.println("Type d'opérande incorrect : '" + type + "'");
	            throw new IllegalArgumentException("Type d'opérande incorrect : '" + type + "'");
	        }
	        return code;
	    }


	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			calcul();
			setState(35);
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclarationContext declaration;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(37);
				((CalculContext)_localctx).declaration = declaration();
				 _localctx.code += ((CalculContext)_localctx).declaration.code; 
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  JUMP Main\n"; 
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(46);
					match(NEWLINE);
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(52);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code; 
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					match(NEWLINE);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL Main\n"; 
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__28) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE))) != 0)) {
				{
				{
				setState(67);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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

	public static class DeclarationContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public ConditionContext condition;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				((DeclarationContext)_localctx).TYPE = match(TYPE);
				setState(78);
				((DeclarationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(79);
				finInstruction();

				        String varName = (((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null);
				        String varType = (((DeclarationContext)_localctx).TYPE!=null?((DeclarationContext)_localctx).TYPE.getText():null);
				        tablesSymboles.addVarDecl(varName, varType);
				        ((DeclarationContext)_localctx).code =  "";
				        if (varType.equals("int") ||varType.equals("bool") ) {
				             _localctx.code += "PUSHI 0\n";
				        } else if(varType.equals("double")){
				            _localctx.code += "PUSHF 0.0\n";
				        }else{
				            System.err.println("Type de variable non pris en charge : '" + varType + "'");
				            throw new IllegalArgumentException("Type de variable non pris en charge : '" + varType + "'");
				        }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((DeclarationContext)_localctx).TYPE = match(TYPE);
				setState(83);
				((DeclarationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(84);
				match(T__0);
				setState(85);
				((DeclarationContext)_localctx).expression = expression(0);
				setState(86);
				finInstruction();

				        String varName = (((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null);
				        String varType = (((DeclarationContext)_localctx).TYPE!=null?((DeclarationContext)_localctx).TYPE.getText():null);
				        tablesSymboles.addVarDecl(varName, varType);
				        VariableInfo varInfo = tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null));

				        if (varType.equals("int")) {
				            ((DeclarationContext)_localctx).code =  "PUSHI 0\n";
				            _localctx.code += ((DeclarationContext)_localctx).expression.code;
				            if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                _localctx.code += "STOREL " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                _localctx.code += "STOREG " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                _localctx.code += "STOREG " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            }else{ 
				                System.err.println("erreur scope de la variable dans declaration");
				            }
				        } else if (varType.equals("double")) {
				            ((DeclarationContext)_localctx).code =  "PUSHF 0.0\n";
				            _localctx.code += ((DeclarationContext)_localctx).expression.code;
				            if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                _localctx.code += "STOREL " + (tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address+1 ) + "\n";
				                _localctx.code += "STOREL " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                _localctx.code += "STOREG " + (tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address+1 )+ "\n";
				                _localctx.code += "STOREG " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                _localctx.code += "STOREG " + (tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address+1 )+ "\n";
				                _localctx.code += "STOREG " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            }else{ 
				                System.err.println("erreur scope de la variable dans declaration");
				            }

				        } else {
				            System.err.println("Type de variable non pris en charge : '" + varType + "' dans declaration");
				            throw new IllegalArgumentException("Type de variable non pris en charge : '" + varType + "'");
				        }
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((DeclarationContext)_localctx).TYPE = match(TYPE);
				setState(90);
				((DeclarationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(91);
				match(T__0);
				setState(92);
				((DeclarationContext)_localctx).condition = condition(0);
				setState(93);
				finInstruction();

				        String varName = (((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null);
				        String varType = (((DeclarationContext)_localctx).TYPE!=null?((DeclarationContext)_localctx).TYPE.getText():null);
				        tablesSymboles.addVarDecl(varName, varType);
				        VariableInfo varInfo = tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null));

				        if (varType.equals("bool")) {
				            ((DeclarationContext)_localctx).code =  "PUSHI 0\n";
				            _localctx.code += ((DeclarationContext)_localctx).condition.code;
				            if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                _localctx.code += "STOREL " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                _localctx.code += "STOREG " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                _localctx.code += "STOREG " + tablesSymboles.getVar((((DeclarationContext)_localctx).IDENTIFIANT!=null?((DeclarationContext)_localctx).IDENTIFIANT.getText():null)).address + "\n";
				            }else{ 
				                System.err.println("erreur scope de la variable dans declaration");
				            }
				        } 
				        else {
				            System.err.println("Type de variable non pris en charge : '" + varType + "' dans declaration");
				            throw new IllegalArgumentException("Type de variable non pris en charge : '" + varType + "'");
				        }
				    
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public ConditionContext condition;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignation);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(99);
				match(T__0);
				setState(100);
				((AssignationContext)_localctx).expression = expression(0);
				  
				           ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code;
				           VariableInfo varInfo = tablesSymboles.getVar((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));

				           if (varInfo != null) {
				                if(varInfo.type.equals("int")){
				                    if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                        _localctx.code += "STOREL " + varInfo.address + "\n";
				                    } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                        _localctx.code += "STOREG " + varInfo.address + "\n";
				                    }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                        _localctx.code += "STOREG " + varInfo.address + "\n";
				                    }else{
				                        System.err.println("erreur scope de la variable de type int dans assignation");
				                    }
				                }else{
				                    if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                        _localctx.code += "STOREL " + (varInfo.address + 1)+ "\n";
				                        _localctx.code += "STOREL " + varInfo.address + "\n";
				                    } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                        _localctx.code += "STOREG " + (varInfo.address+1) + "\n";
				                        _localctx.code += "STOREG " + varInfo.address + "\n";
				                    }else if (VariableInfo.Scope.LOCAL == varInfo.scope) {
				                        _localctx.code += "STOREG " + (varInfo.address+1) + "\n";
				                        _localctx.code += "STOREG " + varInfo.address + "\n";
				                    }else{
				                        System.err.println("erreur scope de la variable de type double dans assignation");
				                    }
				                }
				           }else {
				                System.err.println("La variable '" + (((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null) + "' n'est pas déclarée");
				                throw new IllegalArgumentException("La variable '" + (((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null) + "' n'est pas déclarée");
				           }
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(104);
				match(T__1);
				setState(105);
				((AssignationContext)_localctx).expression = expression(0);
				   
				            VariableInfo varInfo = tablesSymboles.getVar((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code;
				            if(((AssignationContext)_localctx).expression.exprType.equals("int")){
				                if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                _localctx.code += "PUSHL " + varInfo.address + "\n";
				                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                    _localctx.code += "PUSHG " + varInfo.address + "\n";
				                }else if (VariableInfo.Scope.LOCAL == varInfo.scope) {
				                    _localctx.code += "PUSHG " + varInfo.address + "\n";
				                }else{
				                    System.err.println("erreur scope de la variable dans assignation += ");
				                }
				                _localctx.code += "ADD\n";
				                if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                    _localctx.code += "STOREL " + varInfo.address + "\n";
				                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope){
				                _localctx.code += "STOREG " + varInfo.address + "\n";
				                } if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                _localctx.code += "STOREG " + varInfo.address + "\n";
				                }else{
				                    System.err.println("erreur scope de la variable dans assignation += ");
				                } 

				            }else if(((AssignationContext)_localctx).expression.exprType.equals("double")){
				                if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                    _localctx.code += "PUSHL " +(varInfo.address+1)+"\n";
				                    _localctx.code += "PUSHL " +varInfo.address+"\n";
				                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                    _localctx.code += "PUSHG " + (varInfo.address+1) + "\n";
				                    _localctx.code += "PUSHG " + varInfo.address + "\n";
				                }else if (VariableInfo.Scope.LOCAL == varInfo.scope) {
				                    _localctx.code += "PUSHG " + (varInfo.address+1) + "\n";
				                    _localctx.code += "PUSHG " + varInfo.address + "\n";
				                }else{
				                    System.err.println("erreur scope de la variable dans assignation += ");
				                }
				                _localctx.code += "ADD\n";
				                if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                    _localctx.code += "STOREL " + varInfo.address + "\n";
				                    _localctx.code += "STOREL " + (varInfo.address+1) + "\n";
				                } else if (VariableInfo.Scope.GLOBAL == varInfo.scope){
				                    _localctx.code += "STOREG " + varInfo.address + "\n";
				                    _localctx.code += "STOREG " + (varInfo.address+1) + "\n";
				                } if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                    _localctx.code += "STOREG " + varInfo.address + "\n";
				                    _localctx.code += "STOREG " + (varInfo.address+1) + "\n";
				                }else{
				                    System.err.println("erreur scope de la variable dans assignation += ");
				                } 
				            }else{
				                System.err.println("Type de variable non pris en charge dans assignation");

				            }
				            
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(109);
				match(T__0);
				setState(110);
				((AssignationContext)_localctx).condition = condition(0);
				  
				           ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).condition.code;
				           VariableInfo varInfo = tablesSymboles.getVar((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));

				           if (varInfo != null) {
				                if(varInfo.type.equals("bool")){
				                    if (VariableInfo.Scope.PARAM == varInfo.scope) {
				                        _localctx.code += "STOREL " + varInfo.address + "\n";
				                    } else if (VariableInfo.Scope.GLOBAL == varInfo.scope) {
				                        _localctx.code += "STOREG " + varInfo.address + "\n";
				                    }else if (VariableInfo.Scope.LOCAL == varInfo.scope){
				                        _localctx.code += "STOREG " + varInfo.address + "\n";
				                    }else{
				                        System.err.println("erreur scope de la variable de type int dans assignation");
				                    }
				                }
				           }else {
				                System.err.println("La variable '" + (((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null) + "' n'est pas déclarée");
				                throw new IllegalArgumentException("La variable '" + (((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null) + "' n'est pas déclarée");
				           }
				        
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

	public static class ReadlnInstructionContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ReadlnInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readlnInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterReadlnInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitReadlnInstruction(this);
		}
	}

	public final ReadlnInstructionContext readlnInstruction() throws RecognitionException {
		ReadlnInstructionContext _localctx = new ReadlnInstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_readlnInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__2);
			setState(116);
			match(T__3);
			setState(117);
			((ReadlnInstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(118);
			match(T__4);

			        VariableInfo varInfo = tablesSymboles.getVar((((ReadlnInstructionContext)_localctx).IDENTIFIANT!=null?((ReadlnInstructionContext)_localctx).IDENTIFIANT.getText():null));
			        if (varInfo != null) {
			            ((ReadlnInstructionContext)_localctx).code =  "";

			            //Lecture d'une valeur entière depuis l'entrée standard
			            if(varInfo.type.equals("int")){
			                _localctx.code += "READ\n";
			                if (VariableInfo.Scope.PARAM == varInfo.scope) {
			                    _localctx.code += "STOREL " + varInfo.address + "\n";
			                } else {
			                    _localctx.code += "STOREG " + varInfo.address + "\n";
			                }
			            
			            // Lecture d'une valeur flottante depuis l'entrée standard
			            } else if(varInfo.type.equals("double")){
			                _localctx.code += "READF\n";
			                if (VariableInfo.Scope.PARAM == varInfo.scope) {
			                    _localctx.code += "STOREL " + (varInfo.address + 1) + "\n";
			                    _localctx.code += "STOREL " + varInfo.address + "\n";
			                } else {
			                    _localctx.code += "STOREG " + (varInfo.address + 1) + "\n";
			                    _localctx.code += "STOREG " + varInfo.address + "\n";
			                }
			            }else{
			                System.err.println("Type de variable non pris en charge : '" + varInfo.type + "' dans readlnInstruction");
			            }    
			        } else {
			            System.err.println("La variable '" + (((ReadlnInstructionContext)_localctx).IDENTIFIANT!=null?((ReadlnInstructionContext)_localctx).IDENTIFIANT.getText():null) + "' n'est pas déclarée dans readlnInstruction");
			            throw new IllegalArgumentException("La variable '" + (((ReadlnInstructionContext)_localctx).IDENTIFIANT!=null?((ReadlnInstructionContext)_localctx).IDENTIFIANT.getText():null) + "' n'est pas déclarée");
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

	public static class PrintlnInstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintlnInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printlnInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterPrintlnInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitPrintlnInstruction(this);
		}
	}

	public final PrintlnInstructionContext printlnInstruction() throws RecognitionException {
		PrintlnInstructionContext _localctx = new PrintlnInstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printlnInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__5);
			setState(122);
			match(T__3);
			setState(123);
			((PrintlnInstructionContext)_localctx).expression = expression(0);
			setState(124);
			match(T__4);
			   
			        // Affichage d'une expression entière , décimale ou booléenne
			        if(((PrintlnInstructionContext)_localctx).expression.exprType.equals("double")){
			            ((PrintlnInstructionContext)_localctx).code =  ((PrintlnInstructionContext)_localctx).expression.code + "WRITEF \nPOP\nPOP \n";
			        }else if(((PrintlnInstructionContext)_localctx).expression.exprType.equals("int") || ((PrintlnInstructionContext)_localctx).expression.exprType.equals("bool")){
			            ((PrintlnInstructionContext)_localctx).code =  ((PrintlnInstructionContext)_localctx).expression.code + "WRITE \nPOP \n";
			        }else{
			            System.err.println("Type d'expression  non pris en charge dans printlnInstruction");
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public PrintlnInstructionContext printlnInstruction;
		public AssignationContext assignation;
		public ReadlnInstructionContext readlnInstruction;
		public BlocContext bloc;
		public WhileInstructionContext whileInstruction;
		public ForInstructionContext forInstruction;
		public IfElseContext ifElse;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public PrintlnInstructionContext printlnInstruction() {
			return getRuleContext(PrintlnInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CalculetteParser.RETURN, 0); }
		public ReadlnInstructionContext readlnInstruction() {
			return getRuleContext(ReadlnInstructionContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public WhileInstructionContext whileInstruction() {
			return getRuleContext(WhileInstructionContext.class,0);
		}
		public ForInstructionContext forInstruction() {
			return getRuleContext(ForInstructionContext.class,0);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instruction);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((InstructionContext)_localctx).expression = expression(0);
				setState(128);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				((InstructionContext)_localctx).printlnInstruction = printlnInstruction();
				setState(132);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).printlnInstruction.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				((InstructionContext)_localctx).assignation = assignation();
				setState(136);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(RETURN);
				setState(140);
				((InstructionContext)_localctx).expression = expression(0);
				setState(141);
				finInstruction();

				            VariableInfo returnVarInfo = tablesSymboles.getReturn();
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				            if(((InstructionContext)_localctx).expression.exprType.equals("int")){
				                _localctx.code += "STOREL " + returnVarInfo.address + "\n";
				                
				            }else if(((InstructionContext)_localctx).expression.exprType.equals("double")){
				                    _localctx.code += "STOREL " + (returnVarInfo.address + 1) + "\n";
				                    _localctx.code += "STOREL " + returnVarInfo.address + "\n";
				            }
				            else{
				                System.err.println("Type d'expression  non pris en charge dans RETURN");
				            }
				            _localctx.code+="RETURN\n";
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				((InstructionContext)_localctx).readlnInstruction = readlnInstruction();
				setState(145);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).readlnInstruction.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				((InstructionContext)_localctx).bloc = bloc();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bloc.code;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				((InstructionContext)_localctx).whileInstruction = whileInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).whileInstruction.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(154);
				((InstructionContext)_localctx).forInstruction = forInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).forInstruction.code;
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(157);
				((InstructionContext)_localctx).ifElse = ifElse();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).ifElse.code;
				        
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(160);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__7) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << DOUBLE))) != 0)) {
				{
				setState(165);
				((ArgsContext)_localctx).expression = expression(0);

				        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code;
				        if(((ArgsContext)_localctx).expression.exprType.equals("double")){
				            _localctx.size+=2;    
				        }
				        else if(((ArgsContext)_localctx).expression.exprType.equals("int")){
				            _localctx.size+=1;    
				        }
				        
				    
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(167);
					match(T__6);
					setState(168);
					((ArgsContext)_localctx).expression = expression(0);

					            
					            _localctx.code += ((ArgsContext)_localctx).expression.code;
					            if(((ArgsContext)_localctx).expression.exprType.equals("double")){
					                _localctx.size+=2;    
					            }
					            else if(((ArgsContext)_localctx).expression.exprType.equals("int")){
					                _localctx.size+=1;    
					            }        
					        
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public String exprType;
		public ExpressionContext a;
		public ExpressionContext expression;
		public Token ENTIER;
		public Token DOUBLE;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode DOUBLE() { return getToken(CalculetteParser.DOUBLE, 0); }
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(179);
				match(T__7);
				setState(180);
				((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(9);
				 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "PUSHI -1\nMUL\n"; ((ExpressionContext)_localctx).exprType =  ((ExpressionContext)_localctx).expression.exprType;
				}
				break;
			case 2:
				{
				setState(183);
				match(T__3);
				setState(184);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(185);
				match(T__4);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).expression.code ;((ExpressionContext)_localctx).exprType =  ((ExpressionContext)_localctx).expression.exprType;
				}
				break;
			case 3:
				{
				setState(188);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) + "\n";((ExpressionContext)_localctx).exprType =  "int";
				}
				break;
			case 4:
				{
				setState(190);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);
				 ((ExpressionContext)_localctx).code =  "PUSHF " + (((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null) + "\n";((ExpressionContext)_localctx).exprType =  "double";
				}
				break;
			case 5:
				{
				setState(192);
				match(T__3);
				setState(193);
				((ExpressionContext)_localctx).TYPE = match(TYPE);
				setState(194);
				match(T__4);
				setState(195);
				((ExpressionContext)_localctx).a = ((ExpressionContext)_localctx).expression = expression(3);
				   
				            if((((ExpressionContext)_localctx).TYPE!=null?((ExpressionContext)_localctx).TYPE.getText():null).equals("double")){
				                if(((ExpressionContext)_localctx).a.exprType.equals("int")){
				                    ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				                    _localctx.code += "ITOF\n";
				                    ((ExpressionContext)_localctx).exprType =  "double";
				                }else if(((ExpressionContext)_localctx).a.exprType.equals("bool")){
				                    ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				                    _localctx.code += "ITOF\n";
				                    ((ExpressionContext)_localctx).exprType =  "double";
				                }
				            }
				            
				            if((((ExpressionContext)_localctx).TYPE!=null?((ExpressionContext)_localctx).TYPE.getText():null).equals("int")){
				                if(((ExpressionContext)_localctx).a.exprType.equals("double")){
				                    ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				                    _localctx.code += "FTOI\n";
				                    ((ExpressionContext)_localctx).exprType =  "int";
				                }else if(((ExpressionContext)_localctx).a.exprType.equals("bool")){
				                    ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				                    ((ExpressionContext)_localctx).exprType =  "int";
				                }
				            }
				            if((((ExpressionContext)_localctx).TYPE!=null?((ExpressionContext)_localctx).TYPE.getText():null).equals("bool")){
				                if(((ExpressionContext)_localctx).a.exprType.equals("double")){
				                    ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				                    _localctx.code += "PUSHF 0.0\n";
				                    _localctx.code += "FSUP\n";
				                    ((ExpressionContext)_localctx).exprType =  "bool";
				                }else if(((ExpressionContext)_localctx).a.exprType.equals("int")){
				                    ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				                    _localctx.code += "PUSHI 0\n";
				                    _localctx.code += "SUP\n";
				                    ((ExpressionContext)_localctx).exprType =  "bool";
				                }  
				            }
				        
				}
				break;
			case 6:
				{
				setState(198);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				   
				            VariableInfo varInfo = tablesSymboles.getVar((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            if(varInfo.type.equals("int")){
				                if(VariableInfo.Scope.PARAM == varInfo.scope){
				                ((ExpressionContext)_localctx).code =  "PUSHL " +varInfo.address+"\n";
				                }else {
				                    ((ExpressionContext)_localctx).code =  "PUSHG " +varInfo.address+"\n";
				                }
				                ((ExpressionContext)_localctx).exprType =  varInfo.type;
				            }else if(varInfo.type.equals("double")){
				                if(VariableInfo.Scope.PARAM == varInfo.scope){
				                ((ExpressionContext)_localctx).code =  "PUSHL " +varInfo.address+"\n";
				                _localctx.code += "PUSHL " +(varInfo.address+1)+"\n";
				                }else {
				                    ((ExpressionContext)_localctx).code =  "PUSHG " +varInfo.address+"\n";
				                    _localctx.code += "PUSHG " +(varInfo.address+1) +"\n";
				                }
				                ((ExpressionContext)_localctx).exprType =  varInfo.type;
				            }else if(varInfo.type.equals("bool")){
				                if(VariableInfo.Scope.PARAM == varInfo.scope){
				                ((ExpressionContext)_localctx).code =  "PUSHL " +varInfo.address+"\n";
				                }else {
				                    ((ExpressionContext)_localctx).code =  "PUSHG " +varInfo.address+"\n";
				                }
				                ((ExpressionContext)_localctx).exprType =  varInfo.type;
				            }else{
				                System.err.println("Type de variable  non pris en charge dans expression");
				            }
				        
				}
				break;
			case 7:
				{
				setState(200);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(201);
				match(T__3);
				setState(202);
				((ExpressionContext)_localctx).args = args();
				setState(203);
				match(T__4);

				            if(tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).equals("int")){
				                ((ExpressionContext)_localctx).code = "PUSHI 0\n";
				                _localctx.code += ((ExpressionContext)_localctx).args.code;
				                _localctx.code += "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n";

				                for(int i=0; i < ((ExpressionContext)_localctx).args.size; i++){
				                _localctx.code +="POP\n";
				                }
				                ((ExpressionContext)_localctx).exprType =  tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));  
				            }else if(tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).equals("double")){
				                ((ExpressionContext)_localctx).code = "PUSHF 0.0\n";
				                _localctx.code += ((ExpressionContext)_localctx).args.code;
				                _localctx.code += "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n";

				                for(int i=0; i < ((ExpressionContext)_localctx).args.size; i++){
				                _localctx.code +="POP\n";
				                }
				                ((ExpressionContext)_localctx).exprType =  tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));  
				            }else{ 
				                System.err.println("Type de retour de la fonction non pris en charge dans expression");

				            }
				            
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(218);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(209);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(210);
						((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code,((ExpressionContext)_localctx).a.exprType);((ExpressionContext)_localctx).exprType =  ((ExpressionContext)_localctx).a.exprType;
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(214);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__11) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						((ExpressionContext)_localctx).b = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code,((ExpressionContext)_localctx).a.exprType);((ExpressionContext)_localctx).exprType =  ((ExpressionContext)_localctx).a.exprType;
						}
						break;
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bloc);
		 ((BlocContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__12);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(224);
					((BlocContext)_localctx).instruction = instruction();
					 _localctx.code += ((BlocContext)_localctx).instruction.code; 
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(232);
				match(NEWLINE);
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			match(T__13);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(239);
					match(NEWLINE);
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class WhileInstructionContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public WhileInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterWhileInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitWhileInstruction(this);
		}
	}

	public final WhileInstructionContext whileInstruction() throws RecognitionException {
		WhileInstructionContext _localctx = new WhileInstructionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileInstruction);
		String labelStart = newLabel();String labelEnd = newLabel();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(T__14);
			setState(246);
			match(T__3);
			setState(247);
			((WhileInstructionContext)_localctx).condition = condition(0);
			setState(248);
			match(T__4);
			setState(249);
			((WhileInstructionContext)_localctx).instruction = instruction();

			            ((WhileInstructionContext)_localctx).code =  "LABEL "+labelStart+"\n";
			            _localctx.code += ((WhileInstructionContext)_localctx).condition.code;
			            _localctx.code += "JUMPF "+labelEnd+"\n";        
			            _localctx.code += ((WhileInstructionContext)_localctx).instruction.code;
			            _localctx.code += "JUMP "+labelStart+"\n";
			            _localctx.code += "LABEL "+labelEnd+"\n";
			        
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

	public static class ForInstructionContext extends ParserRuleContext {
		public String code;
		public AssignationContext g;
		public ConditionContext condition;
		public AssignationContext d;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public ForInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterForInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitForInstruction(this);
		}
	}

	public final ForInstructionContext forInstruction() throws RecognitionException {
		ForInstructionContext _localctx = new ForInstructionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forInstruction);
		String labelStart = newLabel(); String labelEnd = newLabel();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__15);
			setState(253);
			match(T__3);
			setState(254);
			((ForInstructionContext)_localctx).g = assignation();
			setState(255);
			match(T__16);
			setState(256);
			((ForInstructionContext)_localctx).condition = condition(0);
			setState(257);
			match(T__16);
			setState(258);
			((ForInstructionContext)_localctx).d = assignation();
			setState(259);
			match(T__4);
			setState(260);
			((ForInstructionContext)_localctx).instruction = instruction();
			   
			            ((ForInstructionContext)_localctx).code =  ((ForInstructionContext)_localctx).g.code;

			            _localctx.code += "LABEL "+labelStart+"\n";
			            _localctx.code += ((ForInstructionContext)_localctx).condition.code;
			            _localctx.code += "JUMPF "+labelEnd+"\n";
			            _localctx.code += ((ForInstructionContext)_localctx).instruction.code;
			            _localctx.code += ((ForInstructionContext)_localctx).d.code;
			            _localctx.code += "JUMP "+labelStart+"\n";
			            _localctx.code += "LABEL "+labelEnd+"\n";
			        
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
		public String code;
		public String condType;
		public ConditionContext gc;
		public Token IDENTIFIANT;
		public ExpressionContext g;
		public Token op;
		public ExpressionContext d;
		public ConditionContext a;
		public ConditionContext dc;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(264);
				match(T__17);
				 
				            ((ConditionContext)_localctx).code =  "PUSHI 1\n"; 
				            ((ConditionContext)_localctx).condType =  "int"; 
				        
				}
				break;
			case 2:
				{
				setState(266);
				match(T__18);
				 
				            ((ConditionContext)_localctx).code =  "PUSHI 0\n"; 
				            ((ConditionContext)_localctx).condType =  "int"; 
				        
				}
				break;
			case 3:
				{
				setState(268);
				((ConditionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				   
				            VariableInfo varInfo = tablesSymboles.getVar((((ConditionContext)_localctx).IDENTIFIANT!=null?((ConditionContext)_localctx).IDENTIFIANT.getText():null));
				            if(varInfo.type.equals("bool")){
				                if(VariableInfo.Scope.PARAM == varInfo.scope){
				                    ((ConditionContext)_localctx).code =  "PUSHL " +varInfo.address+"\n";
				                } else {
				                    ((ConditionContext)_localctx).code =  "PUSHG " +varInfo.address+"\n";
				                }
				            } else {
				                System.err.println("Type de variable non pris en charge dans expression");
				            }
				            ((ConditionContext)_localctx).condType =  "int";
				        
				}
				break;
			case 4:
				{
				setState(270);
				((ConditionContext)_localctx).g = expression(0);
				setState(271);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(272);
				((ConditionContext)_localctx).d = expression(0);
				 
				            ((ConditionContext)_localctx).code =  evalCondition(((ConditionContext)_localctx).g.code, (((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null), ((ConditionContext)_localctx).d.code, ((ConditionContext)_localctx).g.exprType);
				            ((ConditionContext)_localctx).condType =  ((ConditionContext)_localctx).g.exprType;
				        
				}
				break;
			case 5:
				{
				setState(275);
				match(T__26);
				setState(276);
				((ConditionContext)_localctx).a = condition(3);
				 
				            ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code;
				            if (((ConditionContext)_localctx).a.condType.equals("int")) {
				                _localctx.code += "PUSHI 0\nEQUAL\n";
				            } else if (((ConditionContext)_localctx).a.condType.equals("double")) {
				                _localctx.code += "PUSHF 0.0\nFEQUAL\n";
				            } else {
				                System.err.println("Type de condition non pris en charge dans condition");
				            }
				            ((ConditionContext)_localctx).condType =  "int";
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.gc = _prevctx;
						_localctx.gc = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(281);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(282);
						match(T__25);
						setState(283);
						((ConditionContext)_localctx).dc = condition(3);
						 
						                      ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).gc.code + ((ConditionContext)_localctx).dc.code;
						                      if (((ConditionContext)_localctx).gc.condType.equals("int") && ((ConditionContext)_localctx).dc.condType.equals("int")) {
						                          _localctx.code += "MUL\n";
						                          ((ConditionContext)_localctx).condType =  "int";
						                      } else if (((ConditionContext)_localctx).gc.condType.equals("double") || ((ConditionContext)_localctx).dc.condType.equals("double")) {
						                          _localctx.code += "FMUL\n";
						                          ((ConditionContext)_localctx).condType =  "double";
						                      } else {
						                          System.err.println("Type de condition non pris en charge dans condition");
						                      }
						                  
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.gc = _prevctx;
						_localctx.gc = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(286);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(287);
						match(T__27);
						setState(288);
						((ConditionContext)_localctx).dc = condition(2);
						 
						                      ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).gc.code + ((ConditionContext)_localctx).dc.code;
						                      if (((ConditionContext)_localctx).gc.condType.equals("int") && ((ConditionContext)_localctx).dc.condType.equals("int")) {
						                          _localctx.code += "ADD\nPUSHI 1\nSUPEQ\n";
						                          ((ConditionContext)_localctx).condType =  "int";
						                      } else if (((ConditionContext)_localctx).gc.condType.equals("double") || ((ConditionContext)_localctx).dc.condType.equals("double")) {
						                          _localctx.code += "ADD\nPUSHF 1.0\nFSUPEQ\n";
						                          ((ConditionContext)_localctx).condType =  "double";
						                      } else {
						                          System.err.println("Type de condition non pris en charge dans condition");
						                      }
						                  
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class IfElseContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instructionThen;
		public InstructionContext instructionElse;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitIfElse(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifElse);
		try {
			int _alt;
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(T__28);
				setState(297);
				match(T__3);
				setState(298);
				((IfElseContext)_localctx).condition = condition(0);
				setState(299);
				match(T__4);
				setState(300);
				((IfElseContext)_localctx).instructionThen = instruction();
				setState(301);
				match(T__29);
				setState(302);
				((IfElseContext)_localctx).instructionElse = instruction();

				        String labelElse = newLabel();
				        String labelEnd = newLabel();
				        ((IfElseContext)_localctx).code =  ((IfElseContext)_localctx).condition.code;
				        _localctx.code += "JUMPF " + labelElse +"\n";
				        _localctx.code += ((IfElseContext)_localctx).instructionThen.code;
				        _localctx.code += "JUMP " + labelEnd +"\n";
				        _localctx.code += "LABEL " + labelElse +"\n";
				        _localctx.code += ((IfElseContext)_localctx).instructionElse.code;
				        _localctx.code += "LABEL " + labelEnd + "\n";
				 
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(305);
						match(T__28);
						setState(306);
						match(T__3);
						setState(307);
						((IfElseContext)_localctx).condition = condition(0);
						setState(308);
						match(T__4);
						setState(309);
						((IfElseContext)_localctx).instructionThen = instruction();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(313); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

				        String labelEnd = newLabel();
				        ((IfElseContext)_localctx).code =  ((IfElseContext)_localctx).condition.code;
				        _localctx.code += "JUMPF " + labelEnd + "\n";
				        _localctx.code += ((IfElseContext)_localctx).instructionThen.code; 
				        _localctx.code += "LABEL " + labelEnd + "\n";
				        
				    
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

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(320);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			           tablesSymboles.addParam((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			        
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(322);
				match(T__6);
				setState(323);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(324);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				               tablesSymboles.addParam((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				            
				}
				}
				setState(330);
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token TYPE;
		public DeclarationContext declaration;
		public InstructionContext instruction;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fonction);
		tablesSymboles.enterFunction();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(T__30);
			setState(332);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(333);
			match(T__3);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(334);
				params();
				}
			}

			setState(337);
			match(T__4);
			setState(338);
			match(T__31);
			setState(339);
			((FonctionContext)_localctx).TYPE = match(TYPE);

			            tablesSymboles.addFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			            ((FonctionContext)_localctx).code =  "LABEL " + (((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
			        
			setState(341);
			match(T__12);
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(342);
				match(NEWLINE);
				}
				break;
			}
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(345);
				((FonctionContext)_localctx).declaration = declaration();
				 _localctx.code += ((FonctionContext)_localctx).declaration.code; 
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(353);
					match(NEWLINE);
					}
					} 
				}
				setState(358);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__28) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE))) != 0)) {
				{
				{
				setState(359);
				((FonctionContext)_localctx).instruction = instruction();
				_localctx.code += ((FonctionContext)_localctx).instruction.code;
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			match(T__13);
			setState(371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(368);
					match(NEWLINE);
					}
					} 
				}
				setState(373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			_localctx.code += "RETURN\n";
			}
			_ctx.stop = _input.LT(-1);
			tablesSymboles.exitFunction();
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(376);
					_la = _input.LA(1);
					if ( !(_la==T__16 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(379); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 12:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0180\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\7\3@\n\3\f\3\16"+
		"\3C\13\3\3\3\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4c\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5t\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a6\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ae\n\t\f\t\16\t\u00b1\13\t\5\t\u00b3\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d1\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00dd\n\n\f\n\16\n\u00e0\13\n\3\13\3\13"+
		"\3\13\3\13\7\13\u00e6\n\13\f\13\16\13\u00e9\13\13\3\13\7\13\u00ec\n\13"+
		"\f\13\16\13\u00ef\13\13\3\13\3\13\7\13\u00f3\n\13\f\13\16\13\u00f6\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u011a\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u0126\n\16\f\16\16\16\u0129\13\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u013a\n\17"+
		"\r\17\16\17\u013b\3\17\3\17\5\17\u0140\n\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\7\20\u0149\n\20\f\20\16\20\u014c\13\20\3\21\3\21\3\21\3\21\5"+
		"\21\u0152\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u015a\n\21\3\21\3\21"+
		"\3\21\7\21\u015f\n\21\f\21\16\21\u0162\13\21\3\21\7\21\u0165\n\21\f\21"+
		"\16\21\u0168\13\21\3\21\3\21\3\21\7\21\u016d\n\21\f\21\16\21\u0170\13"+
		"\21\3\21\3\21\7\21\u0174\n\21\f\21\16\21\u0177\13\21\3\21\3\21\3\22\6"+
		"\22\u017c\n\22\r\22\16\22\u017d\3\22\2\4\22\32\23\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"\2\6\3\2\13\r\4\2\n\n\16\16\3\2\26\34\4\2\23\23&"+
		"&\2\u019d\2$\3\2\2\2\4,\3\2\2\2\6b\3\2\2\2\bs\3\2\2\2\nu\3\2\2\2\f{\3"+
		"\2\2\2\16\u00a5\3\2\2\2\20\u00b2\3\2\2\2\22\u00d0\3\2\2\2\24\u00e1\3\2"+
		"\2\2\26\u00f7\3\2\2\2\30\u00fe\3\2\2\2\32\u0119\3\2\2\2\34\u013f\3\2\2"+
		"\2\36\u0141\3\2\2\2 \u014d\3\2\2\2\"\u017b\3\2\2\2$%\5\4\3\2%&\7\2\2\3"+
		"&\3\3\2\2\2\'(\5\6\4\2()\b\3\1\2)+\3\2\2\2*\'\3\2\2\2+.\3\2\2\2,*\3\2"+
		"\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\63\b\3\1\2\60\62\7&\2\2\61\60\3\2"+
		"\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64;\3\2\2\2\65\63\3\2\2"+
		"\2\66\67\5 \21\2\678\b\3\1\28:\3\2\2\29\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2"+
		";<\3\2\2\2<A\3\2\2\2=;\3\2\2\2>@\7&\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2"+
		"AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DJ\b\3\1\2EF\5\16\b\2FG\b\3\1\2GI\3\2\2"+
		"\2HE\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\b\3\1"+
		"\2N\5\3\2\2\2OP\7$\2\2PQ\7%\2\2QR\5\"\22\2RS\b\4\1\2Sc\3\2\2\2TU\7$\2"+
		"\2UV\7%\2\2VW\7\3\2\2WX\5\22\n\2XY\5\"\22\2YZ\b\4\1\2Zc\3\2\2\2[\\\7$"+
		"\2\2\\]\7%\2\2]^\7\3\2\2^_\5\32\16\2_`\5\"\22\2`a\b\4\1\2ac\3\2\2\2bO"+
		"\3\2\2\2bT\3\2\2\2b[\3\2\2\2c\7\3\2\2\2de\7%\2\2ef\7\3\2\2fg\5\22\n\2"+
		"gh\b\5\1\2ht\3\2\2\2ij\7%\2\2jk\7\4\2\2kl\5\22\n\2lm\b\5\1\2mt\3\2\2\2"+
		"no\7%\2\2op\7\3\2\2pq\5\32\16\2qr\b\5\1\2rt\3\2\2\2sd\3\2\2\2si\3\2\2"+
		"\2sn\3\2\2\2t\t\3\2\2\2uv\7\5\2\2vw\7\6\2\2wx\7%\2\2xy\7\7\2\2yz\b\6\1"+
		"\2z\13\3\2\2\2{|\7\b\2\2|}\7\6\2\2}~\5\22\n\2~\177\7\7\2\2\177\u0080\b"+
		"\7\1\2\u0080\r\3\2\2\2\u0081\u0082\5\22\n\2\u0082\u0083\5\"\22\2\u0083"+
		"\u0084\b\b\1\2\u0084\u00a6\3\2\2\2\u0085\u0086\5\f\7\2\u0086\u0087\5\""+
		"\22\2\u0087\u0088\b\b\1\2\u0088\u00a6\3\2\2\2\u0089\u008a\5\b\5\2\u008a"+
		"\u008b\5\"\22\2\u008b\u008c\b\b\1\2\u008c\u00a6\3\2\2\2\u008d\u008e\7"+
		"#\2\2\u008e\u008f\5\22\n\2\u008f\u0090\5\"\22\2\u0090\u0091\b\b\1\2\u0091"+
		"\u00a6\3\2\2\2\u0092\u0093\5\n\6\2\u0093\u0094\5\"\22\2\u0094\u0095\b"+
		"\b\1\2\u0095\u00a6\3\2\2\2\u0096\u0097\5\24\13\2\u0097\u0098\b\b\1\2\u0098"+
		"\u00a6\3\2\2\2\u0099\u009a\5\26\f\2\u009a\u009b\b\b\1\2\u009b\u00a6\3"+
		"\2\2\2\u009c\u009d\5\30\r\2\u009d\u009e\b\b\1\2\u009e\u00a6\3\2\2\2\u009f"+
		"\u00a0\5\34\17\2\u00a0\u00a1\b\b\1\2\u00a1\u00a6\3\2\2\2\u00a2\u00a3\5"+
		"\"\22\2\u00a3\u00a4\b\b\1\2\u00a4\u00a6\3\2\2\2\u00a5\u0081\3\2\2\2\u00a5"+
		"\u0085\3\2\2\2\u00a5\u0089\3\2\2\2\u00a5\u008d\3\2\2\2\u00a5\u0092\3\2"+
		"\2\2\u00a5\u0096\3\2\2\2\u00a5\u0099\3\2\2\2\u00a5\u009c\3\2\2\2\u00a5"+
		"\u009f\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a6\17\3\2\2\2\u00a7\u00a8\5\22\n"+
		"\2\u00a8\u00af\b\t\1\2\u00a9\u00aa\7\t\2\2\u00aa\u00ab\5\22\n\2\u00ab"+
		"\u00ac\b\t\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00a7\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\21\3\2\2"+
		"\2\u00b4\u00b5\b\n\1\2\u00b5\u00b6\7\n\2\2\u00b6\u00b7\5\22\n\13\u00b7"+
		"\u00b8\b\n\1\2\u00b8\u00d1\3\2\2\2\u00b9\u00ba\7\6\2\2\u00ba\u00bb\5\22"+
		"\n\2\u00bb\u00bc\7\7\2\2\u00bc\u00bd\b\n\1\2\u00bd\u00d1\3\2\2\2\u00be"+
		"\u00bf\7(\2\2\u00bf\u00d1\b\n\1\2\u00c0\u00c1\7)\2\2\u00c1\u00d1\b\n\1"+
		"\2\u00c2\u00c3\7\6\2\2\u00c3\u00c4\7$\2\2\u00c4\u00c5\7\7\2\2\u00c5\u00c6"+
		"\5\22\n\5\u00c6\u00c7\b\n\1\2\u00c7\u00d1\3\2\2\2\u00c8\u00c9\7%\2\2\u00c9"+
		"\u00d1\b\n\1\2\u00ca\u00cb\7%\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\5\20"+
		"\t\2\u00cd\u00ce\7\7\2\2\u00ce\u00cf\b\n\1\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00b4\3\2\2\2\u00d0\u00b9\3\2\2\2\u00d0\u00be\3\2\2\2\u00d0\u00c0\3\2"+
		"\2\2\u00d0\u00c2\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d1"+
		"\u00de\3\2\2\2\u00d2\u00d3\f\t\2\2\u00d3\u00d4\t\2\2\2\u00d4\u00d5\5\22"+
		"\n\n\u00d5\u00d6\b\n\1\2\u00d6\u00dd\3\2\2\2\u00d7\u00d8\f\b\2\2\u00d8"+
		"\u00d9\t\3\2\2\u00d9\u00da\5\22\n\t\u00da\u00db\b\n\1\2\u00db\u00dd\3"+
		"\2\2\2\u00dc\u00d2\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\23\3\2\2\2\u00e0\u00de\3\2\2"+
		"\2\u00e1\u00e7\7\17\2\2\u00e2\u00e3\5\16\b\2\u00e3\u00e4\b\13\1\2\u00e4"+
		"\u00e6\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ed\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
		"\u00ec\7&\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0"+
		"\u00f4\7\20\2\2\u00f1\u00f3\7&\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\25\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f7\u00f8\7\21\2\2\u00f8\u00f9\7\6\2\2\u00f9\u00fa\5\32\16"+
		"\2\u00fa\u00fb\7\7\2\2\u00fb\u00fc\5\16\b\2\u00fc\u00fd\b\f\1\2\u00fd"+
		"\27\3\2\2\2\u00fe\u00ff\7\22\2\2\u00ff\u0100\7\6\2\2\u0100\u0101\5\b\5"+
		"\2\u0101\u0102\7\23\2\2\u0102\u0103\5\32\16\2\u0103\u0104\7\23\2\2\u0104"+
		"\u0105\5\b\5\2\u0105\u0106\7\7\2\2\u0106\u0107\5\16\b\2\u0107\u0108\b"+
		"\r\1\2\u0108\31\3\2\2\2\u0109\u010a\b\16\1\2\u010a\u010b\7\24\2\2\u010b"+
		"\u011a\b\16\1\2\u010c\u010d\7\25\2\2\u010d\u011a\b\16\1\2\u010e\u010f"+
		"\7%\2\2\u010f\u011a\b\16\1\2\u0110\u0111\5\22\n\2\u0111\u0112\t\4\2\2"+
		"\u0112\u0113\5\22\n\2\u0113\u0114\b\16\1\2\u0114\u011a\3\2\2\2\u0115\u0116"+
		"\7\35\2\2\u0116\u0117\5\32\16\5\u0117\u0118\b\16\1\2\u0118\u011a\3\2\2"+
		"\2\u0119\u0109\3\2\2\2\u0119\u010c\3\2\2\2\u0119\u010e\3\2\2\2\u0119\u0110"+
		"\3\2\2\2\u0119\u0115\3\2\2\2\u011a\u0127\3\2\2\2\u011b\u011c\f\4\2\2\u011c"+
		"\u011d\7\34\2\2\u011d\u011e\5\32\16\5\u011e\u011f\b\16\1\2\u011f\u0126"+
		"\3\2\2\2\u0120\u0121\f\3\2\2\u0121\u0122\7\36\2\2\u0122\u0123\5\32\16"+
		"\4\u0123\u0124\b\16\1\2\u0124\u0126\3\2\2\2\u0125\u011b\3\2\2\2\u0125"+
		"\u0120\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\33\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7\37\2\2\u012b\u012c"+
		"\7\6\2\2\u012c\u012d\5\32\16\2\u012d\u012e\7\7\2\2\u012e\u012f\5\16\b"+
		"\2\u012f\u0130\7 \2\2\u0130\u0131\5\16\b\2\u0131\u0132\b\17\1\2\u0132"+
		"\u0140\3\2\2\2\u0133\u0134\7\37\2\2\u0134\u0135\7\6\2\2\u0135\u0136\5"+
		"\32\16\2\u0136\u0137\7\7\2\2\u0137\u0138\5\16\b\2\u0138\u013a\3\2\2\2"+
		"\u0139\u0133\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\b\17\1\2\u013e\u0140\3\2\2\2"+
		"\u013f\u012a\3\2\2\2\u013f\u0139\3\2\2\2\u0140\35\3\2\2\2\u0141\u0142"+
		"\7$\2\2\u0142\u0143\7%\2\2\u0143\u014a\b\20\1\2\u0144\u0145\7\t\2\2\u0145"+
		"\u0146\7$\2\2\u0146\u0147\7%\2\2\u0147\u0149\b\20\1\2\u0148\u0144\3\2"+
		"\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\37\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7!\2\2\u014e\u014f\7%\2\2"+
		"\u014f\u0151\7\6\2\2\u0150\u0152\5\36\20\2\u0151\u0150\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7\7\2\2\u0154\u0155\7\"\2\2\u0155"+
		"\u0156\7$\2\2\u0156\u0157\b\21\1\2\u0157\u0159\7\17\2\2\u0158\u015a\7"+
		"&\2\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0160\3\2\2\2\u015b"+
		"\u015c\5\6\4\2\u015c\u015d\b\21\1\2\u015d\u015f\3\2\2\2\u015e\u015b\3"+
		"\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0166\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0165\7&\2\2\u0164\u0163\3\2"+
		"\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u016e\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\5\16\b\2\u016a\u016b\b"+
		"\21\1\2\u016b\u016d\3\2\2\2\u016c\u0169\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0171\u0175\7\20\2\2\u0172\u0174\7&\2\2\u0173\u0172\3\2\2\2\u0174"+
		"\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0178\u0179\b\21\1\2\u0179!\3\2\2\2\u017a\u017c"+
		"\t\5\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d"+
		"\u017e\3\2\2\2\u017e#\3\2\2\2\37,\63;AJbs\u00a5\u00af\u00b2\u00d0\u00dc"+
		"\u00de\u00e7\u00ed\u00f4\u0119\u0125\u0127\u013b\u013f\u014a\u0151\u0159"+
		"\u0160\u0166\u016e\u0175\u017d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}