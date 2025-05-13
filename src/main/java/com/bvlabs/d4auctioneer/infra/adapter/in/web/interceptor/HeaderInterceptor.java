package com.bvlabs.d4auctioneer.infra.adapter.in.web.interceptor;

import com.bvlabs.d4auctioneer.common.context.RequestContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

    private final RequestContext requestContext;

    public HeaderInterceptor(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        requestContext.setD4TradeToken(request.getHeader("x-d4trade-token"));
        return true;
    }
}
