package nforla.tap.microservicioriesgo.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
public class Deuda {

    @Positive
    private int montoDeDeuda;
    @NotNull
    @Positive
    private int situacionDeDeuda;

}
