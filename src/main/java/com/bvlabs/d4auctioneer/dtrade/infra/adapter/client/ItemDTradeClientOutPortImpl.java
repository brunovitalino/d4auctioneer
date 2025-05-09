package com.bvlabs.d4auctioneer.dtrade.infra.adapter.client;

import com.bvlabs.d4auctioneer.dtrade.application.port.out.ItemDTradeClientOutPort;
import com.bvlabs.d4auctioneer.dtrade.domain.model.ItemDTrade;
import com.bvlabs.d4auctioneer.dtrade.infra.dto.ItemDTradeResponse;
import org.springframework.stereotype.Component;

@Component
public class ItemDTradeClientOutPortImpl implements ItemDTradeClientOutPort {

    private final ItemDTradeFeignClient itemDTradeFeignClient;

    public ItemDTradeClientOutPortImpl(ItemDTradeFeignClient itemDTradeFeignClient) {
        this.itemDTradeFeignClient = itemDTradeFeignClient;
    }

    @Override
    public ItemDTrade findById(String id) {
        ItemDTradeResponse itemDTradeResponse = itemDTradeFeignClient.findById(id);
        return new ItemDTrade(itemDTradeResponse.id(), itemDTradeResponse.name(), itemDTradeResponse.quantity());
    }
}
