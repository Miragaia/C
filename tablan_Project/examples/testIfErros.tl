-- line comment
-- minimum characteristics!

c: integer;
c := 16;

println c;
println "";


if c = 16 
do
	println "A variavel c, com valor: ", c, " é igual a 16, wow!"; 
else 
	println "A variavel c não tem valor 16, mas sim ", c, " infelizmente";
end;

println "";

if c = 10
do
        println "A variavel c, com valor: ", c, " é igual a 10, wow!";
else
        println "A variavel c não tem valor 10, mas sim ", c, " infelizmente";
end;

println "";

t2: ATable;
t2 := read "inexistentfile.cpp";

if error 
do 
	println "Erro detetato!"; 
	printerror;
else 
	println "Aqui está a tabela final!";
	println t2; 
end;

println "";

t2 := read "testFiles/list1.csv";

if error
do
        println "Erro detetato!";
        printerror;
else
	println "Aqui está a tabela final!";
        println t2;
end;
