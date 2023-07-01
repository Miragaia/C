type table ATable {
   name: text -> "Name:"; -- the final [optional] part indicates the textual view of the column (that is, what must be printed as the header of the table)
   salary: real;
   workHours: integer;
   discounts: real;
   payPerHour: real := (salary - discounts) / workHours; -- defined as a formula!
   TotalPay: real := salary * workHours - discounts;
};


-- Tables! (with formulas)
ta: ATable;
ta := new; -- new empty table
println "Defined empty table: ", ta;


-- Other Variables! (Integer, Real and Text)
i: integer;
i := 16;

print "Vars: int > ", i;

r: real;
r := 123.704;

print " | real > ", r;

b: boolean;
b := true;

print " | boolean > ", b;

t: text;
t := "Uma boa frase";

println " | text > ", t;

println "";


-- Arithmetic instructions with chaining instructions (and text concatenation)
result: real;
result := r * i;
println r, " * ", i, " é ", result;

temp: real;
temp := result;
result := result + (r + i) / 3;
println temp, " + (", r, " + ", i, ") / 3 = ", result;

finalText: text;
finalText := t + " para se poder ler";
println "O texto '", t, "' + ' para se poder ler' é '", finalText, "'\n";


-- Read from standard in and convert values
println "Write some text in the console: ";
inpTXT: text;
inpTXT := text(read in);

println "\nNow write a number (can have decimal spaces): ";
inpREAL: real;
inpREAL := real(read in);

println "\nYou wrote '", inpTXT, "' and gave the number ", inpREAL; 


-- Add a row to the bottom of column
println "\nIf we add some rows to the previous table we get: ";
i := 30;
["Josefino", 300.0, i, 50.6] >> ta; -- add line at the end of the table
i := i+6;
["Roberta", 240.8, i, 20.95] >> ta;
i := i-12;
["Alicia", 407.3, i, 23.26] >> ta;
[] >> ta; -- add empty (undefined) line at the end of the table
i := i + 10;
["Jacinto", 295.95, i, 70.81] >> ta;

println ta;

-- Add a header to the table and their columns
println "And now if we add some headers: ";
ta -> "Cool looking header";
ta.name -> "Nome";
ta.discounts -> "Discontos";
ta.workHours -> "Horas";
ta.payPerHour -> "Euros€/Hora";
ta.TotalPay -> "Total Devido";
println ta;


-- Loop functionality
totalPaid: real;
totalPaid := 0;

println "Now we loop the table and get the names and total pay for every employee";
for elem in ta do -- iterate table lines
   println "Employee ", elem.name, " gets paid ", elem.TotalPay, "€";
   totalPaid := totalPaid + elem.TotalPay;
end;

println "Total price paid for all employees: ", totalPaid, "€";

-- Error Checking and file reading
println "\nNow we will test file reading capabilities";

type table BTable {
   col1: text -> "Text Col";
   col2: real -> "Real Col";
};

println "\nWe try to read the file 'inexistentfile.cpp'";

tr: BTable;
tr := read "inexistentfile.cpp";

if error 
do 
	println "Erro detetato!"; 
	printerror;
else 
	println "Aqui está a tabela final!";
	println tr; 
end;

println "";

println "\nBut now we try to read the file 'testFiles/list1.csv'";
tr := read "testFiles/list1.csv";

if error
do
   println "Erro detetato!";
   printerror;
else
	println "Aqui está a tabela final!";
   println tr;
end;

-- Boolean Operations

x: integer;
x := 16;


if x = 16 
do
	println "A variavel x, com valor: ", x, " é igual a 16, wow!"; 
else 
	println "A variavel c não tem valor 16, mas sim ", x, " infelizmente";
end;

if x <= 10
do
        println "A variavel x, com valor: ", x, " é menor ou igual a 10, wow!";
else
        println "A variavel x não é maior ou igual a 10, infelizmente";
end;

println "";

y: boolean;
y := true;

if y = true
do
   println "Por fim, y é verdadeiro!";
else
   println "Por fim, y é falso";
end;

println "";
