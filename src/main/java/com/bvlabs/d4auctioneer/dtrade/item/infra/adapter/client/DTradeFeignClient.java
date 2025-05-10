package com.bvlabs.d4auctioneer.dtrade.item.infra.adapter.client;

import com.bvlabs.d4auctioneer.common.config.FeignClientConfig;
import com.bvlabs.d4auctioneer.dtrade.item.infra.dto.ItemDTradeListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "itemDTradeClient", url = "${feign.dtrade.api.url}", configuration = FeignClientConfig.class)
public interface DTradeFeignClient {
    @GetMapping("/search?cursor={pageNumber}&mode={seasonTypeDescription}&type=WTB&sort=lowest" +
            "&rune={runeName}&price={minAcceptableValue}%2C99999999999")
    ItemDTradeListResponse search(@RequestParam Integer pageNumber, @RequestParam String seasonTypeDescription,
                                  @RequestParam String runeName, @RequestParam BigDecimal minAcceptableValue);
}
