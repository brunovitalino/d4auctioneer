package com.bvlabs.d4auctioneer.dtrade.application.port.out;

import com.bvlabs.d4auctioneer.dtrade.domain.model.ItemDTrade;

public interface ItemDTradeClientOutPort {
    ItemDTrade findById(String id);
}
