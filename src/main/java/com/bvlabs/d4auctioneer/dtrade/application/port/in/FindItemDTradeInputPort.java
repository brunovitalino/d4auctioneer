package com.bvlabs.d4auctioneer.dtrade.application.port.in;

import com.bvlabs.d4auctioneer.dtrade.domain.model.ItemDTrade;

public interface FindItemDTradeInputPort {
    ItemDTrade findById(String id);
}
