package review.intercorp.client.util;

import review.intercorp.client.model.ClientRequest;
import review.intercorp.client.model.ClientResponse;
import review.intercorp.client.util.SexEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class UtilMock {

    private Random r;
    private Integer max;
    private Integer min;

    public UtilMock() {
        r = new Random();
        max = 60;
        min = 20;
    }
    public List<ClientRequest> initMemoryMock() {


        List<ClientRequest> memoryMock = new ArrayList<>();
        for (int i = 0; i <100; i++) {
            memoryMock.add(getItemRandom());
        }
        return memoryMock;
    }

    /**
     * obtiene cliente random
     * @return
     */
    public ClientRequest getItemRandom() {
        ClientRequest clientRequest = new ClientRequest();
        LocalDate birthdate = getBirthdate();
        Integer age = getAge(birthdate);
        clientRequest.setNombre("NombrePersonaAge"+age);
        clientRequest.setApellido("ApellidoPersonaAge"+age);
        clientRequest.setEdad(age);
        clientRequest.setSexo(getSex());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        String strDate = dateFormat.format(birthdate);
        clientRequest.setFechaNacimiento(birthdate.toString());
        return clientRequest;
    }



    public LocalDate getBirthdate() {
        LocalDate startDate = LocalDate.of(1940, 1, 1); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();

        return LocalDate.ofEpochDay(ThreadLocalRandom.current().longs(start, end).findAny().getAsLong());

    }

    public Integer getAge(LocalDate birthdate) {

        LocalDate now = LocalDate.now(); //end date
        Period periodo = Period.between(birthdate, now);

        return periodo.getYears();
    }


    public String getSex() {
        return r.nextInt(2) == 0 ? SexEnum.MASCULINO.name() : SexEnum.FEMENINO.name();
    }
}
