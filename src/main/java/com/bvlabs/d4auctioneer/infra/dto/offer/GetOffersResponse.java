package com.bvlabs.d4auctioneer.infra.dto.offer;

import com.bvlabs.d4auctioneer.domain.model.offer.Offer;

import java.util.List;

public record GetOffersResponse(
        List<Offer> offers
) {
}
