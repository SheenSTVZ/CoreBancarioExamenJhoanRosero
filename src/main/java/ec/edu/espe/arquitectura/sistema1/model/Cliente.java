package ec.edu.espe.arquitectura.sistema1.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "cliente")
@TypeAlias("cliente")
public class Cliente {
    @Id
    private String id;

    private String cedula;

    private String nombreCompleto;

    private String estado;

}
