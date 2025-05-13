package com.bvlabs.d4auctioneer.common.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "D4Trade API", version = "1.0"))
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(
            new Components().addParameters(
                "x-d4trade-token",
                new Parameter()
                    .in(ParameterIn.HEADER.name())
                    .name("x-d4trade-token")
                    .required(true)
                    .description("D4Trade Cookie containing __Secure-next-auth.session-token and cf_clearance")
                    .schema(new StringSchema())
                    .example("__Secure-next-auth.session-token=abc123-456-789-9876-54321def; cf_clearance=abc123def456")
            )
        );
    }

}
