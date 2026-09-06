package com.bento.springwebapi.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the OpenAPI/Swagger documentation for the API.
 *
 * <p>The generated specification is served by springdoc-openapi at
 * {@code /v3/api-docs}, and rendered interactively at
 * {@code /swagger-ui/index.html}.</p>
 *
 * @author Gustavo Bento
 */
@Configuration
public class SwaggerConfig {

    /**
     * Builds the {@link OpenAPI} bean describing this API's metadata
     * (title, description, version and contact information).
     *
     * @return the {@link OpenAPI} configuration used by springdoc-openapi
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot REST API")
                        .description("API REST de exemplo com Spring Boot")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Bento")
                                .url("https://github.com/Gustavo-Bento")
                                .email("gfmb94@gmail.com")
                        )
                );
    }
}
