package com.bvlabs.d4auctioneer.dtrade.item.infra.adapter.client;

import com.bvlabs.d4auctioneer.common.config.FeignClientConfig;
import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeListResponse;
import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "itemDTradeClient", url = "https://diablo.trade/api/items", configuration = FeignClientConfig.class)
public interface ItemDTradeFeignClient {
    @GetMapping("/search")
    ItemDTradeListResponse search();
}
