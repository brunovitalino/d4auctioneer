package com.bvlabs.d4auctioneer.dtrade.item.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.FindItemDTradeInputPort;
import com.bvlabs.d4auctioneer.dtrade.item.application.port.out.ItemDTradeClientOutPort;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import org.springframework.stereotype.Service;

@Service
public class FindItemDTradeUserCase implements FindItemDTradeInputPort {

    private final ItemDTradeClientOutPort itemDTradeClientOutPort;

    public FindItemDTradeUserCase(ItemDTradeClientOutPort itemDTradeClientOutPort) {
        this.itemDTradeClientOutPort = itemDTradeClientOutPort;
    }

    @Override
    public ItemDTrade findById(String id) {
        return itemDTradeClientOutPort.findById(id);
    }
}
