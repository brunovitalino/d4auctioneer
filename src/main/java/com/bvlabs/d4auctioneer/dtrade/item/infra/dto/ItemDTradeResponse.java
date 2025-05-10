package com.bvlabs.d4auctioneer.dtrade.item.infra.dto;

import com.bvlabs.d4auctioneer.dtrade.user.infra.dto.UserDTradeResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ItemDTradeResponse(
        @JsonProperty("_id") String id,
        String name,
        Integer quantity,
        @JsonProperty("userId") UserDTradeResponse userDTradeResponse,
        @JsonProperty("mode") String seasonTypeDescription,        // "season softcore",
        BigDecimal price,   // 250000000,
        String status,      // "active",
        String requestType, // "WTS",
        String itemType    // "rune",
        //expiresAt "2025-05-10T19:51:13.765Z",
        //createdAt "2025-05-08T19:51:13.766Z",
        //updatedAt "2025-05-08T19:51:13.766Z",
) {
}
