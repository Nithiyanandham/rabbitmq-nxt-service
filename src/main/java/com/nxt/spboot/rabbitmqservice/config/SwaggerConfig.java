package com.nxt.spboot.rabbitmqservice.config;

import com.nxt.spboot.rabbitmqservice.common.RabbitmqServiceContants;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by nithi on 2019-02-21.
 */
public class SwaggerConfig {

    /**
     * Configure the API's package to be listed in the swagger.
     *
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(RabbitmqServiceContants.REST_API_PACKAGE))
                .paths(regex(RabbitmqServiceContants.SWAGGER_PATH)).build()

                .apiInfo(metaData());
    }

    @SuppressWarnings("deprecation")
    private ApiInfo metaData() {
        return new ApiInfo(RabbitmqServiceContants.SWAGGER_TITLE , RabbitmqServiceContants.SWAGGER_DESC,
               "",
                RabbitmqServiceContants.SWAGGER_DESC,
                "", "", "");
    }

}
