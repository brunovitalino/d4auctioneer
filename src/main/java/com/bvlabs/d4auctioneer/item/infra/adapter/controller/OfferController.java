package com.bvlabs.d4auctioneer.item.infra.adapter.controller;

import com.bvlabs.d4auctioneer.item.application.port.in.GetOffersInputPort;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final GetOffersInputPort getOffersInputPort;

    public OfferController(GetOffersInputPort getOffersInputPort) {
        this.getOffersInputPort = getOffersInputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> readItem(@PathVariable Long id) {
        return ResponseEntity.ok("Searched item: " + id);
    }

    @PostMapping()
    public ResponseEntity<GetOffersResponse> createItem(@RequestBody GetOffersRequest getOffersRequest) {
        var response = getOffersInputPort.getOffers(getOffersRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
