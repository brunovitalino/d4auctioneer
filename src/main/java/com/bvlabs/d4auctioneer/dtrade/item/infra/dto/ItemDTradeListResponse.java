package com.bvlabs.d4auctioneer.dtrade.item.infra.dto;

import java.util.List;

public record ItemDTradeListResponse(
        List<ItemDTradeResponse> data
) {
}
