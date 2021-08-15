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
	expr SDOT		# RStatement
	| var_decl SDOT	# RStatementVarDecl
	| mth_decl		# RStatementMthDecl;

var_decl
	locals[KStmt Stmt]:
	id id			# RVarDecl
	| id id EQ expr	# RVarDeclExpr;

mth_decl
	locals[KStmt Stmt]:
	mth id LPRN mth_decl_arg RPRN block;

mth
	locals[KId Id]:
	METHOD					# RMthVoid
	| METHOD LARR id RARR	# RMthType;

expr
	locals[KExpr Expr]:
	// number						# RExprNumber
	string						# RExprString
	| id						# RExprId
	| id EQ expr				# RExprAssign
	| id LPRN call_args RPRN	# RExprCall
	| LPRN expr RPRN			# RExprGroup
	| unary						# RExprUnary
	| expr STAR expr			# RExprBinMult
	| expr SLASH expr			# RExprBinDiv
	| expr PLUS expr			# RExprBinAdd
	| expr MINUS expr			# RExprBinSub
	| RET expr?					# RExprReturn;

unary
	locals[KExpr Expr]:
	number
	| MINUS number;

number
	locals[KExpr Expr]:
	INT		# RNumberInt
	| DEC	# RNumberDec;

string
	locals[KStr Str]:
	STR;

id
	locals[KId Id]:
	ID;

call_args
	locals[List<KExpr> Exprs]:
							# RCallArgs
	| expr					# RCallArgsExpr
	| call_args COMMA expr	# RCallArgsAdd;

mth_decl_arg
	locals[List<KVarDecl> Decls]:
									# RMthDeclArg
	| var_decl						# RMthDeclArgVar
	| mth_decl_arg COMMA var_decl	# RMthDeclArgAdd;

// op locals[ExprType TypeExpr]: | SLASH { $TypeExpr = ExprType.Div;} | STAR { $TypeExpr = ExprType.Mult;} | PLUS { $TypeExpr = ExprType.Add;} | MINUS { $TypeExpr = ExprType.Sub;} | AND | OR | NOT | EQEQ | NEQEQ | GREAT | LESS | EQGREAT | EQLESS;

WS:
	[ \n\t\r]+ -> skip;
DEC:
	[0-9]+ '.' [0-9]+;
INT:
	[0-9]+;

PLUS:
	'+';
MINUS:
	'-';
SLASH:
	'/';
STAR:
	'*';

STR:
	'"' [^"]* '"';

LPRN:
	'(';
RPRN:
	')';
LBRC:
	'{';
RBRC:
	'}';
LARR:
	'<';
RARR:
	'>';

COMMA:
	',';
DOT:
	'.';
SDOT:
	';';
EQ:
	'=';

IF:
	'if';
ELSE:
	'else';
AT:
	'@';
RET:
	'ret';

AND:
	'and';
OR:
	'or';
NOT:
	'not';
EQEQ:
	'equals';
NEQEQ:
	'not equals';
GREAT:
	'great';
EQGREAT:
	'eq great';
LESS:
	'less';
EQLESS:
	'eq less';

METHOD:
	'method';

ID:
	[a-zA-Z][a-zA-Z0-9]*;
