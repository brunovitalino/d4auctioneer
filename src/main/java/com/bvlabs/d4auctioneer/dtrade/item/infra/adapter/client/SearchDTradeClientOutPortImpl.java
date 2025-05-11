package com.bvlabs.d4auctioneer.dtrade.item.infra.adapter.client;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.out.SearchDTradeClientOutPort;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.OfferType;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.SeasonType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SearchDTradeClientOutPortImpl implements SearchDTradeClientOutPort {

    private final DTradeFeignClient dTradeFeignClient;

    public SearchDTradeClientOutPortImpl(DTradeFeignClient dTradeFeignClient) {
        this.dTradeFeignClient = dTradeFeignClient;
    }

    @Override
    public List<ItemDTrade> search(Integer pageNumber, String seasonTypeDescription, String searchType,
            String runeName, BigDecimal minAcceptableValue) {
        var seasonType = SeasonType.getSeasonTypeByDescription(seasonTypeDescription);
        var offerType = OfferType.getOfferTypeByName(searchType);
        var itemDTradeListResponse = dTradeFeignClient.search(pageNumber, seasonType.getDescription(), offerType.getSearchType(),
                runeName, minAcceptableValue);
        return itemDTradeListResponse.data().stream().map(ItemDTrade::new).toList();
    }
}
