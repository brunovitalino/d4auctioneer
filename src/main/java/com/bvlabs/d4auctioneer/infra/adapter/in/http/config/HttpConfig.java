package com.bvlabs.d4auctioneer.infra.adapter.in.http.config;

import com.bvlabs.d4auctioneer.infra.adapter.in.http.interceptor.HttpHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HttpConfig implements WebMvcConfigurer {

    private final HttpHeaderInterceptor httpHeaderInterceptor;

    public HttpConfig(HttpHeaderInterceptor httpHeaderInterceptor) {
        this.httpHeaderInterceptor = httpHeaderInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpHeaderInterceptor)
                .addPathPatterns("/**"); // or just the desired paths
    }
}
