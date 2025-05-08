package org.example.studyhub.OpenApiConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class Config {

        @Bean
        public OpenAPI baseOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("StudyHub API")
                            .version("1.0.0")
                            .description("API-dokumentasjon for StudyHub-prosjektet"));
        }
    }


