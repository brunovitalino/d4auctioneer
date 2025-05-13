package com.bvlabs.d4auctioneer.offer.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.SearchDTradeInputPort;
import com.bvlabs.d4auctioneer.offer.domain.model.Offer;
import com.bvlabs.d4auctioneer.offer.application.port.in.GetOffersInputPort;
import com.bvlabs.d4auctioneer.offer.domain.model.ItemType;
import com.bvlabs.d4auctioneer.offer.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.offer.infra.dto.GetOffersResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class GetOffersUserCase implements GetOffersInputPort {

    private final SearchDTradeInputPort searchDTradeInputPort;

    public GetOffersUserCase(SearchDTradeInputPort searchDTradeInputPort) {
        this.searchDTradeInputPort = searchDTradeInputPort;
    }

    @Override
    public GetOffersResponse getOffersForDesirableValue(GetOffersRequest request) {
        List<Offer> offers = getAllOffersForEachRune(request);
        return new GetOffersResponse(offers);
    }

    private List<Offer> getAllOffersForEachRune(GetOffersRequest request) {
        List<Offer> offers = new ArrayList<>();
        for (String runeName : getRuneNames(request)) {
            var runeItemDTradeList = searchDTradeInputPort.search(request.pageNumber(), request.seasonType(),
                    request.searchType(), runeName, request.minAcceptableValue());
            delay();

            if (runeItemDTradeList.isEmpty()) continue;

            var desirableValueWithLessThanOrEqualOffer = (int) runeItemDTradeList.stream()
                    .filter(itemDTrade -> itemDTrade.price().compareTo(request.desirableValue()) <= 0).count();
            var otherValuesWithOffers = runeItemDTradeList.size() - desirableValueWithLessThanOrEqualOffer;

            offers.add(new Offer(runeName, request.desirableValue(), desirableValueWithLessThanOrEqualOffer, otherValuesWithOffers, ItemType.Consumable));
        }
        return offers;
    }

    private static Set<String> getRuneNames(GetOffersRequest request) {
        return Arrays.stream(request.runeNames().split(",")).map(String::trim).collect(Collectors.toSet());
    }

    private static void delay() {
        try {
            int timeMillis = ThreadLocalRandom.current().nextInt(500, 1001);
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during sleep", e);
        }
    }
}
