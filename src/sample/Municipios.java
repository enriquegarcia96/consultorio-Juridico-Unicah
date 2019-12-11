package sample;

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

}
