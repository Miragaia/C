type table BTable {
   col1: text -> "Text Col";
   col2: real -> "Real Col";
};

println "\nWe try to read the file 'inexistentfile.cpp'";

tr: BTable;
tr := read "testFiles/list1.csv";
println tr;

tr := read "testFiles/epoca-normal.csv";
println tr;

tr := read "testFiles/recurso.csv";
println tr;

tr := read "testFiles/list2.csv";
println tr;

tr := read "testFiles/albums.csv";
println tr;
