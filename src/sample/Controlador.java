package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador {

        public Button button_registro_abogados;

        public void onPasarVentana () throws IOException {
            Stage registroClientes = new Stage();
            Parent registro = FXMLLoader.load(getClass().getResource("Administrador_Grafico.fxml"));
            Scene scene = new Scene(registro);
            registroClientes.setScene(scene);
            registroClientes.setMaximized(true);
            registroClientes.show();
        }

        public void IrFormulario () {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrador_Grafico.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
