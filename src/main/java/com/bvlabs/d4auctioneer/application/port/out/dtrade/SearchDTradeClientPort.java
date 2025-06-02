package com.bvlabs.d4auctioneer.application.port.out.dtrade;

import com.bvlabs.d4auctioneer.domain.model.item.SeasonType;
import com.bvlabs.d4auctioneer.domain.model.item.TransactionType;
import com.bvlabs.d4auctioneer.infra.dto.dtrade.ItemDTradeResponse;

import java.math.BigDecimal;
import java.util.List;

public interface SearchDTradeClientPort {
    List<ItemDTradeResponse> search(Integer pageNumber, SeasonType seasonType, TransactionType transactionType,
                                    String runeName, BigDecimal minAcceptableValue);
}
