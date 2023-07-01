grammar Numbers ;
file : line* EOF ; // o nosso ficheiro é composto por zero ou mais linhas
line : NUM '-' WORD NL ; // cada linha tem a forma NUM - WORD e termina com uma mudança
// de linha
NUM : [0-9]+ ; // cada NUM é composto por 1 ou mais algarismos
WORD : [A-Za-z]+ ; // cada WORD é composta por 1 ou mais letras
NL : '\r'? '\n' ;
WS : [ \t]+ -> skip ;