package ec.edu.espe.arquitectura.sistema1.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum EstadoTransaccion {
    BLOQUEADA("BLO", "Bloqueada"),
    EJECUTADA("EJE", "Ejecutada");

    private final String value;
    private final String text;
}
