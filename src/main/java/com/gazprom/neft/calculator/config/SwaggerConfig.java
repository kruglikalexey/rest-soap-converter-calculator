package com.gazprom.neft.calculator.config;

import com.gazprom.neft.calculator.controller.RestCalculatorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = RestCalculatorController.class)
public class SwaggerConfig {
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEST = "license";
    private static final String TITLE = "Rest api calculator";
    private static final String DESCRIPTION = "Rest api soap calculator converter";

    private ApiInfo appInfo() {
        return new ApiInfoBuilder().version(SWAGGER_API_VERSION)
                                   .license(LICENSE_TEST)
                                   .title(TITLE)
                                   .description(DESCRIPTION)
                                   .build();
    }

    @Bean
    public Docket converterApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(appInfo())
                                                      .select()
                                                      .apis(RequestHandlerSelectors.any())
                                                      .paths(PathSelectors.any())
                                                      .build();
    }
}
