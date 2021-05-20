package com.luizacode.API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luizacode.API"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Luiza Code // DARA SQUAD",
                "O objetivo é que desenvolver um serviço HTTP resolvendo a funcionalidade de Wishlist do cliente.\n" +
                        " Esse serviço atende aos seguintes requisitos:\n" +
                        "- Adicionar um produto na Wishlist do cliente;\n" +
                        "- Remover um produto da Wishlist do cliente;\n" +
                        "- Consultar todos os produtos da Wishlist do cliente;\n" +
                        "- Consultar se um determinado produto está na Wishlist do cliente;",
                "1.1",
                "Terms od Service",
                new Contact("Dara Squad", "https://github.com/caamilacgs/DaraSquad/", "#darasquad"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html",
                new ArrayList<VendorExtension>()
        );
    return apiInfo;
    }
}