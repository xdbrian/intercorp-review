package review.intercorp.client.service.impl;

import org.springframework.stereotype.Service;
import review.intercorp.client.model.ClientRequest;
import review.intercorp.client.model.ClientResponse;
import review.intercorp.client.service.ServiceClient;
import review.intercorp.client.util.ClientAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Getión de información de cliente.
 * @Autor xdbrian.steventh@gmai.com
 */
@Service
public class ServiceClientImpl implements ServiceClient {

    private List<ClientResponse> memory;

    ServiceClientImpl() {
        memory = new ArrayList<>();
    }

    /**
     * Lista cliente.
     * @return
     */
    @Override
    public List<ClientResponse> list() {
        return memory;
    }

    /**
     * Retorna clientes por ID
     * @param id
     * @return
     */
    @Override
    public ClientResponse get(Integer id) {
        return null;
    }

    /**
     * Agrega clientes a memoria
     * @param rq
     * @return
     */
    @Override
    public ClientResponse add(ClientRequest rq) {

        ClientResponse clientResponse = ClientAdapter.toRs.apply(rq,memory.size());
        memory.add(clientResponse);

        return clientResponse;
    }

    /**
     * Remueve cliente de memoria por id
     * @param id
     */
    @Override
    public void remove(Integer id) {
        memory.remove(id);
    }

    /**
     * Remueve todos los clientes
     */
    @Override
    public void removeAll() {
        memory.clear();
    }
}
