package org.example;

import java.sql.*;
import org.h2.tools.Server;

public class Film
{

    private static final String URL = "jdbc:h2:mem:filmdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";


    public static void main(String[] args)
    {
        try
        {
            Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
            System.out.println("H2 Console started at: http://localhost:8082");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD))
            {
                System.out.println("Connected to H2 in-memory database.\n");
                createTable(connection);

                insertFilm(connection, "Inception", 2010, 9.1);
                insertFilm(connection, "Matrix", 1999, 8.7);
                insertFilm(connection, "Interstellar", 2014, 9.0);
                System.out.println("=== ALL FILMS AFTER INSERT ===");
                printAllFilms(connection);


                updateFilmRating(connection, 2, 9.5);
                System.out.println("\n=== ALL FILMS AFTER UPDATE ===");
                printAllFilms(connection);

                deleteFilm(connection, 1);
                System.out.println("\n=== ALL FILMS AFTER DELETE ===");
                printAllFilms(connection);

                System.out.println("\nOpen the H2 console in browser");
                System.out.println("JDBC URL: " + URL);
                System.out.println("User: sa (no password)");
                System.out.println("\nPress ENTER to exit...");
                System.in.read();

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    private static void createTable(Connection connection) throws SQLException
    {
        String sql = """
                CREATE TABLE films (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    title VARCHAR(100) NOT NULL,
                    release_year INT NOT NULL,
                    rating DOUBLE NOT NULL
                )
                """;

        try (Statement statement = connection.createStatement())
        {
            statement.execute(sql);
            System.out.println("Table 'films' created.");
        }
    }



    private static void insertFilm(Connection connection, String title, int year, double rating) throws SQLException
    {
        String sql = "INSERT INTO films (title, release_year, rating) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, title);
            ps.setInt(2, year);
            ps.setDouble(3, rating);
            ps.executeUpdate();

            System.out.println("Inserted: " + title);
        }
    }



    private static void printAllFilms(Connection connection) throws SQLException
    {
        String sql = "SELECT id, title, release_year, rating FROM films ORDER BY id";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                System.out.println(
                        rs.getInt("id") + " | "
                                + rs.getString("title") + " | "
                                + rs.getInt("release_year") + " | "
                                + rs.getDouble("rating")
                );
            }
        }
    }



    private static void updateFilmRating(Connection connection, int id, double newRating) throws SQLException
    {
        String sql = "UPDATE films SET rating = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setDouble(1, newRating);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Updated film id " + id);
        }
    }



    private static void deleteFilm(Connection connection, int id) throws SQLException
    {
        String sql = "DELETE FROM films WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted film id " + id);
        }
    }
}