package pl.wojciech.sw_task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    /*
    Adresy swaggera:
    http://localhost:8080/v2/api-docs
    http://localhost:8080/swagger-ui.html

    przykłady response body w swaggerze zostawiam w postaci surowej
    ze względu na toczącą się naprawę/aktualizację biblioteki
    */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Star Wars REST API",
                "Custom description of API",
                "0.0.1",
                "Terms of service URL",
                new Contact("John Doe", "www.example.com", "example@email.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
