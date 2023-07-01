grammar Fractions;

program:
	stat* EOF
	;

stat:
	  expr? ';'
	| assignment? ';'
	;

assignment:
        ID '=' expr
        ;

expr:
	
          '-' expr                      #ExprUnNeg
        | '+' expr                      #ExprUnPos
        | '(' expr ')' '^' expr	        #ExprPower
	| expr op=('*'|':') expr	#ExprMultDivMod
	| expr op=('+'|'-') expr	#ExprAddSub
	| Literal 			#ExprLiteral
	| Integer 			#ExprInteger
	| ID				#ExprId
	| '(' expr ')'			#ExprParent
        | 'reduce' expr                 #ExprReduce
	| 'print' expr			#ExprPrint
	| 'copy' expr			#ExprCopy
	| 'paste'			#ExprPaste
	| NEWLINE			#ExprNewline
	;

Literal: Integer '/' Integer;
ID: [a-zA-Z]+;
Integer: [0-9]+;	//  Implement with integers
COMMENT: '//' .*? '\n' -> skip;
WS:	[ \t\n\r]+ -> skip;
NEWLINE: '\r'? '\n';
