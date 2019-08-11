package review.intercorp.client.util;

import review.intercorp.client.model.ClientRequest;
import review.intercorp.client.model.ClientResponse;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ClientAdapter {

    public static BiFunction<ClientRequest,Integer, ClientResponse> toRs = (item,id) -> {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(id);
        clientResponse.setNombre(item.getNombre());
        clientResponse.setApellido(item.getApellido());
        clientResponse.setEdad(item.getEdad());
        clientResponse.setFechaacimiento(item.getFechaNacimiento());
        clientResponse.setSexo(item.getSexo());
        return clientResponse;
    };

    public static BiFunction<ClientResponse,Integer,ClientRequest> toRQ = (item,id) -> {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setNombre(item.getNombre());
        clientRequest.setApellido(item.getApellido());
        clientRequest.setEdad(item.getEdad());
        clientRequest.setFechaNacimiento(item.getFechaacimiento());
        return clientRequest;
    };
}
