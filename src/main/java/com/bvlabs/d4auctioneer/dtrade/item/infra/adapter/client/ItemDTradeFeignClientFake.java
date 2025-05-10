package com.bvlabs.d4auctioneer.dtrade.item.infra.adapter.client;

import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeResponse;
import org.springframework.stereotype.Service;

public class ItemDTradeFeignClientFake {
    //@Override
    public ItemDTradeResponse findById(String itemDTradeId) {
        return new ItemDTradeResponse("1abc", "Bac", 3);
    }
}
