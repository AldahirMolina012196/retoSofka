package co.com.training.sofka.develop.retosofka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="bus")
public class Bus {
    @Id
    private String idBus;
    private int capacidadPasajeros;

    public Bus(String idBus, int capacidadPasajeros) {
        this.idBus = idBus;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public Bus(String idBus) {
        this.idBus = idBus;
    }

    public Bus() {
    }

    public String getIdBus() {
        return idBus;
    }

    public void setIdBus(String idBus) {
        this.idBus = idBus;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }
}
