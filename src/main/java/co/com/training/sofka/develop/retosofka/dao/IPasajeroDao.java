package co.com.training.sofka.develop.retosofka.dao;

import co.com.training.sofka.develop.retosofka.model.Pasajero;
import org.springframework.data.repository.CrudRepository;

public interface IPasajeroDao  extends CrudRepository<Pasajero, String> {
}
