package sample;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private String Id;
    private String NombreCompleto;
    private String TipoUsuario;
    private String Contrasena;

    public Usuario(String Id, String NombreCompleto, String TipoUsuario, String Contrasena){
        this.Id = Id;
        this.NombreCompleto = NombreCompleto;
        this.TipoUsuario = TipoUsuario;
        this.Contrasena = Contrasena;
    }

    public static Usuario GetDatos(String usuario, String contrasena) {
        Usuario Datos;
        PreparedStatement Sentencia;
        try {
            Sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM usuario" +
                            " WHERE (NombreUsuario = ? AND Contrasena = ?)"
            );

            Sentencia.setString(1, usuario);
            Sentencia.setString(2, contrasena);
            ResultSet resultado = Sentencia.executeQuery();

            if (resultado.next()) {
                Datos = Usuario.CrearInstancia(resultado);
                System.out.println("El registro ya existe");
            } else {
                Datos = new Usuario("", "", "", "");
            }
            return Datos;

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error " + e.getMessage());
        }
        return null;
    }


    private static Usuario CrearInstancia(ResultSet resultado){
        Usuario usuario = null;
        try{
            usuario = new Usuario(
                    resultado.getString("Id"),
                    resultado.getString("NombreCompleto"),
                    resultado.getString("TipoUsuario"),
                    resultado.getString("Contrasena")
            );

        }catch (SQLException e){
            System.err.println("Ocurrio un error" + e.getMessage());
        }
        return usuario;
    }

    public String getIdUsuario() {
        return Id;
    }

    public void setIdUsuario(String idUsuario) {
        Id = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreCompleto;
    }

    public void setNombreUsuario(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }


    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        TipoUsuario = tipoUsuario;
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
                        resultSet.getString("Id"),
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
