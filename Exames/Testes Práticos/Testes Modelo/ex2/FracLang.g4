grammar FracLang;

program: (stat? ';')* EOF;

stat: display | assignment;

display: 'display' expr;

assignment: ID '<=' expr;

expr:
	op = ('+' | '-') expr			# ExprUnary
	| expr op = ('*' | ':') expr	# ExprMultDiv
	| expr op = ('+' | '-') expr	# ExprAddSub
	| '(' expr ')'					# ExprParenteses
	| 'reduce' expr					# ExprReduce
	| 'read' STRING					# ExprString
	| Fraction						# ExprFraction
	| ID							# ExprID;

ID: [a-z]+;
Fraction: [0-9]+ ('/' [0-9]+)?;
STRING: '"' .*? '"';
COMMENT: '--'+ .*? '\n' -> skip;
WS: [ \t\r\n]+ -> skip;
Error: .;