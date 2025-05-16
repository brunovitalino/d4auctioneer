package com.bvlabs.d4auctioneer.application.port.in.item;

import com.bvlabs.d4auctioneer.domain.model.item.Item;
import com.bvlabs.d4auctioneer.domain.model.item.SeasonType;
import com.bvlabs.d4auctioneer.domain.model.item.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public interface SearchItemInputPort {
    List<Item> search(Integer pageNumber, SeasonType seasonType, TransactionType transactionType,
                      String runeName, BigDecimal minAcceptableValue);
}
