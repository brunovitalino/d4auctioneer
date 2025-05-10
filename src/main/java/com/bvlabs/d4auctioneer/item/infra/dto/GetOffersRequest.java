package com.bvlabs.d4auctioneer.item.infra.dto;

import com.bvlabs.d4auctioneer.item.domain.model.ItemType;

import java.math.BigDecimal;

public record GetOffersRequest(
        Integer pageNumber,
        String seasonType,
        String runeNames,
        BigDecimal minAcceptableValue,
        BigDecimal desirableValue,
        Integer desirableValueWithOffersAlreadyCount,
        Integer otherValuesWithOffersCount
) {
}
