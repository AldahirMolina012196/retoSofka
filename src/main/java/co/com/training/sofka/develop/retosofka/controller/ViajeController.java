package co.com.training.sofka.develop.retosofka.controller;

import co.com.training.sofka.develop.retosofka.model.*;
import co.com.training.sofka.develop.retosofka.services.IViajeService;
import co.com.training.sofka.develop.retosofka.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ViajeController {
    @Autowired
    IViajeService serviceViaje;

    @GetMapping("/listMunicipios")
    public List<Municipio> getDataAllMunicipios(){
        return serviceViaje.getAllMunicipio();
    }

    @GetMapping("/listBuses")
    public List<Bus> getDataAllBuses(){
        return serviceViaje.getAllBus();
    }

    @GetMapping("/listPasajeros")
    public List<Pasajero> getDataAllPasajeros(){
        return serviceViaje.getAllPasajero();
    }

    @PostMapping("/addMunicipios")
    public Response addDataMunicipio(@RequestBody Municipio municipio){
        return serviceViaje.addMunicipio(municipio);
    }
    @PostMapping("/addPasajero")
    public Response addDataMunicipio(@RequestBody Pasajero pasajero){
        return serviceViaje.addPasajero(pasajero);
    }

    @GetMapping("/Municipio/{id}")
    public Response getDataMunicipio(@PathVariable(value="id")String id){
        return serviceViaje.getMunicipio(id);
    }

    @PostMapping("/addBus")
    public Response addDataBus(@RequestBody Bus bus){
        return serviceViaje.addBus(bus);
    }

    @GetMapping("/listBusUno")
    public List<Pasajero> getAllPasajerosBusUno(){
        return serviceViaje.getPasajerosBusUno();
    }

    @GetMapping("/listBusDos")
    public List<Pasajero> getAllPasajerosBusDos(){
        return serviceViaje.getPasajerosBusDos();
    }
    @GetMapping("/listBusTres")
    public List<Pasajero> getAllPasajerosBusTres(){
        return serviceViaje.getPasajerosBusTres();
    }
    @GetMapping("/listBusCuatro")
    public List<Pasajero> getAllPasajerosBusCuatro(){
        return serviceViaje.getPasajerosBusCuatro();
    }

    @GetMapping("/listBusRuta")
    public List<BusRuta> getAllDataBusRuta(){
        return serviceViaje.getAllBusRuta();
    }

    @GetMapping("/listRuta")
    public List<Ruta> getAllDataRuta(){
        return serviceViaje.getAllRuta();
    }


    @GetMapping("/llenarBuses")
    public String llenarBuses(){
        return serviceViaje.addPasajeroAlBus();
    }

    @DeleteMapping("/deletePasajero/{id_pasajero}")
    public Response deleteDataPasajero(@PathVariable(value = "id_pasajero")String idPasajero){
        return serviceViaje.deletePasajero(idPasajero);
    }

    @DeleteMapping("/deleteBus/{id_bus}")
    public Response deleteDataBus(@PathVariable(value = "id_bus")String idBus){
        return serviceViaje.deleteBus(idBus);
    }
    @DeleteMapping("/deleteMunicipio/{id}")
    public Response deleteDataMunicipio(@PathVariable(value = "id")String id){
        return serviceViaje.deleteMunicipio(id);
    }

    @GetMapping("/buscarPasajeroBus/{id_pasajero}")
    public String consultarPasajeroBus(@PathVariable(value="id_pasajero")String idPasajero){
        return serviceViaje.consultPasajero(idPasajero);
    }
}
