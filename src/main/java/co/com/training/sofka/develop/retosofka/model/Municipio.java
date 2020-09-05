package co.com.training.sofka.develop.retosofka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="municipio")
public class Municipio {
    @Id
    private String id;
    private String nombre;
    private String departamento;
    private String municipioRuta;

    public Municipio(String id, String nombre, String departamento, String municipioRuta) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.municipioRuta = municipioRuta;
    }

    public Municipio() {
    }

    public Municipio(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipioRuta() {
        return municipioRuta;
    }

    public void setMunicipioRuta(String municipioRuta) {
        this.municipioRuta = municipioRuta;
    }
}
