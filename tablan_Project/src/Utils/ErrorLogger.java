package Utils;

import static java.lang.System.*;
import java.io.PrintStream;

import java.util.List;
import java.util.ArrayList;

public class ErrorLogger {

    protected static PrintStream logFile = out; // default
    protected static int errorCount = 0;
    protected static List<String> errorList = new ArrayList<String>();
    
   public static void printLastError() {
    logFile.printf("[Error number %d]: %s\n", errorCount, errorList.get(errorCount-1));
    logFile.flush();
   }

   public static void registerError(String text) {
      errorCount++;
      errorList.add(text);
   }

   public static void removeLastError() {
      assert errorCount > 0;
      errorCount--;
      errorList.remove(errorCount);
   }

   public static boolean error() {
      return errorCount > 0;
   }

   public static int errorCount() {
      return errorCount;
   }

   public static void reset() {
      errorCount = 0;
      errorList.clear();
   }
}

