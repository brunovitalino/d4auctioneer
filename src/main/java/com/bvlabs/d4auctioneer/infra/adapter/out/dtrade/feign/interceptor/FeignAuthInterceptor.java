package com.bvlabs.d4auctioneer.infra.adapter.out.dtrade.feign.interceptor;

import com.bvlabs.d4auctioneer.common.context.RequestContext;
import com.bvlabs.d4auctioneer.infra.adapter.in.job.context.JobContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FeignAuthInterceptor implements RequestInterceptor {

    private final ObjectProvider<RequestContext> requestContextProvider;
    private final JobContext JobContext;

    public FeignAuthInterceptor(
            ObjectProvider<RequestContext> requestContextProvider,
            JobContext JobContext) {
        this.requestContextProvider = requestContextProvider;
        this.JobContext = JobContext;
    }

    @Override
    public void apply(RequestTemplate feignRequest) {
        feignRequest.header("Accept", "application/json, text/plain, */*");
        //feignRequest.header("Connection", "keep-alive");

        // Remove blocking by forcing a User-Agent that simulate Mozilla
        feignRequest.header("User-Agent", "Mozilla/5.0"); // "PostmanRuntime/7.35.0"

        // Removes the block from the external API by forwarding the cookie obtained from this request and forwarding it
        // to the request that will be used in the external API.
        forwardD4TradeCredentials(feignRequest);
    }

    private void forwardD4TradeCredentials(RequestTemplate feignRequest) {

        String unformattedD4TradeToken = Optional.ofNullable(requestContextProvider.getIfAvailable())
                .map(ctx -> {
                    try {
                        return ctx.getD4TradeToken();
                    } catch (Exception e) {
                        return null;
                    }
                }).orElse(null);

        if (unformattedD4TradeToken == null) {
            unformattedD4TradeToken = JobContext.getD4TradeToken();
        }

        var keysValues = Arrays.stream(unformattedD4TradeToken.split(";"))
                .map(keyValue -> keyValue.trim().split("=", 2))
                .filter(arr -> arr.length == 2)
                .collect(Collectors.toMap(arr->arr[0].trim(), arr->arr[1].trim()));

        var sessionToken = keysValues.get("__Secure-next-auth.session-token");
        var cfClearance = keysValues.get("cf_clearance");

        if (sessionToken != null && cfClearance != null) {
            String cookieHeader = String.format("__Secure-next-auth.session-token=%s; cf_clearance=%s", sessionToken, cfClearance);
            feignRequest.header("Cookie", cookieHeader);
        }
    }

}
