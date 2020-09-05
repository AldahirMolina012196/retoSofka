package co.com.training.sofka.develop.retosofka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ruta")
public class Ruta {
    @Id
    private String idRuta;
    private String nombreRuta;
    private String origen;
    private String destino;

    public Ruta(String idRuta) {
        this.idRuta = idRuta;
    }

    public Ruta(String idRuta, String nombreRuta, String origen, String destino) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.origen = origen;
        this.destino = destino;
    }

    public Ruta() {
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
