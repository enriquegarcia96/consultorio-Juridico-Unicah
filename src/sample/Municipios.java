package sample;


import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Municipios {
    private int Id;
    private String NombreMunicipio;
    private int IdDepartamento;



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




    public String toString(){
        return NombreMunicipio;
    }
    public static void llenar_comboboxMunicipio(ObservableList<Municipios> lista2) {
        try {

            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement("SELECT * FROM consultorio_juridico_unicah.municipios");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista2.add(new Municipios(
                        resultSet.getInt("Id"),
                        resultSet.getString("NombreMunicipios"),
                        resultSet.getInt("idDepartamento")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
