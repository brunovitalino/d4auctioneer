package com.bvlabs.d4auctioneer.dtrade.item.application.port.in;

import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;

import java.math.BigDecimal;
import java.util.List;

public interface SearchDTradeInputPort {
    List<ItemDTrade> search(Integer pageNumber, String seasonType, String searchType,
            String runeName, BigDecimal minAcceptableValue);
}
