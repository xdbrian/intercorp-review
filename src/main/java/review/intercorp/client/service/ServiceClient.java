package review.intercorp.client.service;

import review.intercorp.client.model.ClientRequest;
import review.intercorp.client.model.ClientResponse;

import java.util.List;

public interface ServiceClient {

    List<ClientResponse> list();
    ClientResponse get(Integer id);
    ClientResponse add(ClientRequest rq);
    void remove(Integer id);
    void removeAll();

}
