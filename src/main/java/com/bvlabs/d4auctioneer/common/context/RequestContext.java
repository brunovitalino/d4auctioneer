package com.bvlabs.d4auctioneer.common.context;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestContext {

    private String d4TradeToken;

    public String getD4TradeToken() {
        return d4TradeToken;
    }

    public void setD4TradeToken(String d4TradeToken) {
        this.d4TradeToken = d4TradeToken;
    }

}
