package review.intercorp.client.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import review.intercorp.client.external.model.ApiExpectativeLife;
import review.intercorp.client.service.ServiceClient;
import review.intercorp.client.util.UtilMock;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceClientImplTest {


    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private ApiExpectativeLife apiExpectativeLife;

    @Autowired
    private ServiceClient serviceClient;


    //inicializa 100 clientes
    @Before
    public void init() {

        new UtilMock().initMemoryMock()
                .stream()
                .forEach(item -> serviceClient.add(item));
    }

    @Test
    public void clientListAllOk() {
        serviceClient.list().stream().forEach(item -> {
            log.info(GSON.toJson(item));
            assertTrue(item.getFechaProbableMuerte()>0);
        });
    }

}