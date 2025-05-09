package com.bvlabs.d4auctioneer.item.application.port.out;

import com.bvlabs.d4auctioneer.item.domain.model.Item;
import com.bvlabs.d4auctioneer.item.domain.model.ItemType;
import org.springframework.stereotype.Service;

@Service
public class ItemRepositoryOutPortFake implements ItemRepositoryOutPort {
    @Override
    public Item save(Item item) {
        return new Item(1L, item.itemDTradeId(), item.itemType(), item.status());
    }
}
