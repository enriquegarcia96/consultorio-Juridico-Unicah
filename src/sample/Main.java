package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
   // public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Inicie sesion");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


 public static void main(String[] args) {
        String destino= "adanalfredogaleascarcamo@gmail.com";
        String asunto= "sdfsdfsd";
        String cuerpo= "adfadsfsdf";
        //Email.enviarConGMail(destino,asunto,cuerpo);
        launch(args);

    }




}
