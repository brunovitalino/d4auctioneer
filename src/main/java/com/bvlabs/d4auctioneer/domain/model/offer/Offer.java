package com.bvlabs.d4auctioneer.domain.model.offer;

import com.bvlabs.d4auctioneer.domain.model.item.ItemCategory;

import java.math.BigDecimal;

public record Offer(
        String runeName,
        BigDecimal desirableValue,
        Integer desirableValueWithLessThanOrEqualOffer,
        Integer otherValuesWithOffers,
        ItemCategory itemCategory
) {
}
