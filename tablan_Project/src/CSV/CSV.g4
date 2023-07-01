grammar CSV;

@header {
package CSV;
import Utils.*;
}

program:
    header row+ EOF;

header:
    row;

row:
    (data)+ (NEWLINE)?;

data:
      field             #DataInitial
    | PONTUATION field  #DataValue
    | PONTUATION field?  #DataNull
    ;

field:
      TEXT              #FieldText
    | NUMBER            #FieldInt
    | REAL              #FieldReal
    ;

NEWLINE: '\r'? '\n';
TEXT: [a-zA-Z]([a-zA-Z0-9_@\- ])*;
NUMBER: [0-9]+;
REAL: [0-9]+ '.' [0-9]+;
PONTUATION: [.,:!?)('] | ';;';          
WS: [ \t]+ -> skip;
