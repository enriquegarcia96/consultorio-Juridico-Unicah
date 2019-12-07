package sample;
import java.sql.*;

public class Conexion {

    private static Connection con;

    public Conexion() {}

    public static Connection abrirConexion() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/consultorio?useTimezone=true&serverTimezone=UTC",
                        "root", "dinorey64");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return con;
    }
}
