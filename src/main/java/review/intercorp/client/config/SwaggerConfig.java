package review.intercorp.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Configura swagger.
 * @Autor xdbrian.steventh@gmai.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("review.intercorp.client.expose"))
                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages())
                .globalResponseMessage(RequestMethod.POST, getCustomizedResponseMessages())
                ;
    }


    /**

     @ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
     @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
     @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED"),
     @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN"),
     @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND") })

     */
    private List<ResponseMessage> getCustomizedResponseMessages(){
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).message("INTERNAL ERROR SERVER").build());
        responseMessages.add(new ResponseMessageBuilder().code(HttpServletResponse.SC_UNAUTHORIZED).message("UNAUTHORIZED").build());
        responseMessages.add(new ResponseMessageBuilder().code(HttpServletResponse.SC_FORBIDDEN).message("FORBIDDEN").build());
        responseMessages.add(new ResponseMessageBuilder().code(HttpServletResponse.SC_NOT_FOUND).message("ELEMENTO NOT FOUND").build());
        return responseMessages;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API REVIEW",
                "Diseño de API para prueba.",
                "1.0.0.SNAPSHOT",
                null,
                new Contact("Brian Torres", "https://github.com/xdbrian/intercorp-review", "xdbrian.steventh@gmail.com"),
                null, null, Collections.emptyList());
    }
}

