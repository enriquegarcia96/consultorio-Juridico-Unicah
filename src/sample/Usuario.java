package sample;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private Integer IdUsuario;
    private String Nombre;
    private String Contrasena;
    private String TipoUsuario;

    public  Usuario(Integer IdUsuario, String Nombre, String Contrasena, String TipoUsuario){
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.TipoUsuario = TipoUsuario;
        this.Contrasena = Contrasena;

    }


    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }


    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }



    public String toString(){
        return TipoUsuario;
    }



    public static void llenar_combobox3(ObservableList<Usuario> lista3) {
        try {

            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement("SELECT * FROM consultorio.usuario");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista3.add(new Usuario(
                        resultSet.getInt("IdUsuario"),
                        resultSet.getString("NombreCompleto"),
                        resultSet.getString("TipoUsuario"),
                        resultSet.getString("Contrasena")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


