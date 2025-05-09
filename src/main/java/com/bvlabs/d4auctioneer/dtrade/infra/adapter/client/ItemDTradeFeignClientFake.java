package com.bvlabs.d4auctioneer.dtrade.infra.adapter.client;

import com.bvlabs.d4auctioneer.dtrade.infra.dto.ItemDTradeResponse;
import org.springframework.stereotype.Service;

@Service
public class ItemDTradeFeignClientFake implements ItemDTradeFeignClient {
    @Override
    public ItemDTradeResponse findById(String itemDTradeId) {
        return new ItemDTradeResponse("1abc", "Bac", 3);
    }
}
