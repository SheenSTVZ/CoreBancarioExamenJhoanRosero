package ec.edu.espe.arquitectura.sistema1.dao;

import ec.edu.espe.arquitectura.sistema1.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}

