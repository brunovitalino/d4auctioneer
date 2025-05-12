package com.bvlabs.d4auctioneer.item.infra.adapter.controller;

import com.bvlabs.d4auctioneer.item.application.port.in.GetOffersInputPort;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final GetOffersInputPort getOffersInputPort;

    public OfferController(GetOffersInputPort getOffersInputPort) {
        this.getOffersInputPort = getOffersInputPort;
    }

    @GetMapping()
    @Operation(summary = "Get the number of sellers with the minimum acceptable value.")
    public ResponseEntity<GetOffersResponse> read(
            @Parameter(name = "pageNumber", description = "Marketplace Page Number", example = "1") @RequestParam Integer pageNumber,
            @Parameter(name = "seasonType", description = "Season Type: softcore or hardcore", example = "softcore") @RequestParam String seasonType,
            @Parameter(name = "searchType", description = "Search Type: selling or buying", example = "selling") @RequestParam String searchType,
            @Parameter(name = "searchType", description = "Desired rune names to search", example = "Vex,Kaa") @RequestParam String runeNames,
            @Parameter(name = "minAcceptableValue", description = "Offers with that minimum value will be excluded", example = "200000000") @RequestParam BigDecimal minAcceptableValue,
            @Parameter(name = "desirableValue", description = "Your Desirable Value To Sell or Buy", example = "300000000") @RequestParam BigDecimal desirableValue) {
        var getOffersRequest = new GetOffersRequest(pageNumber, seasonType, searchType, runeNames, minAcceptableValue, desirableValue);
        var response = getOffersInputPort.getOffersForDesirableValue(getOffersRequest);
        return ResponseEntity.ok(response);
    }
}
