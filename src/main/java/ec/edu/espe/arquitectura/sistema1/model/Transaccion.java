package ec.edu.espe.arquitectura.sistema1.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Document(collection = "transaccion")
@TypeAlias("transaccion")
public class Transaccion {
    @Id
    private String id;

    private String internalId;

    private Date fecha;

    private String cuentaOrigen;

    private String cuentaDestino;

    private BigDecimal valor;

    private String estado;

}
