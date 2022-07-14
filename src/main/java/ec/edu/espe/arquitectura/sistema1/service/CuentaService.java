package ec.edu.espe.arquitectura.sistema1.service;

import ec.edu.espe.arquitectura.sistema1.dao.CuentaRepository;
import ec.edu.espe.arquitectura.sistema1.model.Cuenta;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta obtenerCuentaPorInternalId(String internalId) {
        Optional<Cuenta> cuentaOpt = this.cuentaRepository.findByInternalId(internalId);
        return cuentaOpt.orElse(null);
    }

}
