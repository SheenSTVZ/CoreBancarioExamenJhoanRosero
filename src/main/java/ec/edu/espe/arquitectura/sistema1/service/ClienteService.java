package ec.edu.espe.arquitectura.sistema1.service;

import ec.edu.espe.arquitectura.sistema1.dao.ClienteRepository;
import ec.edu.espe.arquitectura.sistema1.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente obtenerClientePorCodigo(String codigo) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findById(codigo);
        return clienteOpt.orElse(null);
    }

}
