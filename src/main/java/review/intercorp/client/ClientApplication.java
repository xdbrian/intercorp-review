package review.intercorp.client;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.converter.jackson.JacksonConverterFactory;
import review.intercorp.client.config.RetrofitSecurityInterceptor;
import review.intercorp.client.external.model.ApiExpectativeLife;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}



	@Value("${api.client.url}")
	private String clientUrl;
	@Bean
	public retrofit2.Retrofit retrofitHttpBin() {

		return new retrofit2.Retrofit.Builder()
				.addConverterFactory(JacksonConverterFactory.create())
				.baseUrl(clientUrl)
				.build();
	}

	@Bean
	public ApiExpectativeLife httpBinClient() {
		return retrofitHttpBin().create(ApiExpectativeLife.class);
	}


	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder().addInterceptor(new RetrofitSecurityInterceptor()).build();
	}
}
