grammar Ktlyns;

@parser::header { 
	using Kat; 
	using System.Collections.Generic;
	}

program:
	statements;

block
	locals[KBlock Block]:
	LBRC statements RBRC	# RBlockStmts
	| LBRC RBRC				# RBlockEmpty;

statements
	locals[KBlock Block]:
	statement+;

statement
	locals[KStmt Stmt]:
	expr SDOT			# RStatement
	| var_decl SDOT		# RStatementVarDecl
	| mth_var_decl SDOT	# RStatementMthVarDecl
	| arr_decl SDOT		# RStatementArrDecl
	| if_else_decl		# RStatementIfElse
	| loop_decl			# RStatementLoop
	| BREAK SDOT		# RStatementBreak
	| mth_decl			# RStatementMthDecl
	| class_decl        # RStatementClassDecl
	| ex_mth_decl SDOT	# RStatementExMthDecl;
	
class_decl 
    locals[KClassDecl Class]: 
    CLASS id  block  #RClassDecl;

if_else_decl
	locals[KStmt Stmt]:
	IF LPRN expr RPRN (
		block
		| statement
	) (
		ELSE (
			block
			| statement
		)
	)? # RIfElse;

loop_decl
	locals[KStmt Stmt]:
	AT LPRN expr RPRN block					# RLoopOne
	| AT LPRN expr COMMA expr RPRN block	# RLoopTwo;

var_decl
	locals[KStmt Stmt]:
	id id			# RVarDecl //Even if we cannot have null declarations, this is needed for method args
	| id id EQ expr	# RVarDeclExpr;

mth_var_decl
	locals[KStmt Stmt]:
	LPRN id* RPRN COLON id id EQ expr # RMthVarDecl;

arr_decl
	locals[KStmt Stmt]:
	id id EQ '[' INT ']' LPRN expr? RPRN # RArrDeclExpr;

mth_decl
	locals[KStmt Stmt]:
	METHOD id LPRN mth_decl_arg RPRN COLON id? block;

ex_mth_decl
	locals[KStmt Stmt]:
	EXTERNAL METHOD id LPRN mth_decl_arg RPRN COLON id;

expr
	locals[KExpr Expr]:
	string						# RExprString
	| id						# RExprId
	| id LPRN call_args RPRN	# RExprCall
	| LPRN expr RPRN			# RExprGroup
	| expr DOT id               # RExprAccess
	| unary						# RExprUnary
	| expr CAST id				# RExprCast
	//Number operators
	| expr STAR expr	# RExprBinMult
	| expr SLASH expr	# RExprBinDiv
	| expr PLUS expr	# RExprBinAdd
	| expr MINUS expr	# RExprBinSub
	//Logical operators
	| expr EQEQ expr	# RExprBinEq
	| expr NEQEQ expr	# RExprBinNEq
	| expr GREAT expr	# RExprBinGreat
	| expr EQGREAT expr	# RExprBinEGreat
	| expr LESS expr	# RExprBinLess
	| expr EQLESS expr	# RExprBinELess
	| expr AND expr		# RExprBinAnd
	| expr OR expr		# RExprBinOr
	//-----------------
	| expr EQ expr	# RExprAssign
	| RET expr?		# RExprReturn;

unary
	locals[KExpr Expr]:
	factor			# RUnaryFactor
	| MINUS factor	# RUnaryMinus
	| NOT factor	# RUnaryNot;

factor
	locals[KExpr Expr]:
	INT		# RFactorInt
	| DEC	# RFactorDec
	| TRUE	# RFactorTrue
	| FALSE	# RFactorFalse;

string
	locals[KExpr Expr]:
	STR # KString;

id
	locals[KId Id]:
	ID					# RIDSimple
	| id LBKT expr RBKT	# RIDArray
	| (AMP)+ id			# RIDAddress
	| (STAR)+ id		# RIDPointer;

call_args
	locals[List<KExpr> Exprs]:
							# RCallArgs
	| expr					# RCallArgsExpr
	| call_args COMMA expr	# RCallArgsAdd;

mth_decl_arg
	locals[List<KVarDecl> Decls]:
											# RMthDeclArg
	| var_decl								# RMthDeclArgVar
	| mth_decl_arg COMMA VARADIC? var_decl	# RMthDeclArgAdd;

WS:
	[ \n\t\r]+ -> skip;
DEC:
	[0-9]+ '.' [0-9]+;
INT:
	[0-9]+;

TRUE:
	'true';
FALSE:
	'false';

PLUS:
	'+';
MINUS:
	'-';
SLASH:
	'/';
STAR:
	'*';
AMP:
	'&';

STR:
	'"' .*? '"';

LPRN:
	'(';
RPRN:
	')';
LBRC:
	'{';
RBRC:
	'}';
LBKT:
	'[';
RBKT:
	']';

COMMA:
	',';
DOT:
	'.';
SDOT:
	';';
EQ:
	'=';
COLON:
	':';
VARADIC:
	'...';

IF:
	'if';
ELSE:
	'else';
AT:
	'@';
RET:
	'ret';
BREAK:
	'break';

AND:
	'&&';
OR:
	'||';
NOT:
	'!';
EQEQ:
	'==';
NEQEQ:
	'!=';
GREAT:
	'>';
EQGREAT:
	'>=';
LESS:
	'<';
EQLESS:
	'<=';
CAST:
	'to';
	
CLASS: 'class';

METHOD:
	'mth';

EXTERNAL:
	'ext';

ID:
	[a-zA-Z][a-zA-Z0-9_-]* (
		'[]'
		| '*'
	)*;

COMMENT:
	'/*' .*? '*/' -> skip;

LINE_COMMENT:
	'//' ~[\r\n]* -> skip;