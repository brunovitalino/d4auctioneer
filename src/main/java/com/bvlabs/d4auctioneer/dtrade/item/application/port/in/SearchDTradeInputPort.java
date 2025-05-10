package com.bvlabs.d4auctioneer.dtrade.item.application.port.in;

import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;

import java.util.List;

public interface SearchDTradeInputPort {
    List<ItemDTrade> search(Integer pageNumber, String seasonType, String runeName);
}
