package com.bvlabs.d4auctioneer.item.application.usecase;

import com.bvlabs.d4auctioneer.dtrade.application.port.in.FindItemDTradeInputPort;
import com.bvlabs.d4auctioneer.dtrade.domain.model.ItemDTrade;
import com.bvlabs.d4auctioneer.item.application.port.in.CreateItemInputPort;
import com.bvlabs.d4auctioneer.item.application.port.out.ItemRepositoryOutPort;
import com.bvlabs.d4auctioneer.item.domain.model.Item;
import com.bvlabs.d4auctioneer.item.domain.model.ItemType;
import com.bvlabs.d4auctioneer.item.infra.dto.CreateItemRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.CreateItemResponse;
import org.springframework.stereotype.Service;

@Service
public class CreateItemUserCase implements CreateItemInputPort {

    private final FindItemDTradeInputPort findItemDTradeInputPort;
    private final ItemRepositoryOutPort itemRepositoryOutPort;

    public CreateItemUserCase(FindItemDTradeInputPort findItemDTradeInputPort, ItemRepositoryOutPort itemRepositoryOutPort) {
        this.findItemDTradeInputPort = findItemDTradeInputPort;
        this.itemRepositoryOutPort = itemRepositoryOutPort;
    }

    @Override
    public CreateItemResponse createItem(CreateItemRequest request) {

        ItemDTrade itemDTrade = findItemDTradeInputPort.findById(request.itemDTradeId());

        if (itemDTrade == null) {
            throw new RuntimeException("DTrade Item not found");
        }

        var item = new Item(null, itemDTrade.name(), ItemType.Consumable, "CREATED");
        var savedItem = itemRepositoryOutPort.save(item);

        return new CreateItemResponse(savedItem.id(), itemDTrade, savedItem.status());
    }
}
