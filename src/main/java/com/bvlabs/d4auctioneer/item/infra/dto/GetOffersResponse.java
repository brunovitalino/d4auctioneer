package com.bvlabs.d4auctioneer.item.infra.dto;

import com.bvlabs.d4auctioneer.dtrade.item.domain.model.ItemDTrade;
import com.bvlabs.d4auctioneer.item.domain.model.ItemType;
import com.bvlabs.d4auctioneer.item.domain.model.Offer;

import java.math.BigDecimal;
import java.util.List;

public record GetOffersResponse(
        List<Offer> offers
) {
}
