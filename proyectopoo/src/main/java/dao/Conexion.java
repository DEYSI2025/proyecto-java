package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empleados?useSSL=false&serverTimezone=UTC",
                "root",
                ""
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
