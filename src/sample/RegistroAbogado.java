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

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class RegistroAbogado implements Initializable{


    

    @FXML
    private RadioButton Radio_RentadaA;
    @FXML
    private RadioButton Radio_MotocicletaA;
    @FXML
    private RadioButton Radio_PropiaA;
    @FXML
    private RadioButton Radio_AutomovilA;
    @FXML
    private RadioButton Radio_HabitacionA;
    @FXML
    private RadioButton Radio_ApartamentoA;
    @FXML
    private TextField Text_Numero_DepersonasA;

    @FXML
    private RadioButton Radio_Transporte_PublicoA;

    @FXML
    private RadioButton Radio_OtroA;

    @FXML
    private RadioButton Radiio_PrestadaA;
    @FXML
    private TextField text_Esperfique_ParentescoA;
    @FXML
    private TextField Text_Cantidad_Aportada2A;
    @FXML
    private TextField Text_Cantidad_Aportada3A;
    @FXML
    private TextField text_Esperfique_Parentesco3A;
    @FXML
    private TextField text_Esperfique_Parentesco2A;
    @FXML
    private TextField Text_Total_AportadaA;
    @FXML
    private TextField Text_Cantidad_AportadaA;
    @FXML
    private RadioButton Radio_SI_Datos_EconomicosA;
    @FXML
    private RadioButton Radio_NO_Datos_EconomicosA;
    @FXML
    private TextField Text_CargoA;
    @FXML
    private TextField Text_Otros_IngresosA;
    @FXML
    private TextField Text_Salario_CienteA;
    @FXML
    private TextField Text_HorarioA;
    @FXML
    private TextField Text_Cantidad_Personas_DependientesA;
    @FXML
    private AnchorPane Panel_EgresosA;
    @FXML
    private Pane panel_Dato_GeneralesA;
    @FXML
    private AnchorPane Panel_Ingreso_FamiliarA;
    @FXML
    private RadioButton radio_SIA;
    @FXML
    private RadioButton radio_NOA;
    @FXML
    private TextField Text_Empresa_LaboralA;
    @FXML
    private TextField Text_ParentescoA;
    @FXML
    private TextField Text_Espicificacion_De_EgresosA;
    @FXML
    private TextField Text_Informacion_TramiteA;
    @FXML
    private TextField Text_Nombre_DemandadoA;

    @FXML
    private TextField Text_Direccion_DemandadoA;
    @FXML
    private TextField Text_Observaciones_A;

    @FXML
    private ComboBox<Departamento> CBdepartamentoA;
    private ObservableList<Departamento> listaDepartamento;
    @FXML
    private ComboBox<Municipios> Combo_MunicipioA;
    private ObservableList<Municipios> listaMunicipio;


    @Override
    public void initialize(URL url , ResourceBundle resourceBundle){
        listaDepartamento = FXCollections.observableArrayList();
        Departamento.llenar_combobox(listaDepartamento);
        CBdepartamentoA.setItems(listaDepartamento);

        listaMunicipio = FXCollections.observableArrayList();
        Municipios.llenar_combobox2(listaMunicipio);
        Combo_MunicipioA.setItems(listaMunicipio);


    }





    public void registrar_ClienteA(ActionEvent actionEvent) {

    }

    public void PanelDatoGeneralesButtonA(javafx.scene.input.MouseEvent event) {
        this.panel_Dato_GeneralesA.setVisible(true);
        this.Panel_Ingreso_FamiliarA.setVisible(false);
        this.Panel_EgresosA.setVisible(false);
    }
    public void PanelIngresoFamiliarButtonA(javafx.scene.input.MouseEvent event) {
        this.Panel_Ingreso_FamiliarA.setVisible(true);
        this.panel_Dato_GeneralesA.setVisible(true);
        this.Panel_EgresosA.setVisible(false);
    }
    public void Panel_De_EgresosA(javafx.scene.input.MouseEvent event) {
        this.Panel_EgresosA.setVisible(true);
        this.panel_Dato_GeneralesA.setVisible(true);
        this.Panel_Ingreso_FamiliarA.setVisible(false);
    }


    public void llevar(){

    }

    public void IrFormulario2 () {
        try {
//Te lo comento para que  lo comprendamos tú y yo
//Léeme el source del archivo que te digo fxml y te pongo el path
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistroAbogado_Grafico.fxml"));
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


    public void grupo(ActionEvent actionEvent) {
        if (radio_SIA.isSelected()){
            Text_Empresa_LaboralA.setDisable(false);
            Text_Salario_CienteA.setDisable(false);
            Text_CargoA.setDisable(false);
            Text_HorarioA.setDisable(false);
            Text_Otros_IngresosA.setDisable(false);
            Text_Cantidad_Personas_DependientesA.setDisable(false);
            Text_ParentescoA.setDisable(false);
        }else if (radio_NOA.isSelected()){
            Text_Empresa_LaboralA.setDisable(true);
            Text_Empresa_LaboralA.setText("");
            Text_Salario_CienteA.setDisable(true);
            Text_Salario_CienteA.setText("");
            Text_CargoA.setDisable(true);
            Text_CargoA.setText("");
            Text_HorarioA.setDisable(true);
            Text_HorarioA.setText("");
            Text_Otros_IngresosA.setDisable(true);
            Text_Otros_IngresosA.setText("");
            Text_Cantidad_Personas_DependientesA.setDisable(true);
            Text_Cantidad_Personas_DependientesA.setText("");
            Text_ParentescoA.setDisable(true);
            Text_ParentescoA.setText("");        }
    }

    public void Datos_Economicos(ActionEvent actionEvent) {
        if (Radio_SI_Datos_EconomicosA.isSelected()){
            text_Esperfique_ParentescoA.setDisable(false);
            text_Esperfique_Parentesco2A.setDisable(false);
            text_Esperfique_Parentesco3A.setDisable(false);
            Text_Cantidad_AportadaA.setDisable(false);
            Text_Cantidad_Aportada2A.setDisable(false);
            Text_Cantidad_Aportada3A.setDisable(false);
            Text_Total_AportadaA.setDisable(false);
        }else if (Radio_NO_Datos_EconomicosA.isSelected()){
            text_Esperfique_ParentescoA.setDisable(true);
            text_Esperfique_Parentesco2A.setDisable(true);
            text_Esperfique_Parentesco3A.setDisable(true);
            Text_Cantidad_AportadaA.setDisable(true);
            Text_Cantidad_Aportada2A.setDisable(true);
            Text_Cantidad_Aportada3A.setDisable(true);
            Text_Total_AportadaA.setDisable(true);

            text_Esperfique_ParentescoA.setText("");
            text_Esperfique_Parentesco2A.setText("");
            text_Esperfique_Parentesco3A.setText("");
            Text_Cantidad_AportadaA.setText("");
            Text_Cantidad_Aportada2A.setText("");
            Text_Cantidad_Aportada3A.setText("");
            Text_Total_AportadaA.setText("");
        }
    }



}

