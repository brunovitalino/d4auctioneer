package com.bvlabs.d4auctioneer.offer.application.usercase;

import com.bvlabs.d4auctioneer.offer.domain.model.ItemType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

public class OfferTest {

    @Test
    void shouldCountValidOffers() {
        var offer = new OfferBuilder()
                .withRuneName("Kaa")
                .withDesirableValue(BigDecimal.valueOf(1222))
                .withDesirableValueWithLessThanOrEqualOffer(1)
                .withOtherValuesWithOffers(3)
                .withItemType(ItemType.Consumable)
                .build();

        assertThat(offer.runeName()).isEqualTo("Kaa");
    }
}
