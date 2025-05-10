package com.bvlabs.d4auctioneer.dtrade.item.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ItemDTradeListResponse(
        List<ItemDTradeResponse> data,
        @JsonProperty("nextCount") Integer nextPageNumber,
        Integer total
) {
}
