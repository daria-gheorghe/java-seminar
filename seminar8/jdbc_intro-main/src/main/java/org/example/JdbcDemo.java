package org.example;

import java.sql.*; //Importă tot ce e necesar pentru JDBC — Connection, Statement, PreparedStatement, ResultSet, DriverManager. Steluța * înseamnă "importă tot din pachetul java.sql".

import org.h2.tools.Server; //Importă clasa Server din librăria H2. Aceasta îți permite să pornești o consolă web vizuală unde poți vedea baza de date în browser.


public class JdbcDemo
{

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    //URL-ul de conectare la baza de date
//    jdbc:h2 → folosește JDBC, baza de date este H2
//    mem:testdb → baza de date e în memorie RAM(nu pe disc), deci dispare cand programul se inchide, cu numele testdb
//    DB_CLOSE_DELAY=-1 → ține baza de date deschisă cât timp rulează programul (altfel s-ar închide când nu mai are nicio conexiune)

    private static final String USER = "sa";
    private static final String PASSWORD = "";
    //    Credențialele pentru H2:
//    user default= sa = "system administrator", parola e goală.

    public static void main(String[] args)
    {
        try //aici pui bloc care poate genera erori
        {   //de exemplu: portul 8082 poate fi ocupat; conexiunea la baza de date poate eșua; SQL-ul poate fi greșit; System.in.read() poate da eroare.

            Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
            //Pornește un server web pe portul 8082(creeaza interfata grafica)
            //Server.createWebServer = apelezi o metoda statica din clasa Server. Ea creeaza un server web pt consola H2
            //Dacă deschizi http://localhost:8082 în browser în timp ce programul rulează, poți vedea și interacționa vizual cu baza de date
            System.out.println("H2 Console started at: http://localhost:8082");

            //CREAREA CONEXIUNII LA BAZA DE DATE
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD))
            {   //Un obiect Connection reprezintă legătura activă dintre Java și baza de date.Prin aceasta conexiune trimiti comenzi SQL
                //DriverManager.getConnection(...) — creează o conexiune la baza de date folosind URL, user și parolă
                //Conection este o resursa care trebuie inchisa
                //try (...) — garantează că la final conexiunea se închide automat, chiar dacă apare o eroare

                System.out.println("Connected to H2 in-memory database.\n");

                createTable(connection);    //Apelează metoda care creează tabela students.
                // Îi dai conexiunea la baza de date
                //pentru ca metoda trebuie sa execute SQL in baza de date; fara coneziune, nu are prin ce sa comunice cu baza

                insertStudent(connection, "Alice Johnson", "alice@example.com");
                insertStudent(connection, "Bob Smith", "bob@example.com");
                insertStudent(connection, "Carol Davis", "carol@example.com");
                //Inserează 3 studenți în baza de date.

                System.out.println("=== ALL STUDENTS AFTER INSERT ===");
                printAllStudents(connection);

                updateStudentEmail(connection, 2, "bob.smith@school.com");
                System.out.println("\n=== ALL STUDENTS AFTER UPDATE ===");
                printAllStudents(connection);

                deleteStudent(connection, 1);
                System.out.println("\n=== ALL STUDENTS AFTER DELETE ===");
                printAllStudents(connection);

                System.out.println("\nOpen the H2 console in your browser!");
                System.out.println("JDBC URL: " + URL);
                System.out.println("User: sa (no password)");
                System.out.println("\nPress ENTER to exit...");
                System.in.read();   //Programul se oprește și așteaptă să apeși Enter.
                // Pentru că dacă programul s-ar termina imediat, baza de date in-memory ar dispărea înainte să poți vedea ceva în consolă la localhost:8082.
                // Această linie îți dă timp să deschizi browserul și să explorezi.

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();    //afiseaza eroarea completa in consola
        }
    }

    private static void createTable(Connection connection) throws SQLException
    {   //primeste ca parametru conexiunea la baza de date
        //metoda poate arunca o eroare SQL(SQL gresit, tabel deja existent, conexiune invalida)
        //in loc sa tratezi eroarea aici cu try-catch, o pasezi mai sus catre main

        //aici construiesti comanda SQL sub forma de text
        String sql = """    
            CREATE TABLE students (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL
            )
            """;
         //"""...""" e un text block din Java modern — permite string-uri pe mai multe linii

        //aici se executa comanda SQL
        try (Statement statement = connection.createStatement())
        {   //Statement e folosit pentru SQL-uri fără parametri variabili.
            statement.execute(sql); // executa SQL-ul
            //execute() = metoda generala, merge pt comenzi CREATE, ALTER, DROP
            System.out.println("Table 'students' created.");
        }
        //Din nou try-with-resources ca să se închidă automat


    }



    private static void insertStudent(Connection connection, String name, String email) throws SQLException
    {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        //Semnele de întrebare ? sunt placeholder-e — valori care vor fi completate dinamic ulterior, prin ps.setString

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {   //PreparedStatement e folosit când ai parametri variabili (acei ?)
            ps.setString(1, name);
            ps.setString(2, email);
            //Completează primul ? cu name și al doilea ? cu email.
            // in JDBC, indexul începe de la 1, nu de la 0 (spre deosebire de array-uri în Java)
            ps.executeUpdate(); //Execută comanda SQL
            //executeUpdate() = pt INSERT,UPDATE,DELETE
            //returneaza un int, numarul de randuri afectate

            System.out.println("Inserted: " + name);
        }
    }

    private static void printAllStudents(Connection connection) throws SQLException
    {
        String sql = "SELECT id, name, email FROM students ORDER BY id";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())  //2 resurse in acelasi try-with-resources
        {  //executeQuery() e folosit pentru SELECT — operații care citesc date
            //Returnează un ResultSet, care e practic un cursor ce parcurge rândurile rezultate
            //deci ResultSet este rezultatul unui SELECT
            while (rs.next())   //parcurge fiecare rand din ResultSet
            {  //rs.next() avansează la următorul rând și returnează true dacă există
                //La început cursorul e poziționat înainte de primul rând, deci primul next() îl aduce pe primul rând
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email")
                );
                //Pentru fiecare rând, extrage valorile coloanelor după numele coloanei.
                // .getInt() pentru numere
                // .getString() pentru text.
            }
        }
    }

    private static void updateStudentEmail(Connection connection, int id, String newEmail) throws SQLException
    {
        String sql = "UPDATE students SET email = ? WHERE id = ?";
        //Actualizează emailul doar pentru studentul cu id-ul specificat.
        // WHERE e esențial — fără el ar actualiza toți studenții!

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setInt(2, id);

            ps.executeUpdate(); //executa modificarea
            System.out.println("Updated student id " + id);
        }
    }

    private static void deleteStudent(Connection connection, int id) throws SQLException
    {
        String sql = "DELETE FROM students WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            ps.executeUpdate(); //executa stergerea
            System.out.println("Deleted student id " + id);
        }
    }
}

//STATEMENT, PREPARED STATEMENT, RESULT SET
// 1.Statement -> folosit pt SQL simplu, fara parametri:
//      Statement statement = connection.createStatement();
//      statement.execute(sql);
//  Exemplu: CREATE TABLE students (...)

// 2.PreparedStatement -> folosit pt SQl cu valori variabile:
//      PreparedStatement ps = connection.prepareStatement(sql);
//      ps.setString(1, name);
//      ps.setString(2, email);
//  Exemplu:  INSERT INTO students (name, email) VALUES (?, ?)

// 3.ResultSet -> folosit pt rezultatul unui SELECT
//      ResultSet rs = ps.executeQuery();
//      while (rs.next()) {
//               ...
//      }



//EXECUTE, EXECUTE UPDATE, EXECUTE QUERY
// 1.execute(sql) -> pt CREATE TABLE
// 2.executeUpdate() -> pt INSERT, UPDATE, DELETE
// 3.executeQuery() -> pt SELECT


