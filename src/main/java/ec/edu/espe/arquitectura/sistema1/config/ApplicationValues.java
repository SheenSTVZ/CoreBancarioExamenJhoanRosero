package ec.edu.espe.arquitectura.sistema1.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationValues {
    private final String mongoHost;
    private final String mongoDB;
    private final String mongoAut;

    public ApplicationValues(
            @Value("localhost") String mongoHost,
            @Value("MongoDB") String mongoDB,
            @Value("0") String mongoAut) {

        this.mongoHost = mongoHost;
        this.mongoDB = mongoDB;
        this.mongoAut = mongoAut;
    }
}
