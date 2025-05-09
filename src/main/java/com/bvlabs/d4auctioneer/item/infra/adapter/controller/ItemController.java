package com.bvlabs.d4auctioneer.item.infra.adapter.controller;

import com.bvlabs.d4auctioneer.item.application.port.in.CreateItemInputPort;
import com.bvlabs.d4auctioneer.item.infra.dto.CreateItemRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.CreateItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final CreateItemInputPort createItemInputPort;

    public ItemController(CreateItemInputPort createItemInputPort) {
        this.createItemInputPort = createItemInputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> readItem(@PathVariable Long id) {
        return ResponseEntity.ok("Searched item: " + id);
    }

    @PostMapping
    public ResponseEntity<CreateItemResponse> createItem(CreateItemRequest createItemRequest) {
        var response = createItemInputPort.createItem(createItemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
