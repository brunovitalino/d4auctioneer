package com.bvlabs.d4auctioneer.item.domain.model;

public record Item(
        Long id,
        String itemDTradeId,
        ItemType itemType,
        String status
) {
}
