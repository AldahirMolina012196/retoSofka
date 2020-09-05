package co.com.training.sofka.develop.retosofka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_ruta")
public class BusRuta {
    @Id
    private String idBusRuta;
    private String idBus;
    private String idRuta;

    public BusRuta(String idBusRuta, String idBus, String idRuta) {
        this.idBusRuta = idBusRuta;
        this.idBus = idBus;
        this.idRuta = idRuta;
    }

    public BusRuta(String idBusRuta) {
        this.idBusRuta = idBusRuta;
    }

    public BusRuta() {
    }

    public String getIdBusRuta() {
        return idBusRuta;
    }

    public void setIdBusRuta(String idBusRuta) {
        this.idBusRuta = idBusRuta;
    }

    public String getIdBus() {
        return idBus;
    }

    public void setIdBus(String idBus) {
        this.idBus = idBus;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }
}
