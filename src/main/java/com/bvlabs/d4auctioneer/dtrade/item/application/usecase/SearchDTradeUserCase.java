package com.bvlabs.d4auctioneer.dtrade.item.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.SearchDTradeInputPort;
import com.bvlabs.d4auctioneer.dtrade.item.application.port.out.SearchDTradeClientPort;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SearchDTradeUserCase implements SearchDTradeInputPort {

    private final SearchDTradeClientPort searchDTradeClientPort;

    public SearchDTradeUserCase(SearchDTradeClientPort searchDTradeClientPort) {
        this.searchDTradeClientPort = searchDTradeClientPort;
    }

    @Override
    public List<ItemDTrade> search(Integer pageNumber, String seasonType, String searchType,
            String runeName, BigDecimal minAcceptableValue) {
        return searchDTradeClientPort.search(pageNumber, seasonType, searchType, runeName, minAcceptableValue);
    }
}
