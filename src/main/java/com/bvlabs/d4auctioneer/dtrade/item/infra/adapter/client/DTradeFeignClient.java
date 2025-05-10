package com.bvlabs.d4auctioneer.dtrade.item.infra.adapter.client;

import com.bvlabs.d4auctioneer.common.config.FeignClientConfig;
import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "itemDTradeClient", url = "${feign.dtrade.api.url}", configuration = FeignClientConfig.class)
public interface DTradeFeignClient {
    //@GetMapping("/search?cursor={pageNumber}&mode={seasonTypeDescription}&type=WTB&rune={runeName}&price=1000000,99999999999&sort=lowest")
    @GetMapping("/search?cursor={pageNumber}&mode={seasonTypeDescription}&price=1000000%2C99999999999&rune={runeName}&sort=lowest&type=WTB")
    ItemDTradeListResponse search(@RequestParam Integer pageNumber, @RequestParam String seasonTypeDescription, @RequestParam String runeName);
}
