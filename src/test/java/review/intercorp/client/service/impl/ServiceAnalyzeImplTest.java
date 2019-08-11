package review.intercorp.client.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import review.intercorp.client.model.KpiClienteResponse;
import review.intercorp.client.service.ServiceAnalyze;
import review.intercorp.client.service.ServiceClient;
import review.intercorp.client.util.UtilMock;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceAnalyzeImplTest {

    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private ServiceAnalyze serviceAnalyze;

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
    public void calculateKpiTest() {

        KpiClienteResponse kpiClienteResponse = serviceAnalyze.kpideclientes();

        assertThat(kpiClienteResponse.getAverage()>0);
        assertThat(kpiClienteResponse.getStandardDesviation()>0);
    }



}