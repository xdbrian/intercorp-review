package review.intercorp.client.expose;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import review.intercorp.client.model.ClientRequest;
import review.intercorp.client.service.ServiceAnalyze;
import review.intercorp.client.service.ServiceClient;

import java.util.List;

/**
 * Gestiona métricas.
 * @Autor xdbrian.steventh@gmail.com
 */
@RestController(value = "/api/v1/kpi")
@Api(value = "Gestión de métricas",description = "Realiza calculo de métricas en función de los clienttes")
public class KpiController {

    @Autowired
    private ServiceAnalyze serviceAnalyze;

    @GetMapping(value = "/kpi-clientes")
    @ApiOperation(value = "Obtiene métricas de clientes", response = List.class)
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(serviceAnalyze.kpideclientes());
    }


}