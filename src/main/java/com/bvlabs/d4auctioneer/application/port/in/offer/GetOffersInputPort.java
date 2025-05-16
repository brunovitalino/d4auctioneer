package com.bvlabs.d4auctioneer.application.port.in.offer;

import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersRequest;
import com.bvlabs.d4auctioneer.infra.dto.offer.GetOffersResponse;

public interface GetOffersInputPort {
    public GetOffersResponse getOffersForDesirableValue(GetOffersRequest request);
}
