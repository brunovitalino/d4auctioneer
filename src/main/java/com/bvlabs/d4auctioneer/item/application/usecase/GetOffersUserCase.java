package com.bvlabs.d4auctioneer.item.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.SearchDTradeInputPort;
import com.bvlabs.d4auctioneer.item.domain.model.Offer;
import com.bvlabs.d4auctioneer.item.application.port.in.GetOffersInputPort;
import com.bvlabs.d4auctioneer.item.domain.model.ItemType;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GetOffersUserCase implements GetOffersInputPort {

    private final SearchDTradeInputPort searchDTradeInputPort;

    public GetOffersUserCase(SearchDTradeInputPort searchDTradeInputPort) {
        this.searchDTradeInputPort = searchDTradeInputPort;
    }

    @Override
    public GetOffersResponse getOffersForDesirableValue(GetOffersRequest request) {
        var runeNames = Arrays.stream(request.runeNames().split(",")).map(String::trim).collect(Collectors.toSet());
        List<Offer> offers = getAllOffersForEachRune(runeNames, request);
        return new GetOffersResponse(offers);
    }

    private List<Offer> getAllOffersForEachRune(Set<String> runeNames, GetOffersRequest request) {
        List<Offer> offers = new ArrayList<>();
        for (String runeName : runeNames) {
            var runeItemDTradeList = searchDTradeInputPort.search(request.pageNumber(), request.seasonType(), request.searchType(),
                runeName, request.minAcceptableValue());
            delay(500);

            if (runeItemDTradeList.isEmpty()) continue;

            var desirableValueWithLessThanOrEqualOffer = (int) runeItemDTradeList.stream()
                    .filter(itemDTrade -> itemDTrade.price().compareTo(request.desirableValue()) <= 0).count();
            var otherValuesWithOffers = (int) runeItemDTradeList.stream()
                    .filter(itemDTrade -> itemDTrade.price().compareTo(request.desirableValue()) > 0).count();

            offers.add(new Offer(runeName, request.desirableValue(), desirableValueWithLessThanOrEqualOffer, otherValuesWithOffers, ItemType.Consumable));
        }
        return offers;
    }

    private static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during sleep", e);
        }
    }
}
