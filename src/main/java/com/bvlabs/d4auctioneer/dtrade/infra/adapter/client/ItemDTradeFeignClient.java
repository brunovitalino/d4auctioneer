package com.bvlabs.d4auctioneer.dtrade.infra.adapter.client;

import com.bvlabs.d4auctioneer.dtrade.infra.dto.ItemDTradeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(itemDTradeId = "itemDTradeClient", url = "${dtrade.api.url}")
public interface ItemDTradeFeignClient {
    //@GetMapping("/xxxx/{id}")
    ItemDTradeResponse findById(@PathVariable String itemDTradeId);
}
