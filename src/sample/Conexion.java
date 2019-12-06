package sample;
import java.sql.*;
<<<<<<< HEAD

public class Conexion {

    private static Connection con;

    private Conexion() {}

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
=======
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static Connection Connect;
    public void MySQLConnection(String user, String pass, String db_name) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/consultorio_juridico_unicah?useTimezone=true&serverTimezone=UTC", "root", "Dragon97");
            JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

>>>>>>> master
