type table Student {
    name: text;
    age: integer;
    grade: real;
};

t: Student;
t := new;
t.name -> "Name";
t.age -> "Age";
t.grade -> "Grade";

c: integer;
c := 1;

["John", 18, 8.5] >> t;
c := c+1;
["Emily", 17, 12] >> t;
c := c+1;
["Michael", 19, 14.9] >> t;

passedCount: integer;
passedCount := 0;

for row in t do
    if row.grade >= 9.5 do
        row.name := row.name + " (Passed)";
        passedCount := passedCount + 1;
    else
        row.name := row.name + " (Failed)";
    end;
    
    println "|", row.name, "|", row.age, "|", row.grade, "|";
end;

println "Total number of students:", c;
println "Number of students who passed:", passedCount;
