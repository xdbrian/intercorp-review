package review.intercorp.client.external.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApiExpectativeLifeTest {

    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private ApiExpectativeLife apiExpectativeLife;


    @Test
    public void callApiExpectativeLifeOk() throws IOException {
        ExpectativeLifeResponse expectativeLifeResponse = apiExpectativeLife
                .expectativeLife("male","Peru","1990-12-21")
                .execute()
                .body();

        log.info(GSON.toJson(expectativeLifeResponse));
        assertNotNull(expectativeLifeResponse);
        assertTrue(expectativeLifeResponse.getTotalLifeExpectancy()>0);
    }

}
