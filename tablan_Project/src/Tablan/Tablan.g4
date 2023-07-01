grammar Tablan;

@header {
package Tablan;
import java.util.Map;
import java.util.HashMap;
import Utils.*;
}

program:
	stat* EOF;
	

stat:
	  declaration? ';' 	//  Variable Declarations
	| print ';'  		//  Print Statements
	| exprData ';' 	//  Data manipulation expressions
	| tableOp ';'  	//  Table operations
	| assignment ';'  	//  Variable Assignments
	| defineTable ';'  //  Table Declarations
	| forLoop ';'		//  For Loop Declarations
	| conditional ';'	//  For If Declarations
	| defineReal ';'	//  Real Declarations
	;

declaration: idList ':' typeName=type;

assignment: 
	  tableName=ID '.' rowName=ID ':=' oldTableName=ID '.' oldRowName=ID	#AssignColRowValue
	| tableName=ID ':=' oldTableName=ID '.' oldRowName=ID	#AssignTableRowValue
	| tableName=ID '.' rowName=ID ':=' exprData	#AssignNormalValue
	| varName=ID ':=' exprData	#AssignValue
	| varName=ID ':= new' ('(' tableName=ID ('.' rowName=ID)?  ')')? #AssignNewRow
	| varName=ID ':= read' fileName=TEXT ('using' ('column' colNumI=INTEGER 'as' colNameI=ID) (', column' colNum+=INTEGER 'as' colName+=ID)*)?	#AssignReadRow
	| varName=ID ':= read' fileName=TEXT ('using' (fileColNameI=TEXT 'as' colNameI=ID) (',' fileColName+=TEXT 'as' colName+=ID)*)?	#AssignReadFile
	| varName=ID ':=' tableName=ID 'when' exprData 		#AssignTableWhen
	;

conditional: 'if' exprData 'do' (trueSL+=stat)+ ('else' (falseSL+=stat)+)? 'end';

idList:
	ID (',' ID)*;

type returns[Type res]:
	  'integer' {$res = new IntegerType();}
	| 'real'    {$res = new RealType();}
	| 'text' {$res = new TextType();}
    | 'boolean' {$res = new BooleanType();}
	| ID {$res = new TableType();}
	;

exprData returns[String eType, String boolName]:
	  '-' e=exprData                #ExprUnNeg
	| '+' e=exprData                #ExprUnPos
	| e1=exprData op=('*'|'/') e2=exprData  #ExprMultDiv
	| e1=exprData op=('+'|'-') e2=exprData  #ExprAddSub
    | e1=exprData op=('=' | '/=') e2=exprData  #ExprComparison
    | e1=exprData op=('>' | '<') e2=exprData  #ExprCompHighLow
    | e1=exprData op=('>=' | '<=') e2=exprData  #ExprCompHighLowEquals
	| '(' e=exprData+ ')'            #ExprParent
	| 'integer(' e=exprData ')'	#ExprToInt
	| 'real(' e=exprData ')'   	#ExprToReal
	| 'text(' e=exprData ')'    	#ExprToText
	| INTEGER    {$eType = "IntegerType";} #ExprInteger
	| REAL		 {$eType = "RealType";} #ExprReal
	| BOOLEAN		 {$eType = "BooleanType";} #ExprBoolean
	| ERRO		 		#ExprError
	| table				#ExprTable        
	| tableName=ID '.' rowName=ID	#ExprTableRow
	| 'length' tableName=ID '.' rowName=ID   #ExprTableRowLength
	| TEXT		 {$eType = "TextType";} #ExprText
	| ID                            #ExprID
	| 'read in' (rowName=TEXT)?	{$eType += "Scanner";} #ExprReadStdIn
	| e= exprData ('\\' '\\' '2 = 0') 	#ExprEven
	| '?' e=exprData ':' e2=exprData	#ExprIfElse
	| 'read' fileName=TEXT fileOp*		#ExprReadFile
	;

table returns[Type eType, String tableName]:
	  rowName=ID ':' rowType=type ('(' colNome=ID ')')? ('->' rowHeader=TEXT)?
	| tableNome=ID '->' rowHeader=TEXT
	;

tableOp:
	  '[' exprData? (',' exprData)* '] >> ' tableName=ID	#TableOpAddLine
	| rowName=ID '.' rowType=type '->' rowHeader=TEXT	#TableOpNewRenameCol
	| rowName=ID '.' rowType=type				#TableOpNewCol
	| 'remove' tableName=ID 'when'	e=exprData	#TableOpRemoveRow
	;

print:
	  'printerror'	#PrintError
	| 'print' valsI=exprData (',' vals+=exprData)* ('center (' size=exprData ')')?	#PrintExpr
	| 'println' valsI=exprData (',' vals+=exprData)* ('center (' size=exprData ')')?	#PrintLnExpr
	;

defineTable:
	'type table' tableName=ID ('(' (extendAbrv=ID ':' extendNome=ID) (',' extendAbrv=ID ':' extendNome=ID)* ')')? ('->' tableHeader=TEXT)? '{' (defineColumn)* '}'	#defineTableMain;

defineColumn:
	(unique)? columnName=ID ':' colType=type ('.' type)? (':=' exprData)? ('->' colHeader=TEXT)? ';';

forLoop:
	'for' elemName=ID 'in' tableName=ID 'do' (stat)+ 'end';

unique:
	'unique';

defineReal:
	'type real' realName=ID '{' ('invariant')? ('value >=' INTEGER)? ('and')? ('value <=' INTEGER)? ','? TEXT? ';' '}'	#defineRealMain;

fileOp:
	'using' used=ID usedItem=TEXT (',' fileOp)?	#FileOpUsing
	| usedItem=TEXT 'as' used=ID ('.' usedsub=ID)* ('>>' usedbig=ID)? (',' fileOp)?	#FileOpAs
	;

ERRO: 'error';
BOOLEAN: 'true' | 'false';
ID: [a-zA-Z_][a-zA-Z_0-9]*;
TEXT: '"' .*? '"';
REAL: [0-9]+ '.' [0-9]*;
INTEGER: [0-9]+;
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '--' .*? '\n' -> skip;
ERROR: .;
