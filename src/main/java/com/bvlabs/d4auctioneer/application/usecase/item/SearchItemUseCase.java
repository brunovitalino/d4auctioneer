package com.bvlabs.d4auctioneer.application.usecase.item;

import com.bvlabs.d4auctioneer.application.port.in.item.SearchItemInputPort;
import com.bvlabs.d4auctioneer.application.port.out.dtrade.SearchDTradeClientPort;
import com.bvlabs.d4auctioneer.domain.model.item.Item;
import com.bvlabs.d4auctioneer.domain.model.item.SeasonType;
import com.bvlabs.d4auctioneer.domain.model.item.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SearchItemUseCase implements SearchItemInputPort {

    private final SearchDTradeClientPort searchDTradeClientPort;

    public SearchItemUseCase(SearchDTradeClientPort searchDTradeClientPort) {
        this.searchDTradeClientPort = searchDTradeClientPort;
    }

    @Override
    public List<Item> search(Integer pageNumber, SeasonType seasonType, TransactionType transactionType,
                             String runeName, BigDecimal minAcceptableValue) {

        return searchDTradeClientPort.search(pageNumber, seasonType, transactionType, runeName, minAcceptableValue)
                .stream().map(Item::new).toList();
    }

}
