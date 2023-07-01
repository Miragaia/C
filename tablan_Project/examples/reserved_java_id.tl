type table ATable {
   name: text -> "Name:"; -- the final [optional] part indicates the textual view of the column (that is, what must be printed as the header of the table)
   number: integer;
};

type table Exception {
   RuntimeException: text -> "wtf?";
   class: integer;
};

type table TypeTable {
   tempCol: real;
   boolCol: bool;
};

type table throw {};

-- Dor de cabeça abaixo.
class: ATable;
class := new;
Object: Exception;
String: TypeTable;
System: ATable;   
System := String;
Exception: throw;
Exception := new;

-- Imaginem alguém programar assim sem ironia.
