package co.com.training.sofka.develop.retosofka.dao;

import co.com.training.sofka.develop.retosofka.model.Bus;
import org.springframework.data.repository.CrudRepository;

public interface IBusDao  extends CrudRepository<Bus, String> {
}
