package com.bvlabs.d4auctioneer.offer.domain.model;

import com.bvlabs.d4auctioneer.application.port.in.item.SearchItemInputPort;
import com.bvlabs.d4auctioneer.application.usecase.offer.GetOffersUseCase;
import com.bvlabs.d4auctioneer.domain.model.item.Item;
import com.bvlabs.d4auctioneer.domain.model.item.ItemCategory;
import com.bvlabs.d4auctioneer.domain.model.item.SeasonType;
import com.bvlabs.d4auctioneer.domain.model.item.TransactionType;
import com.bvlabs.d4auctioneer.offer.application.usercase.OfferBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetOffersUseCaseTest {

    @Mock
    SearchItemInputPort searchItemInputPort;

    @InjectMocks
    GetOffersUseCase getOffersUseCase;

    @Test
    void shouldGetValidOffersUserCase() {
        var request = new GetOffersRequestBuilder()
                .withPageNumber(1)
                .withSeasonType(SeasonType.SOFTCORE.getDescription())
                .withSearchType(TransactionType.SELLING.getDescription())
                .withRuneNames("Vex,Kaa")
                .withMinAcceptableValue(BigDecimal.valueOf(200000000))
                .withDesirableValue(BigDecimal.valueOf(300000000))
                .build();

        var offerVex = new OfferBuilder()
                .withRuneName("Vex")
                .withDesirableValue(BigDecimal.valueOf(1222))
                .withDesirableValueWithLessThanOrEqualOffer(1)
                .withOtherValuesWithOffers(3)
                .withItemType(ItemCategory.Consumable)
                .build();
        var offerKaa = new OfferBuilder()
                .withRuneName("Kaa")
                .withDesirableValue(BigDecimal.valueOf(1222))
                .withDesirableValueWithLessThanOrEqualOffer(1)
                .withOtherValuesWithOffers(3)
                .withItemType(ItemCategory.Consumable)
                .build();

        var vexItemDTradeList = Arrays.asList(
                new Item("11", offerVex.runeName(), 1),
                new Item("12", offerVex.runeName(), 1)
        );
        var kaaItemDTradeList = Arrays.asList(
                new Item("21", offerKaa.runeName(), 1),
                new Item("22", offerKaa.runeName(), 1)
        );

        when(searchItemInputPort.search(request.pageNumber(), SeasonType.getSeasonTypeByDescription(request.seasonType()),
                TransactionType.getTransactionTypeByName(request.transactionType()),
                offerVex.runeName(), request.minAcceptableValue())).thenReturn(vexItemDTradeList);

        when(searchItemInputPort.search(request.pageNumber(), SeasonType.getSeasonTypeByDescription(request.seasonType()),
                TransactionType.getTransactionTypeByName(request.transactionType()),
                offerKaa.runeName(), request.minAcceptableValue())).thenReturn(kaaItemDTradeList);

        getOffersUseCase.getOffersForDesirableValue(request);

        verify(searchItemInputPort, times(2)).search(anyInt(), any(), any(), anyString(), any());
    }
}
