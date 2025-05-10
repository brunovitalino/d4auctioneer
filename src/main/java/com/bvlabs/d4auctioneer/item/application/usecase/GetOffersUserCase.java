package com.bvlabs.d4auctioneer.item.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.SearchDTradeInputPort;
import com.bvlabs.d4auctioneer.item.domain.model.Offer;
import com.bvlabs.d4auctioneer.item.application.port.in.GetOffersInputPort;
import com.bvlabs.d4auctioneer.item.domain.model.ItemType;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetOffersUserCase implements GetOffersInputPort {

    private final SearchDTradeInputPort searchDTradeInputPort;

    public GetOffersUserCase(SearchDTradeInputPort searchDTradeInputPort) {
        this.searchDTradeInputPort = searchDTradeInputPort;
    }

    @Override
    public GetOffersResponse getOffers(GetOffersRequest request) {

        var runeNames = Arrays.stream(request.runeNames().split(",")).map(String::trim).collect(Collectors.toSet());

        List<Offer> offers = new ArrayList<>();
        for (String runeName : runeNames) {
            var runeItemDTradeList = searchDTradeInputPort.search(request.pageNumber(), request.seasonType(), runeName);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted during sleep", e);
            }

            if (runeItemDTradeList.isEmpty()) continue;

            var desirableValueWithLessThanOrEqualOffer = (int) runeItemDTradeList.stream()
                    .filter(itemDTrade -> itemDTrade.price().compareTo(request.desirableValue()) <= 0).count();
            var otherValuesWithOffers = (int) runeItemDTradeList.stream()
                    .filter(itemDTrade -> itemDTrade.price().compareTo(request.desirableValue()) > 0).count();

            offers.add(new Offer(runeName, request.desirableValue(), desirableValueWithLessThanOrEqualOffer, otherValuesWithOffers, ItemType.Consumable));
        }

        return new GetOffersResponse(offers);
    }
}
