package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;


public class Controller {

    @FXML
    private TextField TexboxNombre;
    @FXML
    private Button ButtonIniciar;
    @FXML
    private PasswordField TexboxContrasena;


    public void entrandoLogin(ActionEvent actionEvent) {
        String usuario = TexboxNombre.getText().trim();
        String contrasena = TexboxContrasena.getText();
        try {
            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement(
                    "select * from usuario" +
                            "where TipoUsuario = ?" +
                            "and Contrasena = ?"
            );
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}

