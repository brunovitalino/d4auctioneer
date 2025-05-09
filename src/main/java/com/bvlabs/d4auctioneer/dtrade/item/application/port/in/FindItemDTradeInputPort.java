package com.bvlabs.d4auctioneer.dtrade.item.application.port.in;

import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;

public interface FindItemDTradeInputPort {
    ItemDTrade findById(String id);
}
