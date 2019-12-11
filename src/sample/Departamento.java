package sample;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Departamento {
    private int id;
    private String nombreDepartamento;
    private Date creacion;

    public Departamento(int id, String nombreDepartamento) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String toString() {
        return nombreDepartamento;
    }


    public static void llenar_combobox(ObservableList<Departamento> lista) {
        try {

            PreparedStatement preparedStatement = Conexion.abrirConexion().prepareStatement("SELECT * FROM consultorio_juridico_unicah.departamento");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista.add(new Departamento(
                        resultSet.getInt("IdDepartamento"),
                        resultSet.getString("NombreDepartamento")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


