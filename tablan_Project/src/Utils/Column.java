package Utils;

import CSV.CSVParser.RowContext;

import java.util.ArrayList;
@FunctionalInterface
interface Function {
  void apply();
}

public class Column {
    public String header;
    public String type;
    public String formula;

    public ArrayList<Type> data;

    public int maxLength;

    //  Create a new Column
    public Column(String header, String type, String formula) {
        this.header = header;
        this.type = type;
        this.formula = formula;
        this.data = new ArrayList<Type>();
        this.maxLength = 0;
    }

    //  Copy another column but ignore the values
    public Column(Column source) { 
        this.header = source.header;
        this.type = source.type;
        this.formula = source.formula;
        this.data = new ArrayList<Type>();
        this.maxLength = 0;
    }

    //  Copy another column but add only one row
    public Column(Column source, int rowID) { 
        this.header = source.header;
        this.type = source.type;
        this.formula = source.formula;
        this.data = new ArrayList<Type>();
        this.data.add(source.data.get(rowID));
        this.maxLength = 0;
    }

    //  Set the current column header
    public void setHeader(String header) {
        this.header = header;
    }

    //  Put a new value and calculate the maximum number of caracters when converted to string
    public void put(Type value) {
        this.data.add(value);
        int len;
        if (value != null) {
            len = value.representationSize();
        }
        else {
            len = 4; // "null" takes up 4 characters
        }

        if (len > this.maxLength) {
            this.maxLength = len;
        }
    }

    //  Overwrite the whole column's data with a single value (which is repeated)
    public void overwriteAll(Type value) {
        int colDepth = this.data.size();
        for (int i = 0; i < colDepth; i++) {
            this.data.set(i, value);
        }
        if (value != null) {
            this.maxLength = value.representationSize();
        }
        else {
            this.maxLength = 4; //  Size of "null"
        }
    }

    //  Copy the whole columns(data aswell)
    public Column copyCol() {
        Column tempCol = new Column(this);

        for (Type val : this.data) {
            tempCol.put(val);
        }
        return tempCol;
    }

    //  Copy the whole column but only keep a single row of data
    public Column copyColByIndex(int rowIndex) {
        Column tempCol = new Column(this, rowIndex);

        tempCol.data.add(this.getByIndex(rowIndex));
        return tempCol;
    }

    //  Get a row's value (specified by the index)
    public Type getByIndex(int index) {
        if (this.data.size() == 0) {
            return null;
        }
        return this.data.get(index);
    }

    //  Get the data
    public ArrayList<Type> getCol(Type value) {
        return this.data;
    }

    //  Check if this Column is a formula or not
    public Boolean isFormula() {
        return this.formula != null;
    }

    //  Get the formula
    public String getFormula() {
        return this.formula;
    }

    //  Get the number of rows
    public int size() {
        return this.data.size();
    }

    //  Get the maximum number of characters for the data values if they were converted to string
    public int length() {
        return this.maxLength;
    }

    //  Remove a value from the data
    public void remove(Type value) {
        for (Type val : this.data) {
            if (val == value) {
                this.data.remove(val);
            }
        }
        return;
    }

    //  Get the last value of the data
    public Type getLast() {
        if (data.isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
