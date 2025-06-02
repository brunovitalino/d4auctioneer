package com.bvlabs.d4auctioneer.infra.adapter.out.dtrade.feign.client;

import com.bvlabs.d4auctioneer.infra.adapter.out.dtrade.feign.config.FeignClientConfig;
import com.bvlabs.d4auctioneer.infra.dto.dtrade.ItemDTradeListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "itemDTradeClient", url = "${feign.dtrade.api.url}", configuration = FeignClientConfig.class)
public interface DTradeFeignClient {
    @GetMapping("/items/search?cursor={pageNumber}&mode={seasonTypeDescription}&type={offerType}&sort=lowest" +
            "&rune={runeName}&price={minAcceptableValue}%2C99999999999")
    //@GetMapping("/items/search?cursor=1&mode=season%20softcore&rune=Bac&sort=lowest&type=WTB")
    ItemDTradeListResponse search(@RequestParam Integer pageNumber, @RequestParam String seasonTypeDescription, @RequestParam String offerType,
                                  @RequestParam String runeName, @RequestParam BigDecimal minAcceptableValue);
}
