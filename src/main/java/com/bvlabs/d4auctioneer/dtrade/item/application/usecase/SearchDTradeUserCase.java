package com.bvlabs.d4auctioneer.dtrade.item.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.SearchDTradeInputPort;
import com.bvlabs.d4auctioneer.dtrade.item.application.port.out.SearchDTradeClientOutPort;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchDTradeUserCase implements SearchDTradeInputPort {

    private final SearchDTradeClientOutPort searchDTradeClientOutPort;

    public SearchDTradeUserCase(SearchDTradeClientOutPort searchDTradeClientOutPort) {
        this.searchDTradeClientOutPort = searchDTradeClientOutPort;
    }

    @Override
    public List<ItemDTrade> search(Integer pageNumber, String seasonType, String runeName) {
        return searchDTradeClientOutPort.search(pageNumber, seasonType, runeName);
    }
}
