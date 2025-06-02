package com.bvlabs.d4auctioneer.infra.adapter.in.job.context;

import org.springframework.stereotype.Component;

@Component
public class JobContext {

    private static final ThreadLocal<String> d4TradeToken = new ThreadLocal<>();

    public String getD4TradeToken() {
        return d4TradeToken.get();
    }

    public void setD4TradeToken(String token) {
        d4TradeToken.set(token);
    }

    public void clear() {
        d4TradeToken.remove();
    }

}
