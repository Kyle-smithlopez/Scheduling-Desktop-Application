package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static helper.JDBC.connection;

/**
 * The Query class contains all main SQL queries.
 */
public class Query {

    private static String query;
    private static Statement stmt;
    private static ResultSet result;

    /**
     * Creates a function to simplify CRUD
     */
    public static void makeQuery(String q) {
        query = q;
        try {
            stmt = connection.createStatement();
            // Determine query execution
            if (query.toLowerCase().startsWith("select"))
                result = stmt.executeQuery(q);
            if (query.toLowerCase().startsWith("delete") || query.toLowerCase().startsWith("insert") || query.toLowerCase().startsWith("update"))
                stmt.executeUpdate(q);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static ResultSet getResult() {
        return result;
    }

}
