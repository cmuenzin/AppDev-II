package rmi_tester.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Die DatabaseConnection-Klasse stellt eine Verbindung zu einer MariaDB-Datenbank her.
 * <p>
 * Diese Klasse enthält die notwendigen Informationen und Methoden, um eine Verbindung
 * zur MariaDB-Datenbank aufzubauen.
 * </p>
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/appdev2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    /**
     * Stellt eine Verbindung zur MariaDB-Datenbank her.
     * 
     * @return Eine Connection-Instanz zur Datenbank.
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Verbindung zur Datenbank erfolgreich hergestellt.");
        } catch (ClassNotFoundException e) {
            System.out.println("MariaDB JDBC-Treiber nicht gefunden.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Fehler beim Herstellen der Verbindung zur Datenbank.");
            e.printStackTrace();
        }
        return connection;
    }
}
