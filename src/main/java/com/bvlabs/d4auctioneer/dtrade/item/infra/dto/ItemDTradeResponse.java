package com.bvlabs.d4auctioneer.dtrade.item.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemDTradeResponse(
        @JsonProperty("_id") String id,
        String name,
        Integer quantity
) {
}
