package com.bvlabs.d4auctioneer.item.application.port.out;

import com.bvlabs.d4auctioneer.item.domain.model.Item;

public interface ItemRepositoryOutPort {
    Item save(Item item);
}
