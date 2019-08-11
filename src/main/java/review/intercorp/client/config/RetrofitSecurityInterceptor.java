package review.intercorp.client.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RetrofitSecurityInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Request.Builder requestBuilder = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Vary","Accept")
                .addHeader("Allow","OPTIONS, GET")
                .addHeader("Cache-Control","public, max-age=86400");

        Request authorizedRequest = requestBuilder.build();
        return chain.proceed(authorizedRequest);
    }
}
