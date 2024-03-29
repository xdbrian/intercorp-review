package review.intercorp.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import review.intercorp.client.external.model.ApiExpectativeLife;
import review.intercorp.client.external.model.ExpectativeLifeResponse;
import review.intercorp.client.model.ClientResponse;
import review.intercorp.client.model.KpiClienteResponse;
import review.intercorp.client.service.ServiceAnalyze;
import review.intercorp.client.service.ServiceClient;
import review.intercorp.client.util.AnalyzeUtil;
import review.intercorp.client.util.SexEnum;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Getión de métricas.
 * @Autor xdbrian.steventh@gmai.com
 */
@Service
public class ServiceAnalyzeImpl implements ServiceAnalyze {

    @Autowired
    private ServiceClient serviceClient;

    /**
     * Cálculo KPI de clientes.
     */
    @Override
    public KpiClienteResponse kpideclientes() {
        KpiClienteResponse kpiClienteResponse = new KpiClienteResponse();

        List<Integer> listAge = serviceClient.list().stream()
                .map(ClientResponse::getEdad)
                .collect(Collectors.toList());

        Float average = AnalyzeUtil.average.apply(listAge);
        kpiClienteResponse.setAverage(average);

        List<Integer> listAges = serviceClient.list().stream().map(ClientResponse::getEdad).collect(Collectors.toList());
        kpiClienteResponse.setStandardDesviation(AnalyzeUtil.desviationStandard.apply(listAges));
        return kpiClienteResponse;
    }

}
