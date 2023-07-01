grammar Hello ; // o nome da gramatica e Hello

top : ( greetings | bye )* EOF ;

greetings : 'hello' names { System.out.println("Olá " + $names.list); } ;
bye : 'bye' names { System.out.println("Adeus " + $names.list); } ;
names returns[String list=""] : ( ID { $list = $list + ($list.isEmpty() ? "" : ",") + $ID.text; } )+;

ID : [A-Za-z][A-Za-z0-9_]* ;  // um ID composto
WS : [ \t\r\n]+ -> skip ; // espacos, tabs, e mudancas de linha sao descartados