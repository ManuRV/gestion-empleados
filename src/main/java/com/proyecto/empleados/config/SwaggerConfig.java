package com.proyecto.empleados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.proyecto.empleados.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("Gestión de Empleados API")
                .description("API REST para gestionar empleados ")
                .version("1.0")
                .license("Licencia de API")
                .licenseUrl("http://www.tuweb.com/licencia")
                .build();
    }
}
