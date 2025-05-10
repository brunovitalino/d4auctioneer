package com.bvlabs.d4auctioneer.common.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Remove blocking by forcing a User-Agent that simulate Postman
            requestTemplate.header("User-Agent", "PostmanRuntime/7.35.0");
            // Other options
            requestTemplate.header("Accept", "*/*");
            requestTemplate.header("Connection", "keep-alive");
        };
    }
}
