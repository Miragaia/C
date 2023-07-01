-- line comment
-- minimum characteristics!

type table ATable {
   name: text -> "Name:"; -- the final [optional] part indicates the textual view of the column (that is, what must be printed as the header of the table)
   number: integer;
};

tA: ATable;
tA := new; -- new empty table
tA -> "Table:"; -- assigns header to table referenced by tA
tA.number -> "Number:"; -- assigns header to column number to table referenced by tA
cA: integer;
cA := 1;

["One", cA] >> tA; -- add line at the end of the table
cA := cA+1;
["Two", cA] >> tA;
cA := cA+1;
["Three", cA] >> tA;

println tA; -- prints table with column alignment (adapted to maximum length of each column)
 
 
 -- minimum characteristics!

type table BTable -> "The Table!" {
   name: text -> "Name:";
   number: integer -> "Number:";
};

tB: BTable;
tB := new; -- new empty table
cB: integer;
cB := 12;

["One", cB] >> tB; -- add line at the end of the table
[] >> tB; -- add empty (undefined) line at the end of the table
cB := cB+1;
["Two", cB] >> tB;
[] >> tB; -- add empty (undefined) line at the end of the table
cB := cB+1;
["Three", cB] >> tB;
[] >> tA; -- add empty (undefined) line at the end of the table

println tB;

ttB: BTable;
ttB -> "Table of names (view)";
ttB := tB.name; -- ttB contains a view of table referenced by tB consisting only of column name
tttB: BTable;
tttB := new(tB.name); -- creates a new table copying only the column name of table referenced by tB
tttB -> "Table of names (copy)";

["Four", cB+1] >> tB;

println ttB; -- print column name of table (line Four must also appear!)
println tttB; -- print table referenced by ttt (line Four does not exist!)

println "Yet another print of a table" center (length tB.name + 1 + length tB.number + 3); -- centers string in table (assuming on extra character before, between, and after each column) 
for elem in tB do -- iterate table lines
   elem.name := elem.name + ":";
   println "|",elem.name, "|", elem.number, "|";
end;

-- three alternative reads of the same table: 
t2B: ATable;
t2B := read "testFiles/list1.csv";
println t2B;
t2B := read "testFiles/list2.csv" using column 2 as name, column 1 as number;
println t2B;
t2B := read "testFiles/list1.csv" using "name" as name, "number" as number;
println t2B;

-- minimum characteristics!

type table Table {
   n1: real;
   n2: real;
   average: real := (n1+n2)/2; -- defined as a formula!
};

tC: Table;
tC := new; -- new empty table

[real(read in "n1:"), real(read in "n2:")] >> tC; -- read in: read text from standard input 
[real(read in "n1:"), real(read in "n2:")] >> tC;
print "n1 and ";
println " n2: ";
[real(read in), real(read in)] >> tC;

println tC;

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
