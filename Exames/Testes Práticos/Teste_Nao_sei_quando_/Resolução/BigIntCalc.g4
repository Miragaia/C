grammar BigIntCalc;

program: (stat? ';')*;

stat: show | assign;

show: 'show' expr;

assign: expr '->' ID;

expr:
	op = ('+' | '-') expr			# ExprUnary
	| expr op = ('+' | '-') expr	# ExprAddSub
	| expr op = ('*' | 'div') expr	# ExprMultDiv
	| expr 'mod' expr				# ExprMod
	| NUMBER						# ExprNumber
	| ID							# ExprID;

NUMBER: [0-9]+;
ID: [a-z][a-zA-Z0-9]*;
COMMENT: '#' .*? '\n' -> skip;
WS: [ \t\r\n] -> skip;
ERROR: .;
