package review.intercorp.client.expose;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import review.intercorp.client.model.ClientRequest;
import review.intercorp.client.model.ClientResponse;
import review.intercorp.client.service.ServiceClient;

import javax.validation.Valid;
import java.util.List;

/**
 * Mantiene entrada a servicios de mantenimiento de clientes.
 * @Autor xdbrian.steventh@gmail.com
 */
@RestController(value = "/api/v1")
@Api(value = "Gestión de clientes",description = "Mantiene información de clientes memoria")
public class ClientController {

    @Autowired
    private ServiceClient serviceClient;


    @GetMapping(value = "/clients")
    @ApiOperation(value = "Retorna lista de clientes", response = List.class)
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(serviceClient.list());
    }

    @PostMapping(value = "/clients")
    @ApiOperation(value = "Almacena cliente",response = ClientResponse.class)
    public ResponseEntity<Object> addClient( @Valid @RequestBody ClientRequest request) {
        ClientResponse rs = serviceClient.add(request);
        return ResponseEntity.ok(rs);
    }

}