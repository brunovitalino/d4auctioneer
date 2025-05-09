package com.bvlabs.d4auctioneer.item.infra.dto;

import com.bvlabs.d4auctioneer.dtrade.domain.model.ItemDTrade;

public record CreateItemResponse(
        long savedItemId,
        ItemDTrade itemDTrade,
        String savedItemStatus
) {
}
