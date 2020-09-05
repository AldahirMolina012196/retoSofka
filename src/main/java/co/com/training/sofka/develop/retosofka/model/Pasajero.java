package co.com.training.sofka.develop.retosofka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pasajero")
public class Pasajero {
    @Id
    private String idPasajero;
    private String nombrePasajero;
    private String tapaBocas;
    private int temperatura;
    private String pasajeroBus;

    public Pasajero(String idPasajero, String nombrePasajero, String tapaBocas, int temperatura, String pasajeroBus) {
        this.idPasajero = idPasajero;
        this.nombrePasajero = nombrePasajero;
        this.tapaBocas = tapaBocas;
        this.temperatura = temperatura;
        this.pasajeroBus = pasajeroBus;
    }

    public Pasajero() {
    }

    public Pasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getTapaBocas() {
        return tapaBocas;
    }

    public void setTapaBocas(String tapaBocas) {
        this.tapaBocas = tapaBocas;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getPasajeroBus() {
        return pasajeroBus;
    }

    public void setPasajeroBus(String pasajeroBus) {
        this.pasajeroBus = pasajeroBus;
    }
}
