package Tablan;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.lang.System;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import Utils.ErrorHandling;

public class TablanMain {
   public static void main(String[] args) {

      if (args.length != 1) {
         ErrorHandling.printError("Número de Argumentos invalido, esperava-se 1 argumento, mas foram passados " + args.length + " argumentos.");
         System.exit(1);
      }

      try {
         File textFile = new File(args[0]);
         InputStream fileData = new FileInputStream(textFile);

         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(fileData);
         // create a lexer that feeds off of input CharStream:
         TablanLexer lexer = new TablanLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         TablanParser parser = new TablanParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            if (!ErrorHandling.error()) {
               Compiler visitor0 = new Compiler();
               String compiledFile = visitor0.visit(tree).render();

               try {
                  BufferedWriter writer = new BufferedWriter(new FileWriter("out/Program.java"));
                  writer.write(compiledFile);
                  writer.close();
               }
               catch (IOException e){
                  ErrorHandling.printError("Falta de permissões para escrever o ficheiro de saida!");
                  System.exit(3);
               }
            }
         }
         
      }
      catch (IOException e) {
         ErrorHandling.printError("Ficheiro de entrada \"" + args[0] + "\" não encontrado");
         System.exit(2);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
