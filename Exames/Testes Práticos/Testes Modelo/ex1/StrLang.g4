grammar StrLang;

program: statement* EOF;

statement:
	print			# printStatement
	| assignment	# assignmentStatement;

print: 'print ' expression;

assignment: e1 = expression ':' e2 = expression;

expression:
	'(' expression ')'							# Exprparenteses
	| 'input' expression						# ExprInput
	| expression '+' expression					# ExprAdd
	| expression '-' expression					# ExprSub
	| 'trim' expression							# ExprTrim
	| expression '/' expression '/' expression	# ExprReplace
	| String									# ExprString
	| ID										# ExprID;

String: '"' .*? '"';

ID: [a-zA-Z0-9_]+;

WS: [ \t\r\n]+ -> skip;

Comment: '//' .*? '\n' -> skip;