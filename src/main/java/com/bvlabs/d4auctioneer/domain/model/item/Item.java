package com.bvlabs.d4auctioneer.domain.model.item;

import com.bvlabs.d4auctioneer.infra.dto.dtrade.ItemDTradeResponse;

import java.math.BigDecimal;

public record Item(
        String id,
        String name,
        Integer quantity,
        ItemUser itemUser,
        SeasonType seasonType,        // "season softcore",
        BigDecimal price,   // 250000000,
        String status,      // "active",
        String transactionType, // "WTS",
        ItemType itemType    // "rune",
        //expiresAt "2025-05-10T19:51:13.765Z",
        //createdAt "2025-05-08T19:51:13.766Z",
        //updatedAt "2025-05-08T19:51:13.766Z",
        //BigDecimal minAcceptableSellerValue; price=1000000,99999999999
        //BigDecimal desirableSellerValue;

) {

    public Item(String id, String name, Integer quantity) {
        this(id, name, quantity, new ItemUser(), SeasonType.getSeasonTypeByDescription("season softcore"),
                new BigDecimal(250999000), "active", "WTS", ItemType.RUNE);
    }

    public Item(ItemDTradeResponse itemDTradeResponse) {
        this(
                itemDTradeResponse.id(),
                itemDTradeResponse.name(),
                itemDTradeResponse.quantity(),
                new ItemUser(),
                SeasonType.getSeasonTypeByDescription(itemDTradeResponse.seasonTypeDescription()),
                itemDTradeResponse.price(),
                itemDTradeResponse.status(),
                itemDTradeResponse.requestType(),
                ItemType.getItemTypeByName(itemDTradeResponse.itemType())
        );
    }
}
