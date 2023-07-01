#!/bin/bash

#cd src && java TablanMain $1 && javac Program.java && java Program

cd ../src

echo -ne "Building Main Grammar... \n                     (0%)\r"
antlr4 -visitor Tablan/Tablan.g4

echo -ne "Building Secondary Grammar... \n######                (25%)\r"
antlr4 -visitor CSV/CSV.g4


echo -ne "Building necessary java files... \n##########           (50%)\r"
javac Tablan/*.java
javac CSV/*.java

echo -ne "Project Source code built correctly! \n#################### (100%)\n"
