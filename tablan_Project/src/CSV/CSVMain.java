package CSV;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.System;

import Utils.TableType;
import Utils.ErrorLogger;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class CSVMain {
   public static TableType readFile(String fileName) {

      if (fileName == null) {
         ErrorLogger.registerError("Foi pedido a leitura de um ficheiro sem específicar qual o seu nome.");
         return null;
      }
      
      try {
         File textFile = new File(fileName);
         InputStream fileData = new FileInputStream(textFile);

         TableType returnTable = new TableType();

         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(fileData);
         // create a lexer that feeds off of input CharStream:
         CSVLexer lexer = new CSVLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         CSVParser parser = new CSVParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            if (!ErrorLogger.error()) {
               Visitor visitor0 = new Visitor();
               visitor0.visit(tree);

               return visitor0.getFinalTable();
            }
         }
      }
      catch (IOException e) {         
         ErrorLogger.registerError("Ficheiro de entrada \"" + fileName + "\" não encontrado");
      }
      catch(RecognitionException e) {
         ErrorLogger.registerError(e.getStackTrace().toString());
      }
      return null;
   }
}
