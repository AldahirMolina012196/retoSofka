package co.com.training.sofka.develop.retosofka.services;

import co.com.training.sofka.develop.retosofka.model.*;
import co.com.training.sofka.develop.retosofka.util.Response;

import java.util.List;


public interface IViajeService {
    List<Municipio> getAllMunicipio();
    List<Bus> getAllBus();
    List<Pasajero> getAllPasajero();
    List<BusRuta> getAllBusRuta();
    List<Ruta> getAllRuta();
    Response addMunicipio(Municipio municipio);
    Response addPasajero(Pasajero pasajero);
    Response addBus(Bus bus);
    Response getMunicipio(String id);
    String addPasajeroAlBus();
    List<Pasajero> getPasajerosBusUno();
    List<Pasajero> getPasajerosBusDos();
    List<Pasajero> getPasajerosBusTres();
    List<Pasajero> getPasajerosBusCuatro();
    Response deletePasajero(String idPasajero);
    Response deleteBus(String idBus);
    Response deleteMunicipio(String id);
    String consultPasajero(String idPasajero);
}
