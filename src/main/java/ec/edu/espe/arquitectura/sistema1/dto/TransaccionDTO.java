package ec.edu.espe.arquitectura.sistema1.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransaccionDTO {
    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal valor;
}
