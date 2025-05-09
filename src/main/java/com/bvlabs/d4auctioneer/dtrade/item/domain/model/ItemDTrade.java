package com.bvlabs.d4auctioneer.dtrade.item.domain.model;

import com.bvlabs.d4auctioneer.dtrade.user.domain.model.UserDTrade;

import java.math.BigDecimal;

public record ItemDTrade(
        String id,
        String name,
        Integer quantity,
        UserDTrade userDTrade,
        String mode,        // "season softcore",
        BigDecimal price,   // 250000000,
        String status,      // "active",
        String requestType, // "WTS",
        String itemType    // "rune",
        //expiresAt "2025-05-10T19:51:13.765Z",
        //createdAt "2025-05-08T19:51:13.766Z",
        //updatedAt "2025-05-08T19:51:13.766Z",
) {

    public ItemDTrade(String id, String name, Integer quantity) {
        this(id, name, quantity, new UserDTrade(), "season softcore", new BigDecimal(250999000),
                "active", "WTS", "rune");
    }
}
