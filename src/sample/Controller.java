package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {

    @FXML
    private TextField TexboxNombre;
    @FXML
    private Button ButtonIniciar;
    @FXML
    private PasswordField TexboxContrasena;



    public void entrandoLogin(ActionEvent actionEvent) throws Exception {
        String usuario = TexboxNombre.getText();
        String contrasena = TexboxContrasena.getText();



        Controlador abrir = new Controlador();
        Controller controller = new Controller();

        boolean testeo = controller.validar(usuario,contrasena);

        if (!testeo){
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "usuario inexistente");
            alert.show();
        }else {
            Stage maxi = new Stage();
            Parent registro = FXMLLoader.load(getClass().getResource("Controlador_Grafico.fxml"));
            Scene scene = new Scene(registro);
            maxi.setScene(scene);
            maxi.setMaximized(true);
            maxi.show();
            Stage cerrarLogin = (Stage) ButtonIniciar.getScene().getWindow();
            cerrarLogin.close();
            
        }
    }

    public boolean validar(String usuario, String contrasena) throws Exception{
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "select * from usuario" +
                            " where TipoUsuario = ?" +
                            " and Contrasena = ?"
            );
            sentencia.setString(1,usuario);
            sentencia.setString(2,contrasena);
            System.out.println(sentencia);
            ResultSet resultSet = sentencia.executeQuery();
            if (resultSet.next()){
                return true;
            }
        }catch (SQLException  e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public void cerrar(ActionEvent actionEvent){
        System.exit(0);
    }
}

