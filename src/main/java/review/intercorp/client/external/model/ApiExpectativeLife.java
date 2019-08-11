package review.intercorp.client.external.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiExpectativeLife {

    @Headers({"Content-Type: application/json",
            "Vary: Accept",
            "Allow: OPTIONS, GET",
            "Cache-Control: public, max-age=86400"})
    @GET("/1.0/life-expectancy/total/{sex}/{country}/{birth}/")
    Call<ExpectativeLifeResponse> expectativeLife(
            @Path("sex") String sex,
            @Path("country") String country,
            @Path("birth") String birth
    );
}
