package ec.edu.espe.arquitectura.sistema1.service;

import ec.edu.espe.arquitectura.sistema1.dao.TransaccionRepository;
import ec.edu.espe.arquitectura.sistema1.dto.TransaccionDTO;
import ec.edu.espe.arquitectura.sistema1.enums.EstadoTransaccion;
import ec.edu.espe.arquitectura.sistema1.model.Cliente;
import ec.edu.espe.arquitectura.sistema1.model.Cuenta;
import ec.edu.espe.arquitectura.sistema1.model.Narcotraficantes;
import ec.edu.espe.arquitectura.sistema1.model.Transaccion;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
public class TransaccionService {

    private  static final String BASE_URL="http://localhost:8081/narcotraficantes";

    private final RestTemplate restTemplate;
    private final ClienteService clienteService;

    private final CuentaService cuentaService;

    private final TransaccionRepository transaccionRepository;

    public TransaccionService(ClienteService clienteService, CuentaService cuentaService, TransaccionRepository transaccionRepository) {
        this.clienteService = clienteService;
        this.cuentaService = cuentaService;
        this.transaccionRepository = transaccionRepository;
        this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    public void RealizarTransaccion(Transaccion transaccion) throws NullPointerException{
        transaccion.setInternalId(UUID.randomUUID().toString());
        transaccion.setFecha(new Date());
        Cuenta cuentaOrigen = this.cuentaService.obtenerCuentaPorInternalId(transaccion.getCuentaDestino());
        Cliente clienteOrigen = this.clienteService.obtenerClientePorCodigo(cuentaOrigen.getIdCliente());

        Cuenta cuentaDestino = this.cuentaService.obtenerCuentaPorInternalId(transaccion.getCuentaDestino());
        Cliente clienteDestino = this.clienteService.obtenerClientePorCodigo(cuentaDestino.getIdCliente());

        if(clienteDestino == null && clienteOrigen == null){
            throw new NullPointerException("cliente nulo");
        }

        ResponseEntity<Narcotraficantes> response = this.restTemplate.getForEntity(BASE_URL+"/"+clienteDestino,Narcotraficantes.class);
        Narcotraficantes nar = response.getBody();

        if(nar.getSancionado()!= "NO"){
            transaccion.setEstado(EstadoTransaccion.BLOQUEADA.getText());
        }else{
            transaccion.setEstado(EstadoTransaccion.EJECUTADA.getText());
        }

        this.transaccionRepository.save(transaccion);

    }
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        int connectTimeout = 5000;
        int readTimeout = 5000;
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        return clientHttpRequestFactory;
    }

}
