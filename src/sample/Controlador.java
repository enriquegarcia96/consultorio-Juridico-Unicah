package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controlador {
    public void onPasarVentana() {
        Administrador administrador = new Administrador();

        administrador.IrFormulario2();

    }


    public void IrFormulario () {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrador_Grafico.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
