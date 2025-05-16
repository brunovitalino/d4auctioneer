package com.bvlabs.d4auctioneer.offer.application.usercase;

import com.bvlabs.d4auctioneer.domain.model.item.ItemCategory;
import com.bvlabs.d4auctioneer.domain.model.offer.Offer;

import java.math.BigDecimal;

public class OfferBuilder {
    String runeName;
    BigDecimal desirableValue;
    Integer desirableValueWithLessThanOrEqualOffer;
    Integer otherValuesWithOffers;
    ItemCategory itemCategory;

    public OfferBuilder withRuneName(String runeName) {
        this.runeName = runeName;
        return this;
    }

    public OfferBuilder withDesirableValue(BigDecimal desirableValue) {
        this.desirableValue = desirableValue;
        return this;
    }

    public OfferBuilder withDesirableValueWithLessThanOrEqualOffer(Integer desirableValueWithLessThanOrEqualOffer) {
        this.desirableValueWithLessThanOrEqualOffer = desirableValueWithLessThanOrEqualOffer;
        return this;
    }

    public OfferBuilder withOtherValuesWithOffers(Integer otherValuesWithOffers) {
        this.otherValuesWithOffers = otherValuesWithOffers;
        return this;
    }

    public OfferBuilder withItemType(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
        return this;
    }

    public Offer build() {
        return new Offer(this.runeName, this.desirableValue, this.desirableValueWithLessThanOrEqualOffer,
                this.otherValuesWithOffers, this.itemCategory);
    }
}
