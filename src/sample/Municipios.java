package sample;


import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Municipios {
    private Integer Id;
    private String NombreMunicipio;
    private Integer IdDepartamento;



    public Municipios(Integer Id, String NombreDepartamento, Integer IdDepartamento) {
        this.Id = Id;
        this.NombreMunicipio = NombreDepartamento;
        this.IdDepartamento = IdDepartamento;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        NombreMunicipio = nombreMunicipio;
    }

    public Integer getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        IdDepartamento = idDepartamento;
    }

    public String toString(){
        return NombreMunicipio;

    }
    public static void llenar_combobox2(ObservableList<Municipios> lista2) {
        try {

            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement("SELECT * FROM consultorio.municipios");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista2.add(new Municipios(
                        resultSet.getInt("IdMunicipios"),
                        resultSet.getString("NombreMunicipios"),
                        resultSet.getInt("id_departamento")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
