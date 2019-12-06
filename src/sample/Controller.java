package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button BtnLogin;


    public void onPasarVentana(MouseEvent mouseEvent) throws IOException {
        Stage stage = null;
        Parent rootPrincipal = null;

        if(mouseEvent.getSource() == BtnLogin){
            stage = (Stage) BtnLogin.getScene().getWindow();

            rootPrincipal = FXMLLoader.load(getClass().getResource("../Interfaz_Menu/Controlador_Grafico.fxml"));
            Scene ScenePrincipal = new Scene(rootPrincipal);
            stage.setScene(ScenePrincipal);
            stage.show();
        }
    }
}
