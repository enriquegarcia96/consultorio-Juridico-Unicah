package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Administrador {
    @FXML
    private Pane panel_Dato_Generales;;
    @FXML
    private AnchorPane Panel_Ingreso_Familiar;

    public void PanelIngresoFamiliarButton(javafx.scene.input.MouseEvent event) {
        this.Panel_Ingreso_Familiar.setVisible(true);
        this.panel_Dato_Generales.setVisible(true);
    }
    public void PanelDatoGeneralesButton(javafx.scene.input.MouseEvent event) {
        this.Panel_Ingreso_Familiar.setVisible(false);
        this.panel_Dato_Generales.setVisible(true);
    }





    //variables del cliente






    public void IrFormulario2 () {
        try {
//Te lo comento para que  lo comprendamos tú y yo
//Léeme el source del archivo que te digo fxml y te pongo el path
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrador_Grafico.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
//Creame un nuevo Stage o para que nos entendamos una nueva ventana windows vacía
            Stage stage = new Stage();
//Y ahora dentro del Stage me metes la escena que anteriormente hemos leído y metido en root1
            stage.setScene(new Scene(root1));
// Y ahora le digo que me muestres el stage
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void IrFormulario () {
        try {
//Te lo comento para que  lo comprendamos tú y yo
//Léeme el source del archivo que te digo fxml y te pongo el path
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Controlador_Grafico.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
//Creame un nuevo Stage o para que nos entendamos una nueva ventana windows vacía
            Stage stage = new Stage();
//Y ahora dentro del Stage me metes la escena que anteriormente hemos leído y metido en root1
            stage.setScene(new Scene(root1));
// Y ahora le digo que me muestres el stage
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}

