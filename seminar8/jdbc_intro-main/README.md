Task: 

Creați o soluție pentru a stoca informații despre filme într-o bază de date. 
BD-ul poate să fie un H2 in memory database, sau o instanță locală de Postgres sau chiar o baza de date relațională în cloud. 
Programul Java trebuie sa fie capabil sa ruleze operațiuni de tip CRUD (Create Read Update Delete) pe acea bază de date. 

Atenție la configurare. După cum puteți observa și în acest demo, folosim soluția Maven pentru management de dependințe.
In pom.xml avem nevoie de dependința corectă pentru soluția de BD pe care o folosim. ( pt H2, avem dependința com.h2database) 
