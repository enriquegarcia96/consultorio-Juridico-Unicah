package sample;

import javafx.collections.ObservableList;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Municipios {
    private int Id;
    private String NombreMunicipio;
    private int IdDepartamento;
    private Data creacion;


    public Municipios(int Id, String NombreDepartamento, int IdDepartamento) {
        this.Id = Id;
        this.NombreMunicipio = NombreDepartamento;
        this.IdDepartamento = IdDepartamento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        NombreMunicipio = nombreMunicipio;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        IdDepartamento = idDepartamento;
    }

    public  String toString(){
        return NombreMunicipio;
    }

    public static void llenar_comboboxMunicipio(ObservableList<Municipios> lista_Municipios) {
        try {

            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement("SELECT * FROM consultorio_juridico_unicah.municipios;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista_Municipios.add(new Municipios(
                        resultSet.getInt("IdMunicipios"),
                        resultSet.getString("NombreMunicipios"),
                        resultSet.getInt("Id_departamento")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
