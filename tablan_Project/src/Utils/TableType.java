package Utils;
import CSV.CSVMain;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TableType extends Type {
	public LinkedHashMap<String, Column> columns = new LinkedHashMap<String, Column>();
   public String tableHeader = "";
   public Column tempCol;
   public int activeRowID = 0;

   //  Create a new table
   public TableType() {
      super("table");
   }

   //  Copy a table without any columns
   public TableType(TableType inp) {
      super("table");
      this.tableHeader = inp.tableHeader;
      this.tempCol = inp.tempCol;
      this.activeRowID = inp.activeRowID;
   }

   //  Check if type is numeric
   public boolean isNumeric() {
      return false;
   }

   //  Set the main table header
   public void setMainHeader(String newHeader) {
      tableHeader = newHeader;
      return;
   }

   //  Set the header for a specific column
   public void setColHeader(String colName, String header) {
      columns.get(colName).setHeader(header);
      return;
   }

   //  Add a new string value to a specific column
   public void addToCol(String colname, String value) {
      columns.get(colname).put(new TextType(value));
      return;
   }

   //  Return a specific column
   public Column getCol(String colName) {
      return columns.get(colName);
   }

   //  Set the main table header
   public void set(TableType inpTable) {
      this.columns = inpTable.columns;
      this.activeRowID = inpTable.activeRowID;
      this.tableHeader = inpTable.tableHeader;
      this.tempCol = inpTable.tempCol;
      return;
   }

   //  Set all the values of a whole column to a single value
  public void setValOfCol(String colName, Type value) {
      columns.get(colName).overwriteAll(value);
      return;
   }

   //  Copy a column from one table to the current table
   public void setCopyCol(String colName, TableType sourceTable, String sourceColName) {
      Column sourceCol = sourceTable.getCol(sourceColName);
      columns.put(colName, sourceCol);
      return;
   }

   public void addRow() {
      for (Column col : columns.values()) {
         col.put(null);
      }
      activeRowID++;
   }
   
   //  Add a list of Type values to the columns (by table order)
   public void addRow(Type ...values) {
      // row is null/undefined
      if (values.length == 0) {
         for (Column col : columns.values()) {
            col.put(null);
         }
      }

      else {
         int colIndex = 0;
         for (Column col : columns.values()) {
            col.put(values[colIndex]);
            colIndex++;
         }
      }
      activeRowID++;
      return;
   }

   //  Get an array of the columns
   public List<Column> getCols() {
      return new ArrayList<Column>(columns.values());
   }

   //  This method is wierd
   //  Since we defined the table data structures as Columns, not Lines (Rows), iterating lines
   // inside for loops and still using the same grammar as normal commands makes me have to make
   // this method extremelly ineficient, as it returns an List of Tables each Containing a single row
   // (of the original table) that we iterate in the for loop
   public List<TableType> getRows() {
      List<TableType> allRowValues = new ArrayList<TableType>();

      //  For each row
      for (int rowID = 0; rowID < this.activeRowID; rowID++) {

         //  Copy the columns to a new Table
         TableType currRowTable = new TableType(this);
         
         for (String key : columns.keySet()) {
            Column col = columns.get(key);
            currRowTable.columns.put(key, col.copyColByIndex(rowID));
            currRowTable.activeRowID = 1;
         }

         //  And add it to the List
         allRowValues.add(currRowTable);
      }
      return allRowValues;
   }

   //  Get the value of a columns (only gets the last column, as this method is only used
   // in combination with the single row tables of the previous method).
   public Type getColValue(String colName) {
      Type lastVal = columns.get(colName).getLast();
      if (lastVal == null) {
         lastVal = new TextType("");
      }
      return lastVal;
   }

   //  Total depth (number of rows) of a columns. Should theoretically be the same for all
   // columns in a table
   public IntegerType colLength(String colName) {
      return new IntegerType(columns.get(colName).length());
   }

   //  Copy only the atributes from a source table to the new one and ignore the data
   public void copyColAtributes(String colName, TableType sourceTable, String sourceColName) {
      Column sourceCol = sourceTable.getCol(sourceColName);
      columns.put(colName, sourceCol.copyCol());    //criei contructor no Collumn
      return;

   }

   // Adds a new column to the table
   public void addCol(String colName, Column col) {
      columns.put(colName, col);
      return;
   }

   //  Call the secondary ANTLR4 grammar to read a file and overwrite the current data with the output
   public void readFile(String fileName) {
      TableType tableReadFromFile = CSVMain.readFile(fileName);

      //  We chose to preserve the current data if the read operation goes wrong
      if (tableReadFromFile == null) {
         return;
      }
      
      this.columns = tableReadFromFile.columns;
      this.activeRowID = tableReadFromFile.activeRowID;

      return;
   }

   //  Reset this object to default
   public void reset() {
      this.columns.clear();
      this.tableHeader = "";
      this.tempCol = null;
      this.activeRowID = 0;
   }

   //  Clean all the columns and necessary data
   public void resetCols() {
      this.columns.clear();
      this.tempCol = null;
      this.activeRowID = 0;
   }

   // TODO
   public void readFileColByNumber(String fileName, int fileColNumber, String colName) {

      return;
   }

   // TODO
   public void readFileColByName(String fileName, String fileColName, String colName) {

      return;
   }

   //  Print:
   //  TableHeader
   //  Column Headers
   //  Column Values
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();

      int count = 0;
      int maxSize = 1;
      int maxDepth = 0;
      int numCols = 0;
      boolean exit = false;   
      int totalSize = 0;    
      int colNumber = 0;

      ArrayList<Integer> maxColSize = new ArrayList<Integer>();

      //  Calculate the size (width and depth) of each Column
      for (String key : columns.keySet()) {
         Column col = columns.get(key);
         maxDepth = col.size();
         maxSize = 1;
         numCols++;
         //  Check if the largest value in this column is bigger than our highest width
         if (col.maxLength > maxSize ) {
            maxSize = col.maxLength;
         }
         //  Check if the column's name is bigger than our highest width (ignore if a col header is set)
         if (col.header == null && key.length() > maxSize) {
            maxSize = key.length();
         }
         //  Check if the header is bigger than our highest width (if set)
         if (col.header != null && col.header.length() > maxSize) {
            maxSize = col.header.length();
         }
         maxColSize.add(maxSize);
         totalSize += maxSize + 6;
      }  
      totalSize -= 2;

      sb.append("\n");

      //  Print tableHeader
      if (this.tableHeader != "") {
         sb.append(String.format("   %" + ((totalSize)+this.tableHeader.length())/2 + "s\n\n", this.tableHeader)); 
      }
      sb.append("   ");

      //  Print column headers
      for (String key : columns.keySet()) {
         Column col = columns.get(key);
         sb.append(String.format(" | %" + maxColSize.get(colNumber) + "s | ", (col.header != null) ? col.header : key));
         colNumber++;
      }
      colNumber = 0;

      //  Print line that separates the head from the body of the table
      if (totalSize > 0) {
         sb.append("\n    " + ("-").repeat(totalSize) + "\n");
      }
      
      if (count >= maxDepth) {
         exit = true;
      }
      while (!exit) {
         sb.append("   ");
         for (String key : columns.keySet()) {
            Column col = columns.get(key);
            Type value = col.getByIndex(count);
            sb.append(String.format(" | %" + maxColSize.get(colNumber) + "s | ", value));
            colNumber++;
         }
         colNumber = 0;

         sb.append("\n");
         
         count++;
         if (count >= maxDepth) {
            exit = true;
         }
      }
      
      return sb.toString();
   }
}

