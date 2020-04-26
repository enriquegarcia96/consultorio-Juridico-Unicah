package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class Administrador  implements Initializable{


    @FXML
    private ComboBox<Municipios> Combo_Departamento;
    @FXML
    private ComboBox<Municipios> Combo_Municipio;
    private ObservableList<Municipios> listaMunicipios;
    @FXML
    private ComboBox<Departamento> cbDepartamento;
    private ObservableList<Departamento> listaDepartamento;
    @FXML
    private Button Boton_Registra;
    @FXML
    private TextField aparta;
    @FXML
    private DatePicker Text_Fecha_Nacimiento;




    public void botonRegistrar(ActionEvent actionEvent){

        Departamento departamento = cbDepartamento.getSelectionModel().getSelectedItem();
        Municipios municipios = Combo_Municipio.getSelectionModel().getSelectedItem();

        String estadoCivil = "";
        if (Radio_Soltero.isSelected()) {
            estadoCivil = "Soltero";
        } else if (Radio_Casado.isSelected()) {
            estadoCivil = "Casado";
        } else if (Radio_Viudo.isSelected()) {
            estadoCivil = "Viudo";
        } else if (Radio_Union.isSelected()) {
            estadoCivil = "UnionDeHecho";
        }

        //transporte
        String vivienda = "";
        if (Radio_Apartamento.isSelected()) {
            vivienda = "Apartamento";
        } else if (Radio_Habitacion.isSelected()) {
            vivienda = "CasaDeHabitacion";
        }

        String habitada = "";
        if (Radio_Propia.isSelected()) {
            habitada = "Propia";
        } else if (Radio_Rentada.isSelected()) {
            habitada = "Rentada";
        } else if (Radiio_Prestada.isSelected()) {
            habitada = "Prestada";
        } else if (Radio_Otro.isSelected()) {
            habitada = "otro";
        }

        String trasporte = "";
        if (Radio_Transporte_Publico.isSelected()) {
            trasporte = "trasporte publico";
        } else if (Radio_Automovil.isSelected()) {
            trasporte = "Automovil";
        } else if (Radio_Motocicleta.isSelected()) {
            trasporte = "Motocicleta";
        }


        String nombreCompleto = Text_Nombre_Completo.getText();
        String edad = Text_Edad.getText();

        DatePicker fechaNacimiento = Text_Fecha_Nacimiento;


        //String fechaNacimiento = Text_Fecha_Nacimiento.getText();

        String lugarnacimiento = Text_Lugar_Nacimiento.getText();

        String direccionActual = Text_Dirrecion_Actual.getText();
        ObservableList<Departamento> departamento2 = cbDepartamento.getItems();
        ObservableList<Municipios> municipios2 = Combo_Municipio.getItems();
        String telefonoFijo = Text_Telefono_Fijo.getText();
        String movil = Text_Movil.getText();
        String referenciaPersonal = Text_Referencia_Personal.getText();
        String telefonoReferencia = Text_Movil_Referencia_Personal.getText();
        String profesion = Text_profesion.getText();
        String identidad = Text_Numero_Identidad.getText();
        String empresalaboral = Text_Empresa_Laboral.getText();
        String horario = Text_Horario.getText();
        String cantidaPersonas = Text_Numero_Depersonas.getText();
        String salarioCliente = Text_Salario_Ciente.getText();
        String cargo = Text_Cargo.getText();
        String otrosIngresos = Text_Otros_Ingresos.getText();
        String parentesco = Text_Parentesco.getText();
        //Parentesco
        String espesifiqueParentesco = text_Esperfique_Parentesco.getText();
        String espesifiqueParentesco2 = text_Esperfique_Parentesco2.getText();
        String espesifiqueParentesco3 = text_Esperfique_Parentesco3.getText();

        String numeroDepersonas = Text_Numero_Depersonas.getText();



        try {
            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO cliente (IdMunicipios,NumeroIdentidad,IdDepartamento,NombreCompleto,Edad,Direccion,TelefonoFijo,TelefonoMovil,EstadoCivil,FechaNacimiento,LugarDeNacimiento,NombreDelReferente,TelefonoDelReferente,Salario,OtrosIngresos,CantidadPersonasDependientes,Parentesco,TipoVivienda,EstadoVivienda,PersonasHabitando,Transporte)" +
                            //"VALUES ('2','0209199700123','1','belkin garcia','30','barrio las flores','24445643','89652134','Viudo','19900923','Tocoa','enrique ramirez','98543234','8000','remesa','3','mama','propia','limpio','4','carropropio');"
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setString(1, String.valueOf(municipios.getId()));
            preparedStatement.setString(2, identidad);
            preparedStatement.setString(3, String.valueOf(departamento.getId()));
            preparedStatement.setString(4, nombreCompleto);
            preparedStatement.setInt(5, Integer.parseInt(edad));
            preparedStatement.setString(6, direccionActual);
            preparedStatement.setString(7, telefonoFijo);
            preparedStatement.setString(8, movil);
            preparedStatement.setString(9, estadoCivil);
            preparedStatement.setString(10, fechaNacimiento.getEditor().getText());
            //preparedStatement.setDate(10, Date.valueOf(fechaNacimiento));
            preparedStatement.setString(11, lugarnacimiento);
            preparedStatement.setString(12, referenciaPersonal);
            preparedStatement.setString(13, telefonoReferencia);
            preparedStatement.setString(14, salarioCliente);
            preparedStatement.setString(15, otrosIngresos);
            preparedStatement.setString(16, cantidaPersonas);
            preparedStatement.setString(17, parentesco);
            preparedStatement.setString(18, vivienda);
            preparedStatement.setString(19, habitada);
            preparedStatement.setString(20, numeroDepersonas);
            preparedStatement.setString(21, trasporte);
            preparedStatement.execute();

            PreparedStatement preparedStatement1 = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO  parentesco (Parentesco) VALUES (?,?,?);"
            );
            preparedStatement1.setString(1,espesifiqueParentesco);
            preparedStatement1.setString(2,espesifiqueParentesco2);
            preparedStatement1.setString(3,espesifiqueParentesco3);
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = Conexion.abrirConexion().prepareStatement(
                    ""
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }




    }


    @FXML
    private TextField Text_Numero_Depersonas;
    @FXML
    private TextField text_Esperfique_Parentesco;

    @FXML
    private TextField Text_Fecha_Nac7imiento;
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
    private RadioButton Radio_Transporte_Publico;

    @FXML
    private RadioButton Radio_Otro;

    @FXML
    private RadioButton Radiio_Prestada;

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
    private ComboBox<?> Combo_Estado_Civil;
    @FXML
    private TextField Text_Nombre_Completo;

    @FXML
    private TextField Text_Edad;
    @FXML
    private TextField Text_Lugar_Nacimiento;


    @FXML
    private TextField Text_Dirrecion_Actual;
    @FXML
    private TextField Text_Telefono_Fijo;
    @FXML
    private TextField Text_Movil;

    @FXML
    private TextField Text_Referencia_Personal;
    @FXML
    private TextField Text_Movil_Referencia_Personal;

    @FXML
    private TextField Text_profesion;
    @FXML
    private TextField Text_Numero_Identidad;









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
        this.Panel_Ingreso_Familiar.setVisible(true);
    }


    @Override
    public void initialize(URL url , ResourceBundle resourceBundle){
        listaDepartamento = FXCollections.observableArrayList();
        Departamento.llenar_combobox(listaDepartamento);
        cbDepartamento.setItems(listaDepartamento);

        listaMunicipios = FXCollections.observableArrayList();
        Municipios.llenar_comboboxMunicipio(listaMunicipios);
        Combo_Municipio.setItems(listaMunicipios);
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


    public void registrar_Cliente(ActionEvent actionEvent) {
    }
}

