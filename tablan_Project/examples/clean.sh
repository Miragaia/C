#!/bin/bash

		#  Program.class is already removed by antlr4-clean
cd ../src && antlr4-clean &> /dev/null && rm out/Program.*
echo "File system cleaned of rubish!"
