package com.bvlabs.d4auctioneer.offer.domain.model;

import com.bvlabs.d4auctioneer.dtrade.item.application.port.in.SearchDTradeInputPort;
import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import com.bvlabs.d4auctioneer.offer.application.usecase.GetOffersUserCase;
import com.bvlabs.d4auctioneer.offer.application.usercase.OfferBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetOffersUserCaseTest {

    @Mock
    SearchDTradeInputPort searchDTradeInputPort;

    @InjectMocks
    GetOffersUserCase getOffersUserCase;

    @Test
    void shouldGetValidOffersUserCase() {
        var request = new GetOffersRequestBuilder()
                .withPageNumber(1)
                .withSeasonType("softcore")
                .withSearchType("selling")
                .withRuneNames("Vex,Kaa")
                .withMinAcceptableValue(BigDecimal.valueOf(200000000))
                .withDesirableValue(BigDecimal.valueOf(300000000))
                .build();

        var offerVex = new OfferBuilder()
                .withRuneName("Vex")
                .withDesirableValue(BigDecimal.valueOf(1222))
                .withDesirableValueWithLessThanOrEqualOffer(1)
                .withOtherValuesWithOffers(3)
                .withItemType(ItemType.Consumable)
                .build();
        var offerKaa = new OfferBuilder()
                .withRuneName("Kaa")
                .withDesirableValue(BigDecimal.valueOf(1222))
                .withDesirableValueWithLessThanOrEqualOffer(1)
                .withOtherValuesWithOffers(3)
                .withItemType(ItemType.Consumable)
                .build();

        var vexItemDTradeList = Arrays.asList(
                new ItemDTrade("11", offerVex.runeName(), 1),
                new ItemDTrade("12", offerVex.runeName(), 1)
        );
        var kaaItemDTradeList = Arrays.asList(
                new ItemDTrade("21", offerKaa.runeName(), 1),
                new ItemDTrade("22", offerKaa.runeName(), 1)
        );

        when(searchDTradeInputPort.search(request.pageNumber(), request.seasonType(), request.searchType(),
                offerVex.runeName(), request.minAcceptableValue())).thenReturn(vexItemDTradeList);

        when(searchDTradeInputPort.search(request.pageNumber(), request.seasonType(), request.searchType(),
                offerKaa.runeName(), request.minAcceptableValue())).thenReturn(kaaItemDTradeList);

        getOffersUserCase.getOffersForDesirableValue(request);

        verify(searchDTradeInputPort, times(2)).search(anyInt(), anyString(), anyString(), anyString(), any());
    }
}
