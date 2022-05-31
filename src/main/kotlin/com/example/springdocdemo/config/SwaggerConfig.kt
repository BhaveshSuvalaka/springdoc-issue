package com.example.springdocdemo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI().info(getInfo())
    }

    private fun getInfo() =
        Info().title("Courses service").description("Swagger UI for Courses service").version("1.0.0")
            .contact(Contact().name("Stingrays").email("bhavesh.suwalka4@gmail.com"))
}