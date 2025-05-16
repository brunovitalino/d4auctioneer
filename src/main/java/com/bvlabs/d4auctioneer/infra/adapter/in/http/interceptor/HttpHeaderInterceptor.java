package com.bvlabs.d4auctioneer.infra.adapter.in.http.interceptor;

import com.bvlabs.d4auctioneer.common.context.RequestContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HttpHeaderInterceptor implements HandlerInterceptor {

    private final RequestContext requestContext;

    public HttpHeaderInterceptor(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        requestContext.setD4TradeToken(request.getHeader("x-d4trade-token"));
        return true;
    }
}
