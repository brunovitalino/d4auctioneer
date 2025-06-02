package com.bvlabs.d4auctioneer.infra.adapter.out.dtrade.feign.config;

import com.bvlabs.d4auctioneer.infra.adapter.out.dtrade.feign.interceptor.FeignAuthInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    private final FeignAuthInterceptor feignAuthInterceptor;

    public FeignClientConfig(FeignAuthInterceptor feignAuthInterceptor) {
        this.feignAuthInterceptor = feignAuthInterceptor;
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return feignAuthInterceptor;
    }

}
