package com.bvlabs.d4auctioneer.item.application.port.in;

import com.bvlabs.d4auctioneer.item.infra.dto.CreateItemRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.CreateItemResponse;

public interface CreateItemInputPort {
    public CreateItemResponse createItem(CreateItemRequest request);
}
