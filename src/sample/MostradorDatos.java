package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class MostradorDatos implements Initializable{
    @FXML
    private TableView<ModelTable> tvtv;
    @FXML
    private TableColumn<ModelTable, String> tvedad;

    @FXML
    private TableColumn<ModelTable, Integer> tvid;

    @FXML
    private TableColumn<ModelTable, String> tvnombreidentidad;

    @FXML
    private TableColumn<ModelTable, String> tvtelefono;

    @FXML
    private TableColumn<ModelTable, String> tvdireccion;

    @FXML
    private TableColumn<ModelTable, String> tvnombrecompleto;

    ObservableList<ModelTable> lista = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url , ResourceBundle resourceBundle){
        tvid.setCellValueFactory(new PropertyValueFactory("Id"));
        tvedad.setCellValueFactory(new PropertyValueFactory(" Edad"));
        tvnombreidentidad.setCellValueFactory(new PropertyValueFactory("NumeroIdentidad"));
        tvtelefono.setCellValueFactory(new PropertyValueFactory("TelefonoFijo"));
        tvdireccion.setCellValueFactory(new PropertyValueFactory(" Direccion"));
        tvnombrecompleto.setCellValueFactory(new PropertyValueFactory("NombreCompleto"));



    }

    private int IdUsuario;
    private int IdMunicipios;
    private String NumeroIdentidad;
    private int IdDepartamento;
    private String NombreCompleto;
    private int Edad;
    private String Direccion;
    private String TelefonoFijo;
    private String TelefonoMovil;
    private String EstadoCivil;
    private String Fechanacimiento;
    private String LugarDeNacimiento;
    private String NombreDelReferente;
    private String TelefonoDelReferente;
    private String Salario;
    private String OtrosIngresos;
    private String CantidadPersonasDependientes;
    private String Parentesco;
    private String TipoVivienda;
    private String EstadoVivienda;
    private String PersonasHabitando;
    private String Transporte;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getIdMunicipios() {
        return IdMunicipios;
    }

    public void setIdMunicipios(int idMunicipios) {
        IdMunicipios = idMunicipios;
    }

    public String getNumeroIdentidad() {
        return NumeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        NumeroIdentidad = numeroIdentidad;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        IdDepartamento = idDepartamento;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefonoFijo() {
        return TelefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        TelefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return TelefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        TelefonoMovil = telefonoMovil;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public String getFechanacimiento() {
        return Fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        Fechanacimiento = fechanacimiento;
    }

    public String getLugarDeNacimiento() {
        return LugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        LugarDeNacimiento = lugarDeNacimiento;
    }

    public String getNombreDelReferente() {
        return NombreDelReferente;
    }

    public void setNombreDelReferente(String nombreDelReferente) {
        NombreDelReferente = nombreDelReferente;
    }

    public String getTelefonoDelReferente() {
        return TelefonoDelReferente;
    }

    public void setTelefonoDelReferente(String telefonoDelReferente) {
        TelefonoDelReferente = telefonoDelReferente;
    }

    public String getSalario() {
        return Salario;
    }

    public void setSalario(String salario) {
        Salario = salario;
    }

    public String getOtrosIngresos() {
        return OtrosIngresos;
    }

    public void setOtrosIngresos(String otrosIngresos) {
        OtrosIngresos = otrosIngresos;
    }

    public String getCantidadPersonasDependientes() {
        return CantidadPersonasDependientes;
    }

    public void setCantidadPersonasDependientes(String cantidadPersonasDependientes) {
        CantidadPersonasDependientes = cantidadPersonasDependientes;
    }

    public String getParentesco() {
        return Parentesco;
    }

    public void setParentesco(String parentesco) {
        Parentesco = parentesco;
    }

    public String getTipoVivienda() {
        return TipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        TipoVivienda = tipoVivienda;
    }

    public String getEstadoVivienda() {
        return EstadoVivienda;
    }

    public void setEstadoVivienda(String estadoVivienda) {
        EstadoVivienda = estadoVivienda;
    }

    public String getPersonasHabitando() {
        return PersonasHabitando;
    }

    public void setPersonasHabitando(String personasHabitando) {
        PersonasHabitando = personasHabitando;
    }

    public String getTransporte() {
        return Transporte;
    }

    public void setTransporte(String transporte) {
        Transporte = transporte;
    }




    private class ModelTable {
    }
}
