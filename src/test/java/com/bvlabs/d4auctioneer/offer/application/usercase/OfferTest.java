package com.bvlabs.d4auctioneer.offer.application.usercase;

import com.bvlabs.d4auctioneer.domain.model.item.ItemCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferTest {

    @Test
    void shouldCountValidOffers() {
        var offer = new OfferBuilder()
                .withRuneName("Kaa")
                .withDesirableValue(BigDecimal.valueOf(1222))
                .withDesirableValueWithLessThanOrEqualOffer(1)
                .withOtherValuesWithOffers(3)
                .withItemType(ItemCategory.Consumable)
                .build();

        assertThat(offer.runeName()).isEqualTo("Kaa");
    }
}
