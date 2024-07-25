package com.markdev.ws.mylist.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MyList API")
                        .description("API para atender projeto MyList")
                        .version("0.0.1")
                        .license(new License()
                                .name("MarkDev")
                                .url("http://www.seusite.com.br")
                        )
                );
    }

}
