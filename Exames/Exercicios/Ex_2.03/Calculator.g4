grammar Calculator ; 

program : stat* EOF ;

stat: expr NEWLINE
    | NEWLINE ;
expr: expr ( '*' | '/' ) expr    //alternativa mais prioritária
    | expr ( '+' | '-' ) expr 
    | INT
    | '(' expr ')'              // a alternativa menos prioritária
    ;

INT : [0-9]+ ;              
NEWLINE : '\r'? '\n' ;          // o '\r' é opcional
WS: [ \t]+ -> skip ;