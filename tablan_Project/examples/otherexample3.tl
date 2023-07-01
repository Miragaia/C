type table Funcionarios {
    nome: text;
    salario: real;
};

t: Funcionarios;
t := new;
t -> "Tabela de Funcionários";
t.nome -> "Nome";
t.salario -> "Salário";

["João", 1500.00] >> t;
["Maria", 2000.00] >> t;
["Pedro", 1800.00] >> t;

totalSalario: real;
totalSalario := 0;

numLinhas: integer;
numLinhas := 0;

for row in t do
    totalSalario := totalSalario + row.salario;
    numLinhas := numLinhas + 1;
end;

mediaSalario: real;
mediaSalario := totalSalario / numLinhas;

println "A média de salários dos funcionários é: ", mediaSalario;
