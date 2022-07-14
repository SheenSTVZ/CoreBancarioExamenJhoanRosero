package ec.edu.espe.arquitectura.sistema1.dao;

import ec.edu.espe.arquitectura.sistema1.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {

    Optional<Cuenta> findByInternalId(String internalId);

}
