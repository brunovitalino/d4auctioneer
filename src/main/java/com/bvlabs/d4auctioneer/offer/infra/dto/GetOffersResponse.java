package com.bvlabs.d4auctioneer.offer.infra.dto;

import com.bvlabs.d4auctioneer.offer.domain.model.Offer;

import java.util.List;

public record GetOffersResponse(
        List<Offer> offers
) {
}
