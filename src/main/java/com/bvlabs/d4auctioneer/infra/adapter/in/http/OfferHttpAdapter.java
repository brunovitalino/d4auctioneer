package com.bvlabs.d4auctioneer.infra.adapter.in.http;

import com.bvlabs.d4auctioneer.application.port.in.offer.GetOffersInputPort;
import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersRequest;
import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/offers")
public class OfferHttpAdapter {

    private final GetOffersInputPort getOffersInputPort;

    public OfferHttpAdapter(GetOffersInputPort getOffersInputPort) {
        this.getOffersInputPort = getOffersInputPort;
    }

    @GetMapping()
    @Parameters({
            @Parameter(ref = "#/components/parameters/x-d4trade-token")
    })
    @Operation(summary = "Get the number of sellers with the minimum acceptable value.")
    public ResponseEntity<GetOffersResponse> read(
            @Parameter(name = "pageNumber", description = "Marketplace Page Number", example = "1") @RequestParam Integer pageNumber,
            @Parameter(name = "seasonType", description = "Season Type: softcore or hardcore", example = "softcore") @RequestParam String seasonType,
            @Parameter(name = "transactionType", description = "Search Type: selling or buying", example = "selling") @RequestParam String transactionType,
            @Parameter(name = "searchType", description = "Desired rune names to search", example = "Vex,Kaa") @RequestParam String runeNames,
            @Parameter(name = "minAcceptableValue", description = "Offers with that minimum value will be excluded", example = "200000000") @RequestParam BigDecimal minAcceptableValue,
            @Parameter(name = "desirableValue", description = "Your Desirable Value To Sell or Buy", example = "300000000") @RequestParam BigDecimal desirableValue) {
        var getOffersRequest = new GetOffersRequest(pageNumber, seasonType, transactionType, runeNames, minAcceptableValue, desirableValue);
        var response = getOffersInputPort.getOffersForDesirableValue(getOffersRequest);
        return ResponseEntity.ok(response);
    }
}
