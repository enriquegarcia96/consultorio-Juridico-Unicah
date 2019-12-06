package Interfaz_Menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controlador {
    public void IrFormulario () {
        try {


//Te lo comento para que  lo comprendamos tú y yo
//Léeme el source del archivo que te digo fxml y te pongo el path
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("path_to.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

//Creame un nuevo Stage o para que nos entendamos una nueva ventana windows vacía
            Stage stage = new Stage();


//Y ahora dentro del Stage me metes la escena que anteriormente hemos leído y metido en root1
            stage.setScene(new Scene(root1));

// Y ahora le digo que me muestres el stage

            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
