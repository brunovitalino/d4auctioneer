package com.bvlabs.d4auctioneer.application.usecase.offer;

import com.bvlabs.d4auctioneer.application.port.in.item.SearchItemInputPort;
import com.bvlabs.d4auctioneer.domain.model.item.ItemCategory;
import com.bvlabs.d4auctioneer.domain.model.item.SeasonType;
import com.bvlabs.d4auctioneer.domain.model.offer.Offer;
import com.bvlabs.d4auctioneer.application.port.in.offer.GetOffersInputPort;
import com.bvlabs.d4auctioneer.domain.model.item.TransactionType;
import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersRequest;
import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class GetOffersUseCase implements GetOffersInputPort {

    private final SearchItemInputPort searchItemInputPort;

    public GetOffersUseCase(SearchItemInputPort searchItemInputPort) {
        this.searchItemInputPort = searchItemInputPort;
    }

    @Override
    public GetOffersResponse getOffersForDesirableValue(GetOffersRequest request) {
        List<Offer> offers = getAllOffersForEachRune(request);
        return new GetOffersResponse(offers);
    }

    private List<Offer> getAllOffersForEachRune(GetOffersRequest request) {
        List<Offer> offers = new ArrayList<>();
        for (String runeName : getRuneNames(request)) {
            var seasonType = SeasonType.getSeasonTypeByDescription(request.seasonType());
            var transactionType = TransactionType.getTransactionTypeByName(request.transactionType());
            var runeItemDTradeList = searchItemInputPort.search(request.pageNumber(), seasonType, transactionType,
                    runeName, request.minAcceptableValue());
            delay();

            if (runeItemDTradeList.isEmpty()) continue;

            var desirableValueWithLessThanOrEqualOffer = runeItemDTradeList.stream()
                    .filter(itemDTrade -> itemDTrade.price().compareTo(request.desirableValue()) <= 0)
                    .reduce(0, (accumulator, item) -> accumulator + item.quantity(), Integer::sum);
            var otherValuesWithOffers = runeItemDTradeList.size() - desirableValueWithLessThanOrEqualOffer;

            offers.add(new Offer(runeName, request.desirableValue(), desirableValueWithLessThanOrEqualOffer, otherValuesWithOffers, ItemCategory.Consumable));
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
