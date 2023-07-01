## Exemplos de código
---
### Manipulação de Dados

##### Definição de variáveis e valores
- É possivel definir e dar valor sobre os quatro tipos de dados:

```
i: integer;
i := 16;

r: real;
r := 123.704;

t: text;
t := "Uma boa frase";

b: boolean;
b := true;
```

##### Expressões aritméticas
- Operarações básicas também são possíveis:
```
result: real;
result := r * i;
result := result + (r + i) / 3;

t := t + " para se poder ler";
```

##### Conversão de tipos
- Conversões entre todos os tipos são suportadas:
```
someText: text;
aValue: integer;

aValue := integer(someText);
```

##### Leitura do StdIn
- É possivel ler valores do standard input:
```
println "Write some text in the console: ";
inpTXT: text;
inpTXT := text(read in);

println "\nNow write a number (can have decimal spaces): ";
inpREAL: real;
inpREAL := real(read in);
```

##### Escrita no StdOut
- É possivel escrever valores no standard output:
```
println "You wrote '", inpTXT, "' and gave the number ", inpREAL;
```
---
### Manipulação de Tabelas

##### Definição de uma Tabela (com formulas)
- Antes de criar uma tabela, definimos a sua estrutura, isto é, as colunas da tabela, os seus tipos de dados e cabeçalhos:
```
    type table AMinhaTabela {
        nome: text;
        numero: integer;
        salary: real;
        workHours: integer;
        totalPay: real := salary * workHours; -- This is a formula!
    }
```

##### Criação de uma Tabela
- Depois, criamos uma nova tabela vazia, que seguirá a estrutura que definimos acima:
```
    t: AMinhaTabela;
    t := new;
``` 

##### Atribuição de headers
- Damos um nome à tabela (TableHeader):
```
    t -> "A minha tabela"
```

- Para facilitar a compreensão da tabela, pode-se definir um cabeçalho para cada coluna (ColHeader):
```
    t.nome -> "Nome"
    t.numero -> "Número"
    t.totalPay -> "Total a Pagar"
```

##### Adicionar novas linhas a uma tabela
- Finalmente, para adicionar linhas à tabela (incluindo linhas vazias):
```
    ["João", 911222333, 24, 35] >> t;
    ["Ana", 965332191, 26, 30] >> t;
    [] >> t;
```

##### Escrita de uma tabela no StdOut
- Output dos conteúdos da tabela:
```
    println t;

                                A minha tabela

    | Nome |  |    Número | | salary | | workHours | | Total a Pagar | 
    ------------------------------------------------------------------
    | João |  | 911222333 | |     24 | |        35 | |           840 | 
    |  Ana |  | 965332191 | |     26 | |        30 | |           780 | 
    | null |  |      null | |   null | |      null | |          null | 
```
---
### Ciclos

Com o objetivo de que a linguagem ficasse completa, estabelecemos a implementação de ciclos 'for', onde as instruções inseridas são repetidas para cada linha da tabela.

Um exemplo de uma instrução (deste ciclo) válida é:

```
    finalPay: integer;
    finalPay := 0;

    for row in t do
        row.name := row.name + ":";
        println "|",row.name, "|", row.number, "|";
        finalPay := finalPay + row.totalPay;
    end;

    println "Total payment > ", finalPay;
```
---
### Expressões Condicionais
- A implementação das expressões condicionais tem em visão a possibilidade de verificação de condições através da expressão 'if'. 
    - Exemplo de verificação basica:
        ```
            if c = 16 
            do
                println "A variavel c, com valor: ", c, " é igual a 16, wow!"; 
            else 
                println "A variavel c não tem valor 16, mas sim ", c, " infelizmente";
            end;

        ```
        ```
            if boolVal = true 
            do
                println "A variavel boolVal tem valor true!"; 
            end;
        ```
        ```
            if x /= y 
            do
                println "A variavel x não tem o mesmo valor de y!"; 
            end;
        ```
    - Exemplo de verificação após leitura de ficheiros:
        ```
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
        ```
---
## Exemplos

Segue-se um caso ilustrativo de um script simples que pode ser criado usando esta linguagem:
Mais exemplos estão disponíveis na diretoria /examples.

```
    type table ATable {
        name: text -> "Name:"; -- the final [optional] part indicates the textual view of the column (that is, what must be printed as the header of the table)
    number: integer;
    };

    t: ATable;
    t := new; -- new empty table
    t -> "Table:"; -- assigns header to table referenced by t
    t.number -> "Number:"; -- assigns header to column number to table referenced by t
    c: integer;
    c := 1;

    ["One", c] >> t; -- add line at the end of the table
    c := c+1;
    ["Two", c] >> t;
    c := c+1;
    ["Three", c] >> t;

    println t; -- prints table with column alignment (adapted to maximum length of each column)
```
Sendo o respetivo resultado:

           Table:

    | Name: |  | Number: | 
    ----------------------
    |   One |  |       1 | 
    |   Two |  |       2 | 
    | Three |  |       3 | 