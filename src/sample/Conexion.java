package sample;
import java.sql.*;

public class Conexion {

    private static Connection con;

    public Conexion() {}



    
    public static Connection abrirConexion() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/consultorio_juridico_unicah?useTimezone=true&serverTimezone=UTC",
                        "root", "Dragon97");

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return con;
    }
}
