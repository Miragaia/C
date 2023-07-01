#!/bin/bash

#cd src && java TablanMain $1 && javac Program.java && java Program

cd ../src
mkdir -p out    # Cria diretório se este ainda não existir.

java Tablan/TablanMain ../examples/$1


printf 'File %s correctly compiled! Output is in src/out/Program.java \n' "$1"
