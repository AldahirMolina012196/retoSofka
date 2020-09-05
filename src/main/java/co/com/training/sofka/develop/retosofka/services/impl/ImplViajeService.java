package co.com.training.sofka.develop.retosofka.services.impl;

import co.com.training.sofka.develop.retosofka.dao.*;
import co.com.training.sofka.develop.retosofka.model.*;
import co.com.training.sofka.develop.retosofka.services.IViajeService;
import co.com.training.sofka.develop.retosofka.util.Response;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class ImplViajeService implements IViajeService {

    IBusDao daoBus;
    IMunicipioDao daoMuicipio;
    IPasajeroDao daoPasajero;
    IRutaDao daoRuta;
    IBusRutaDao daoBusRuta;
    List<Pasajero> listPasajerosBusUno = new ArrayList<>();
    List<Pasajero> listPasajerosBusDos = new ArrayList<>();
    List<Pasajero> listPasajerosBusTres = new ArrayList<>();
    List<Pasajero> listPasajerosBusCuatro = new ArrayList<>();
    List<Bus> listBuses = new ArrayList<>();
    List<BusRuta> listBusRuta = new ArrayList<>();
    List<Ruta> listRuta = new ArrayList<>();



    public ImplViajeService(IBusDao daoBus, IMunicipioDao daoMuicipio, IPasajeroDao daoPasajero, IRutaDao daoRuta, IBusRutaDao daoBusRuta) {
        this.daoBus = daoBus;
        this.daoMuicipio = daoMuicipio;
        this.daoPasajero = daoPasajero;
        this.daoRuta = daoRuta;
        this.daoBusRuta = daoBusRuta;
    }

    @Override
    public List<Municipio> getAllMunicipio() {
        return (List<Municipio>)daoMuicipio.findAll();
    }

    @Override
    public List<Bus> getAllBus() {
        return (List<Bus>)daoBus.findAll();
    }

    @Override
    public List<Pasajero> getAllPasajero() {
        return (List<Pasajero>)daoPasajero.findAll();
    }

    @Override
    public List<BusRuta> getAllBusRuta() {
        return (List<BusRuta>)daoBusRuta.findAll();
    }

    @Override
    public List<Ruta> getAllRuta() {
        return (List<Ruta>)daoRuta.findAll();
    }

    @Override
    public Response addMunicipio(Municipio municipio) {
        Response response = new Response();
        if(daoMuicipio.existsById(municipio.getId())){
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El municipio que desea ingresar ya existe");
        }else{
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody(daoMuicipio.save(municipio));
        }
        return response;
    }

    @Override
    public Response addPasajero(Pasajero pasajero) {
        Response response = new Response();
        if(daoPasajero.existsById(pasajero.getIdPasajero())){
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El pasajero que desea ingresar ya existe");
        }else{
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody(daoPasajero.save(pasajero));
        }
        return response;
    }

    @Override
    public Response addBus(Bus bus) {
        Response response = new Response();
        if(daoBus.existsById(bus.getIdBus())){
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El bus que desea ingresar ya existe");
        }else{
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody(daoBus.save(bus));
        }
        return response;
    }

    @Override
    public Response getMunicipio(String id) {
        Response response = new Response();
        if (daoMuicipio.existsById(id)) {
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody(daoMuicipio.findById(id));
        }else{
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("No existe el municipio con id: " + id);
        }
        return response;
    }

    @Override
    public String addPasajeroAlBus() {
        listPasajerosBusUno.clear();
        listPasajerosBusDos.clear();
        listPasajerosBusTres.clear();
        listPasajerosBusCuatro.clear();
        listBuses.clear();
        listBuses = getAllBus();
        listBuses.get(0).setCapacidadPasajeros(20);
        listBuses.get(1).setCapacidadPasajeros(20);
        listBuses.get(2).setCapacidadPasajeros(20);
        listBuses.get(3).setCapacidadPasajeros(20);
        daoBus.save(listBuses.get(0));
        daoBus.save(listBuses.get(1));
        daoBus.save(listBuses.get(2));
        daoBus.save(listBuses.get(3));
        String mensaje="";
        Pasajero pasajero;
        List<Pasajero> listPasajeros;
        listPasajeros = getAllPasajero();
        ListIterator<Pasajero> it = listPasajeros.listIterator();
        while(it.hasNext()){
            pasajero = it.next();
            mensaje="";
            if(pasajero.getPasajeroBus().equals("BU01") && listPasajerosBusUno.size() < 20){
                listPasajerosBusUno.add(pasajero);
                listBuses.get(0).setCapacidadPasajeros(listBuses.get(0).getCapacidadPasajeros() - 1);
                daoBus.save(listBuses.get(0));
            }else {
                if(pasajero.getPasajeroBus().equals("BU02") && listPasajerosBusDos.size() < 20){
                    listPasajerosBusDos.add(pasajero);
                    listBuses.get(1).setCapacidadPasajeros(listBuses.get(1).getCapacidadPasajeros() - 1);
                    daoBus.save(listBuses.get(1));
                }else{
                    if(pasajero.getPasajeroBus().equals("BU03") && listPasajerosBusTres.size() < 20){
                        listPasajerosBusTres.add(pasajero);
                        listBuses.get(2).setCapacidadPasajeros(listBuses.get(2).getCapacidadPasajeros() - 1);
                        daoBus.save(listBuses.get(2));
                    }else{
                        if(pasajero.getPasajeroBus().equals("BU04") && listPasajerosBusCuatro.size() < 20){
                            listPasajerosBusCuatro.add(pasajero);
                            listBuses.get(3).setCapacidadPasajeros(listBuses.get(3).getCapacidadPasajeros() - 1);
                            daoBus.save(listBuses.get(3));
                        }else{
                            if(listPasajerosBusUno.size() == 20) {
                                mensaje = mensaje +"El bus uno esta lleno\n";
                            }
                            if(listPasajerosBusDos.size() == 20){
                                mensaje = mensaje +"El bus dos esta lleno\n";
                            }
                            if(listPasajerosBusTres.size() == 20) {
                                mensaje = mensaje +"El bus tres esta lleno\n";
                            }
                            if(listPasajerosBusCuatro.size() == 20) {
                                mensaje = mensaje +"El bus Cuatro esta lleno\n";
                            }
                        }
                    }
                }
            }
        }
        return "Se ingresaron los pasajeros al bus correspondiente\n"+ mensaje;
    }

    @Override
    public String consultPasajero(String idPasajero) {
        String mensaje="";
        Pasajero pasajero;
        listBusRuta = getAllBusRuta();
        listRuta= getAllRuta();
        listPasajerosBusUno = getPasajerosBusUno();
        listPasajerosBusDos = getPasajerosBusDos();
        listPasajerosBusTres = getPasajerosBusTres();
        listPasajerosBusCuatro = getPasajerosBusCuatro();
        for(Pasajero busUno: listPasajerosBusUno){
            //mensaje="";
            if(busUno.getIdPasajero().equals(idPasajero)){
                for(BusRuta busRuta: listBusRuta){
                    if(busRuta.getIdBus().equals(listBuses.get(0).getIdBus())){
                        for(Ruta ruta: listRuta){
                            if(busRuta.getIdRuta().equals(ruta.getIdRuta())){
                                mensaje = " El pasajero "+busUno.getNombrePasajero()+" se encuentra en el bus dos y va desde "+ruta.getOrigen()+" hasta "+ruta.getDestino();
                            }
                        }
                    }
                }
            }
            for(Pasajero busDos: listPasajerosBusDos){
                if(busDos.getIdPasajero().equals(idPasajero)){
                    for(BusRuta busRuta: listBusRuta){
                        if(busRuta.getIdBus().equals(listBuses.get(1).getIdBus())){
                            for(Ruta ruta: listRuta){
                                if(busRuta.getIdRuta().equals(ruta.getIdRuta())){
                                    mensaje = " El pasajero "+busDos.getNombrePasajero()+" se encuentra en el bus tres y va desde "+ruta.getOrigen()+" hasta "+ruta.getDestino();
                                }
                            }
                        }
                    }
                }
                for(Pasajero busTres: listPasajerosBusTres){
                    if(busTres.getIdPasajero().equals(idPasajero)){
                        for(BusRuta busRuta: listBusRuta){
                            if(busRuta.getIdBus().equals(listBuses.get(2).getIdBus())){
                                for(Ruta ruta: listRuta){
                                    if(busRuta.getIdRuta().equals(ruta.getIdRuta())){
                                        mensaje = " El pasajero "+busTres.getNombrePasajero()+" se encuentra en el bus cuatro y va desde "+ruta.getOrigen()+" hasta "+ruta.getDestino();
                                    }
                                }
                            }
                        }
                    }
                    for(Pasajero busCuatro: listPasajerosBusCuatro){
                        if(busCuatro.getIdPasajero().equals(idPasajero)){
                            for(BusRuta busRuta: listBusRuta){
                                if(busRuta.getIdBus().equals(listBuses.get(3).getIdBus())){
                                    for(Ruta ruta: listRuta){
                                        if(busRuta.getIdRuta().equals(ruta.getIdRuta())){
                                            mensaje = " El pasajero "+busCuatro.getNombrePasajero()+" se encuentra en el bus uno y va desde "+ruta.getOrigen()+" hasta "+ruta.getDestino();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(mensaje== ""){
            mensaje = "El id del pasajero no existe o no se encuentra en el bus";
        }
        return mensaje;
    }

    @Override
    public List<Pasajero> getPasajerosBusUno() {
        addPasajeroAlBus();
        return listPasajerosBusUno;
    }

    @Override
    public List<Pasajero> getPasajerosBusDos() {
        return listPasajerosBusDos;
    }

    @Override
    public List<Pasajero> getPasajerosBusTres() {
        return listPasajerosBusTres;
    }

    @Override
    public List<Pasajero> getPasajerosBusCuatro() {
        return listPasajerosBusCuatro;
    }

    @Override
    public Response deletePasajero(String idPasajero) {
        Response response = new Response();
        if(daoPasajero.existsById(idPasajero)){
            daoPasajero.deleteById(idPasajero);
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody("Se elimino el pasajero con id: "+ idPasajero);
        }else{
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El pasajero que desea eliminar no existe");
        }
        return response;
    }

    @Override
    public Response deleteBus(String idBus) {
        Response response = new Response();
        if(daoBus.existsById(idBus)){
            daoBus.deleteById(idBus);
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody("Se elimino el bus con id: "+ idBus);
        }else{
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El bus que desea eliminar no existe");
        }
        return response;
    }

    @Override
    public Response deleteMunicipio(String id) {
        Response response = new Response();
        if(daoMuicipio.existsById(id)){
            daoMuicipio.deleteById(id);
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody("Se elimino el pasajero con id: "+ id);
        }else{
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El municipio que desea eliminar no existe");
        }
        return response;
    }


}
