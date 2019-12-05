package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Conexion db = new Conexion();
        try {
            db.MySQLConnection("root", "dinorey64", "consultorio");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
