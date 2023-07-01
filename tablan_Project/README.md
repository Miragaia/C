# Tema **TabLan**, grupo **tablan-01**

# Nota: 14.2
-----

## 1. Constituição dos grupos e participação individual global

| NMec | Nome | email | Participação |
|:---:|:---|:---|:---:|
| 107603 | DANIEL AUGUSTO SERRA MADUREIRA | daniel.madureira@ua.pt | 17% |
| 107572 | GONÇALO RAFAEL CORREIA MOREIRA LOPES | goncalorcml@ua.pt | 11% |
|  95316 | JOÃO DIOGO CRAVEIRO FERREIRA | jd.ferreira@ua.pt | 18% |
| 108756 | MARIA JOÃO MACHADO SARDINHA | mariasardinha@ua.pt | 17% |
| 108317 | MIGUEL AIDO MIRAGAIA | miguelmiragaia@ua.pt | 17% |
| 107348 | PEDRO DANIEL FONSECA RAMOS | p.ramos@ua.pt | 20% |

## 2. Estrutura do repositório

- **src** - Todo o código fonte do projeto.

- [**doc**](./doc/README.md) - Documentação adicional a este README.

- **examples** -- Exemplos ilustrativos das linguagens criadas.

## 3. Scripts criados para execução do projeto
- BUILD: Prepara os ficheiros necessários Antlr4 e Java;
- COMPILE: Compila o ficheiro input específicado e gera o ficheiro final de output;
- RUN: Compila e corre o ficheiro de output (em liguagem Java);
- CLEAN: Limpa os ficheiros gerados para a compilação (Java e Antlr4) e os ficheiros de saida;

## 4. Relatório

### Introdução

Este projeto é, na sua forma mais simples, um **compilador de uma linguagem de manipulação de tabelas** e dados para a linguagem **Java**.
A nossa solução implementa duas liguagens, **Tablan e CSV**.

- Tablan é a **linguagem principal** que aceita o código do utilizador.
	Este código passa pelos **analisadores léxico e sintático** da gramática Tablan e é gerada a sua **árvore sintática**. 
	Esta árvore sintática é depois percorrida pelo **Visitor** (Compiler.java) associado a esta gramática.
	O visitor analisa cada objeto do contexto semântico e **obtêm os seus valores** asssociados, que depois introduz num **template** do StringTemplate.
	Este template é finalmente colocado num outro template geral do ficheiro, que depois é **impresso para o ficheiro compilado final**.
<br/>
- CSV é a **linguagem secundária** de leitura de ficheiros input **CSV**.
	Esta linguagem é chamada pelo ficheiro Java final compilado e apenas é **executada em run-time.**
	A linguagem **aceita o ficheiro de entrada**, que depois é analisado léxicamente e sintáticamente.
	A árvore sintática resultante é percorrida por um *Visitor* que irá aos poucos **gerar a tabela final de saida**, ou seja, o Visitor viaja pelos nós da àrvore sintática e à medida que encontra novos valores vai gerando uma tabela final de saida que depois irá ser devolvida ao ficheiro compilado como um objeto TableType.

Ambas as gramáticas aceitam **todos os ficheiros de exemplo** (respetívos a cada gramática) e o código compilado é corretamente gerado para os **exemplos 1, 2 e 3**.

### Estrutura da Tabela
Uma tabela é definida por um:
- **TableHeader**, o Header da tabela, sendo do tipo String inicializado como vazio
- **ColHeader**, o Header de cada Coluna, sendo do tipo String
- **collumns**, #completar
- **Column**, as colunas da tabela, sendo uma ArrayList de valores


### Tipos Suportados
O código inicial suporta os seguintes tipos:

| Tipo | Descrição | 
|:---:|:---|
| TableType | Classe geral de cada Tabela, onde são guardadas as Colunas, informação da tabela e métodos necessários. Este tipo pode ser extendido por outros Tipos de tabela mais específicos criados pelo utilizador  (Ex: ATable no example1)|
| IntegerType<br/>RealType<br/>TextType | Tipos de dados que funcionam como "wrappers" à volta dos tipos gerais de Java. Implementam as operações matemáticas e comparacionais manualmente criadas. |
| int<br/>Double<br/>String | Estes tipos gerais de Java são convertidos para os respetívos tipos manualmente criados deste projeto. |

#### Notas:
Todos os tipos criados para este projeto relacionados com expressões e dados foram manualmente criados.
Por exemplo, na forma como as nossas classes funcionam, em vez de 1 + 1 (int + int) fazemos  IntegerType(1).sum(IntegerType(1)). 	
Mas desta forma é nos permitido **definir como estes tipos interagem explicitamente**, levando a muito **mais controlo** sobre os valores retornados e gerados, tal como **reduzir o número de classes finais** por metade (não nos temos de preocupar com int, double ou String, visto que estes são convertidos para os nossos Tipos.





## 6. CSV ( Visão Global e documentação)
------------------------------------ **Visão Global**--------------------------------------------

A linguagem secundária CSV foi criada para permitir a **leitura/análise de ficheiros de entrada no formato CSV** (.csv).
Esta gramática descreve a estrutura básica de um arquivo CSV, permitindo a **leitura de linhas com campos separados por vírgulas** (',').
Estes campos em questão podem ser textos, números ou sinais de pontuação.
Contrariamente à gramática principal, cada instrução desta linguagem não necessita de terminar com ponto e vírgula (';').

----------------------------------------**Documentação**------------------------------------------------
### Declaração

**Tipos de Variveis disponiveis**

Os tipos de variáveis disponíveis são os seguintes:

```
'PONTUATION' | 'IntegerType' | 'RealType' | 'TextType'
```
Sendo que os tipos de variáveis 'IntegerType', 'RealType' e 'TextType' são importados do pacote 'Utils' e PONTUATION são os separadores de cada coluna.


**Chamada dos Ficheiros CSV**

Como já referido anteriormente (no ponto ['**Criação de uma tabela a partir de um ficheiro CSV**'](./doc/README.md)), os ficheiros CSV são usados para criar tabelas através de instruções de 'read' ou 'read ... using'.

Alguns exemplos são:
```
-- importar feicheiro sem especificar as colunas
t2 := read "testFiles/list1.csv";

-- importar o ficheiro especificando as colunas
t2 := read "testFiles/list2.csv" using column 2 as name, column 1 as number;
```
**Estrutura dos Ficheiros CSV**

A estrutura básica destes ficheiros consiste em:
- **Cabeçalho (header)** - opcional
    (caso possua) É a primeira linha dos ficheiros e contém o **nome das colunas**.
    Exemplo:
        - nome, nmec, teorico_parte1, teorico_parte2, exame_pratico
- **Linhas de dados (rows)** - linhas que se seguem ao cabeçalho;
    Cada linha é composta por **campos** (fields), separados por um **caracter delimitador**, tal como a vírgula (',') ou outros sinais de pontuação (exemplo: pontos e vírgulas ';;'). Estas linhas possuem certos registos de dados que possuem valores correspondentes para cada coluna.
    Exemplo:
    ```
    - Ana,111,10,16,13,14
    - Pink Floyd;;1969;;Soundtrack From The Film 'More';;03;;Crying Song
    ```
**Campos dos Ficheiros CSV**

Como já referido anteriormente, cada linha deste tipo de ficheiros é constituída por **campos**.

Um campo pode ser de três tipos:
- TEXT 
- INTEGER
- REAL

Os campos são separados pelo tipo PONTUACTION (sinal de pontuação).


## 7. Compilador e Analise Semântica

O compilador desta linguagem utiliza o padrão de software **Visitor**, integrado na biblioteca ANTLR4.

Este padrão permite **visitar cada nó da Árvore Sintática de uma forma recursiva**, o que facilita e torna mais flexivel o tratamento da Árvore Sintática gerada pelo Parser do ANTLR4, desempenhando um papel fundamental na Análise Semântica.

Para lidar com os templates a serem usados na geração de código, foi usada a biblioteca ***'StringTemplate'*** .

Esta biblioteca permite a criação de templates flexíveis para geração de texto, fornecendo uma API para carregar/manipular templates, preenchendo-os com **dados dinâmicos** para gerar uma saída personalizada.
Assim, esta biblioteca fica responsável por carregar os arquivos de templates com a **extensão '.stg'** e fornecer uma API para a inserção de outros templates de forma recursiva.

## 8. Exemplos
A **documentação** e **templates** de todas estas funcionalidades implementadas podem ser encontrados [AQUI](./doc/README.md).
Ficheiros de exemplo e de testes podem ser encontrados na pasta **'examples'**.

## 9. Requisítos e Funcionalidades implementadas
#### Minimos:
| Requisito | Status | Descrição | Funcionalidades | 
|:---:|:---:|:---|:---|
| Definição de tabelas | Fully Completed | Podem ser definidas tabelas com colunas independentes ou dependentes (involvendo formulas). É suportado um número infinito de colunas e formulas. | [x] Tabelas;<br/>[x] Colunas;<br/>[x] Formulas. |
| Tipos de dados | Fully Completed | São suportadas a declaração, atribuição e manipulação de dados involvendo os tipos Integer, Real e Text (+ Boolean). | [x] IntegerType;<br/>[x] RealType;<br/>[x] TextType;<br/>[x] BooleanType. <br/> |
| Expressões aritméticas | Fully Completed | São suportados vários tipos de operações involvendo os tipos de dados Integer, Real e Text (+ Boolean), com algumas operações entre tipos diferentes permitidas (onde fazem sentido). | [x] Operações do mesmo tipo;<br/>[x] Operações entre tipos. |
| Escrita no Standard Output | Fully Completed | É suportada a escrita e concatenação de variáveis, texto e tabelas para o standard output, com ou sem mudança de linha no fim. | [x] Escrita sem mudança de linha;<br/>[x] Escrita com mudança de linha;<br/>[x] Concatenação de várias expressões. |
| Leitura do Standard Input | Fully Completed | Pode ser pedido ao utilizador que introduza valores a partir do standard input. | [x] Leitura stdin. |
| Conversão de tipos | Fully Completed | É permitida a conversão de variáveis e dados entre tipos dado que sejam guardadas numa variável do tipo específicado (se necessário guarda-las) e que as conversões sejam possíveis (Ex: integer("abc") não é suportado, mas sim integer("16") ). | [x] Conversão integer;<br/>[x] Conversão real;<br/>[x] Conversão text. |
| Adicionar nova linha a uma tabela | Fully Completed | É possível adicionar uma linha (row) a tabelas existentes provindo que os valores que não vem de uma coluna dependente (formula) são introduzidos na mesma ordem das colunas e com o mesmo tipo de dados. | [x] Introdução de nova linha;<br/>[x] Introdução de linha vazia. |
| Adicionar cabeçalho a tabelas e colunas | Fully Completed | É possível especificar cabeçalhos (texto) associado tanto a tabelas como a colunas específicas. Caso não seja especificamente dito, é utilizado o nome das colunas como cabeçalho destas (em prints). | [x] Cabeçalhos das tabelas;<br/>[x] Cabeçalhos das colunas. |
| Iteração de tabelas | Fully Completed | Instruções de loops do tipo "for" são suportadas para iterar sobre as linhas de uma coluna. De notar que alterações a cada coluna temporária não altera a coluna na tabela original (algo que queriamos implementar, mas é muito mais complicado visto que Java trabalha com dados pelo valor, não pela referência). | [x] Iteração de tabelas;<br/>[x] Leitura de cada coluna de cada linha. |
| Verificação semântica | Fully Completed | A verificação da consistência de tipos de dados ainda e a deteção de colisões entre tipos diferentes (atribuir texto a um integer, por exemplo), estão funcionais. | [x] Associação dos tipos a variáveis;<br/>[x] Verificação dos tipos. |


#### Desejáveis:
| Requisito | Status | Descrição | Funcionalidades | 
|:---:|:---:|:---|:---|
| Operações Booleanas | Partially Implemented | Expressões booleanas do tipo x=y, x!=y, x<y, x>y, x<=y e x>=y estão completamente implementadas e o valor do predicado resultante pode ser guardado em variáveis próprias (BooleanType). | [x] Detetar os valores de um predicado;<br/>[x] Guardar o valor de um predicado;<br/>[ ] Conjunção e Disjunção. |
| Instrução condicional | Fully Completed | Estruturas do tipo 'if' estão completamente implementadas, com suporte de 'else' opcional e leitura de expressões booleanas. | [x] Tabelas;<br/>[x] Colunas;<br/>[x] Formulas. |

## Contribuições

- **Gramática Tablan**: Pedro, Maria
- **Gramática CSV**: Maria, Daniel
- Tipos de dados **TableType**: Miragaia, Pedro
- Tipos de dados **IntegerType, RealType e TextType**: João, Pedro
- **Compilador Tablan**: Pedro, João
- **Visitor CSV**: Daniel 
- **StringTemplate**: Pedro
- **Readme**: Maria, Miragaia, Pedro
- **Ficheiros de exemplo**: Daniel, João, Gonçalo
- **Scripts**: Pedro
- **Processamento de erros**: Pedro

