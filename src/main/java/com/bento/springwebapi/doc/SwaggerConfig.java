package com.bento.springwebapi.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

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
