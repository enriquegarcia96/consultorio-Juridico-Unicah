package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Administrador implements Initializable {
    @FXML
    private ComboBox<Departamento> cbDepartamento;
    private ObservableList<Departamento> listaDepartamento;

    @Override
    public void initialize(URL url , ResourceBundle resourceBundle){
        listaDepartamento = FXCollections.observableArrayList();
        Departamento.llenar_combobox(listaDepartamento);
        cbDepartamento.setItems(listaDepartamento);
    }


    @FXML
    private RadioButton Radio_Viudo;
    @FXML
    private RadioButton Radio_Union;
    @FXML
    private RadioButton Radio_Soltero;
    @FXML
    private RadioButton Radio_Casado;
    @FXML
    private RadioButton Radio_Rentada;
    @FXML
    private RadioButton Radio_Motocicleta;
    @FXML
    private RadioButton Radio_Propia;
    @FXML
    private RadioButton Radio_Automovil;
    @FXML
    private RadioButton Radio_Habitacion;
    @FXML
    private RadioButton Radio_Apartamento;
    @FXML
    private TextField Text_Numero_Depersonas;

    @FXML
    private RadioButton Radio_Transporte_Publico;

    @FXML
    private RadioButton Radio_Otro;

    @FXML
    private RadioButton Radiio_Prestada;
    @FXML
    private TextField text_Esperfique_Parentesco;
    @FXML
    private TextField Text_Cantidad_Aportada2;
    @FXML
    private TextField Text_Cantidad_Aportada3;
    @FXML
    private TextField text_Esperfique_Parentesco3;
    @FXML
    private TextField text_Esperfique_Parentesco2;
    @FXML
    private TextField Text_Total_Aportada;
    @FXML
    private TextField Text_Cantidad_Aportada;
    @FXML
    private RadioButton Radio_SI_Datos_Economicos;
    @FXML
    private RadioButton Radio_NO_Datos_Economicos;
    @FXML
    private TextField Text_Cargo;
    @FXML
    private TextField Text_Otros_Ingresos;
    @FXML
    private TextField Text_Salario_Ciente;
    @FXML
    private TextField Text_Horario;
    @FXML
    private TextField Text_Cantidad_Personas_Dependientes;
    @FXML
    private AnchorPane Panel_Egresos;
    @FXML
    private Pane panel_Dato_Generales;;
    @FXML
    private AnchorPane Panel_Ingreso_Familiar;
    @FXML
    private RadioButton radio_SI;
    @FXML
    private RadioButton radio_NO;
    @FXML
    private TextField Text_Empresa_Laboral;
    @FXML
    private TextField Text_Parentesco;
    @FXML
    private TextField Text_Espicificacion_De_Egresos;
    @FXML
    private TextField Text_Informacion_Tramite;
    @FXML
    private TextField Text_Nombre_Demandado;

    @FXML
    private TextField Text_Direccion_Demandado;
    @FXML
    private TextField Text_Observaciones_;
    @FXML
    private ComboBox<String> Combo_Municipio;
    @FXML
    private ComboBox<String> Combo_Departamento;

    @FXML
    private ComboBox<?> Combo_Estado_Civil;



    /**combo que mustra los departamentos
     * **
    public void lista_Departamento(ActionEvent actionEvent) {
        Combo_Departamento.getValue();
    }
   // @FXML
    ObservableList<String> listaDepartamento = FXCollections.observableArrayList(
            "Atlántida","Choluteca","Colón","Comayagua","Copán","Cortes","El Paraíso","Francisco Morazán","Gracias a Dios","Intibucá",
            "Islas de la Bahía","La Paz","Lempira","Ocotepeque","Olancho","Santa Bárbara","Valle","Yoro"
    );
    public void initialize(URL url , ResourceBundle resourceBundle){
        Combo_Departamento.setItems(listaDepartamento);
        Combo_Municipio.setItems(listaMunicipios);

    }
    **/
    /**
     * combom que muestra los municipios
     * **/
    public void listaMunicipios(ActionEvent actionEvent) {
        Combo_Municipio.getValue();
    }

    @FXML
    ObservableList<String> listaMunicipios = FXCollections.observableArrayList(
            "La Ceiba","Tela","Colón","Jutiapa","La Masica","San Francisco","Arizona","Esparta","El Porvenir","Intibucá",
            "Islas de la Bahía","La Paz","Lempira","Ocotepeque","Olancho","Santa Bárbara","Valle","Yoro"
    );
   // public void initialize2(URL url2 , ResourceBundle resourceBundle2){
     //   Combo_Municipio.setItems(listaMunicipios);
    //}












    public void registrar_Cliente(ActionEvent actionEvent) {

    }

    public void PanelDatoGeneralesButton(javafx.scene.input.MouseEvent event) {
        this.panel_Dato_Generales.setVisible(true);
        this.Panel_Ingreso_Familiar.setVisible(false);
        this.Panel_Egresos.setVisible(false);
    }
    public void PanelIngresoFamiliarButton(javafx.scene.input.MouseEvent event) {
        this.Panel_Ingreso_Familiar.setVisible(true);
        this.panel_Dato_Generales.setVisible(true);
        this.Panel_Egresos.setVisible(false);
    }
    public void Panel_De_Egresos(javafx.scene.input.MouseEvent event) {
        this.Panel_Egresos.setVisible(true);
        this.panel_Dato_Generales.setVisible(true);
        this.Panel_Ingreso_Familiar.setVisible(false);
    }


    public void llevar(){

    }

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
    public void IrFormulario() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Controlador_Grafico.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();

            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void grupo(ActionEvent actionEvent) {
        if (radio_SI.isSelected()){
            Text_Empresa_Laboral.setDisable(false);
            Text_Salario_Ciente.setDisable(false);
            Text_Cargo.setDisable(false);
            Text_Horario.setDisable(false);
            Text_Otros_Ingresos.setDisable(false);
            Text_Cantidad_Personas_Dependientes.setDisable(false);
            Text_Parentesco.setDisable(false);
        }else if (radio_NO.isSelected()){
            Text_Empresa_Laboral.setDisable(true);
            Text_Empresa_Laboral.setText("");
            Text_Salario_Ciente.setDisable(true);
            Text_Salario_Ciente.setText("");
            Text_Cargo.setDisable(true);
            Text_Cargo.setText("");
            Text_Horario.setDisable(true);
            Text_Horario.setText("");
            Text_Otros_Ingresos.setDisable(true);
            Text_Otros_Ingresos.setText("");
            Text_Cantidad_Personas_Dependientes.setDisable(true);
            Text_Cantidad_Personas_Dependientes.setText("");
            Text_Parentesco.setDisable(true);
            Text_Parentesco.setText("");        }
    }

    public void Datos_Economicos(ActionEvent actionEvent) {
        if (Radio_SI_Datos_Economicos.isSelected()){
            text_Esperfique_Parentesco.setDisable(false);
            text_Esperfique_Parentesco2.setDisable(false);
            text_Esperfique_Parentesco3.setDisable(false);
            Text_Cantidad_Aportada.setDisable(false);
            Text_Cantidad_Aportada2.setDisable(false);
            Text_Cantidad_Aportada3.setDisable(false);
            Text_Total_Aportada.setDisable(false);
        }else if (Radio_NO_Datos_Economicos.isSelected()){
            text_Esperfique_Parentesco.setDisable(true);
            text_Esperfique_Parentesco2.setDisable(true);
            text_Esperfique_Parentesco3.setDisable(true);
            Text_Cantidad_Aportada.setDisable(true);
            Text_Cantidad_Aportada2.setDisable(true);
            Text_Cantidad_Aportada3.setDisable(true);
            Text_Total_Aportada.setDisable(true);

            text_Esperfique_Parentesco.setText("");
            text_Esperfique_Parentesco2.setText("");
            text_Esperfique_Parentesco3.setText("");
            Text_Cantidad_Aportada.setText("");
            Text_Cantidad_Aportada2.setText("");
            Text_Cantidad_Aportada3.setText("");
            Text_Total_Aportada.setText("");
        }
    }



}

