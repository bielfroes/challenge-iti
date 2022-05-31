package com.iti.challenge.password.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SpringFoxConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.iti.challenge.password"))
            .build()
            .apiInfo(apiInfo())
    }

    private fun apiInfo() = ApiInfo(
            "Validate Password API",
            "API REST of validate password.",
            "1.0.0",
            "Terms of Service",
            Contact(
                "Gabriel Froes", "",
                "gabrielcaiofroes@gmail.com"
            ),
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0.txt", ArrayList()
        )
}