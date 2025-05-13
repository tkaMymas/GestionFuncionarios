package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_funcionarios";
    private static final String USER = "root";
    private static final String PASSWORD = "anime404";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos");
            }
            catch (SQLException e) {
                System.out.println("Error en la conexión:" + e.getMessage());
                throw e;
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            }
            catch (SQLException e) {
                System.out.println("Error al cerrar la conexión:" + e.getMessage());
            }
        }
    }
}