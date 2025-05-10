package com.bvlabs.d4auctioneer.dtrade.item.infra.adapter.client;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.out.ItemDTradeClientOutPort;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeListResponse;
import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeResponse;
import org.springframework.stereotype.Component;

@Component
public class ItemDTradeClientOutPortImpl implements ItemDTradeClientOutPort {

    private final ItemDTradeFeignClient itemDTradeFeignClient;

    public ItemDTradeClientOutPortImpl(ItemDTradeFeignClient itemDTradeFeignClient) {
        this.itemDTradeFeignClient = itemDTradeFeignClient;
    }

    @Override
    public ItemDTrade findById(String id) {
        var itemDTradeListResponse = itemDTradeFeignClient.search();
        var itemDTradeResponse = itemDTradeListResponse.data().getFirst();
        return new ItemDTrade(itemDTradeResponse.id(), itemDTradeResponse.name(), itemDTradeResponse.quantity());
    }
}
