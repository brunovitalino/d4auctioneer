package com.bvlabs.d4auctioneer.item.domain.model;

import java.math.BigDecimal;

public record Offer(
        String runeName,
        BigDecimal desirableValue,
        Integer desirableValueWithLessThanOrEqualOffer,
        Integer otherValuesWithOffers,
        ItemType itemType
) {
}
