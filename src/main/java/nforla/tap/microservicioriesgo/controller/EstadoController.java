package nforla.tap.microservicioriesgo.controller;

import nforla.tap.microservicioriesgo.servicios.IServicioEstado;
import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/analizarEstado")
public class EstadoController {

    private final Logger logger = LoggerFactory.getLogger(EstadoController.class);
    private IServicioEstado servicioEstado;

    public EstadoController(IServicioEstado servicioEstado) {
        this.servicioEstado = servicioEstado;
    }

    @PostMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoResponse> analizarEstadoPersona(@RequestBody @Valid EstadoRequest estadoRequest) {

        logger.info("Solicitud de analisis de estado: " + estadoRequest);
        return ResponseEntity.ok().body(servicioEstado.determinarEstadoPersona(estadoRequest));

    }

    @PostMapping(path = "/personas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadoResponse>> analizarEstadoPeronas(@RequestBody @Valid List<EstadoRequest> estadoRequests){

        logger.info("Solicitud de análisis de estado: " + estadoRequests);

        return ResponseEntity.ok().body(servicioEstado.determinarEstadoPersonas(estadoRequests));

    }
}
