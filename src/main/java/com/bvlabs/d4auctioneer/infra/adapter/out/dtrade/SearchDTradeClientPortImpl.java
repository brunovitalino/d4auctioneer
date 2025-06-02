package com.bvlabs.d4auctioneer.infra.adapter.out.dtrade;

import com.bvlabs.d4auctioneer.application.port.out.dtrade.SearchDTradeClientPort;
import com.bvlabs.d4auctioneer.domain.model.item.SeasonType;
import com.bvlabs.d4auctioneer.domain.model.item.TransactionType;
import com.bvlabs.d4auctioneer.infra.adapter.out.dtrade.feign.client.DTradeFeignClient;
import com.bvlabs.d4auctioneer.infra.dto.dtrade.ItemDTradeResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SearchDTradeClientPortImpl implements SearchDTradeClientPort {

    private final DTradeFeignClient dTradeFeignClient;

    public SearchDTradeClientPortImpl(DTradeFeignClient dTradeFeignClient) {
        this.dTradeFeignClient = dTradeFeignClient;
    }

    @Override
    public List<ItemDTradeResponse> search(Integer pageNumber, SeasonType seasonType, TransactionType transactionType,
                                           String runeName, BigDecimal minAcceptableValue) {

        var itemDTradeListResponse = dTradeFeignClient.search(pageNumber, seasonType.getDescription(),
                transactionType.getDescription(), runeName, minAcceptableValue);
        return itemDTradeListResponse.data();
    }

}
