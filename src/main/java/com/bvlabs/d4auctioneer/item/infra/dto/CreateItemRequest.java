package com.bvlabs.d4auctioneer.item.infra.dto;

import com.bvlabs.d4auctioneer.item.domain.model.ItemType;

public record CreateItemRequest(
        String itemDTradeId
) {
}
