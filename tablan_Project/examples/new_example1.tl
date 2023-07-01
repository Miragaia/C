-- New Examples

type table AlbumTable -> "PinkFloyd Pictures" {
    Group: text;
    Year: integer;
    Album: text;
    Track: text;
    Name: text;
};

-- Test with big csv files
albums: AlbumTable;

albums := read "testFiles/albums.csv";

-- Catch errors
if error
do
   println "Erro detetato!";
   printerror;
else
	println "Aqui está a tabela final!";
   println albums;
end;
