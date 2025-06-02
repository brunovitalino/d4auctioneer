package com.bvlabs.d4auctioneer.application.usecase.offer;

import com.bvlabs.d4auctioneer.application.port.in.offer.GetOffersInputPort;
import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GoodTimeToSellUseCase {

    private final GetOffersInputPort getOffersInputPort;
    private Integer i = 0;

    public GoodTimeToSellUseCase(GetOffersInputPort getOffersInputPort) {
        this.getOffersInputPort = getOffersInputPort;
    }

    public void checkAndWarnGoodTimeToSell() {
        var pageNumber = 1;
        var seasonType = "softcore";
        var transactionType = "selling";
        var runeNames = "Vex,Kaa";
        var minAcceptableValue = new BigDecimal("19000000");
        var desirableValue = new BigDecimal("300000000");
        var getOffersRequest = new GetOffersRequest(pageNumber, seasonType, transactionType, runeNames, minAcceptableValue, desirableValue);
        System.out.println("called " + ++i);

        //var offersForDesirableValue = getOffersInputPort.getOffersForDesirableValue(getOffersRequest);

    }

}
