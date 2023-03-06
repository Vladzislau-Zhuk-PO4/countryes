package com.vlados.spingmavenkt.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.vlados.spingmavenkt.controller"))
            .paths(PathSelectors.any())
            .build()
    }

    private val apiInfo: ApiInfo
        private get() = ApiInfo(
            "Swagger2 Api Documentation",
            "How to generate Swagger documentation for your Rest API",
            "1.0", "urn:tos",
            Contact("Java Dev Journal", "www.javadevjournal.com", "contact-us@javadevjournal.com"),
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList()
        )
}
