package com.bvlabs.d4auctioneer.offer.application.port.in;

import com.bvlabs.d4auctioneer.offer.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.offer.infra.dto.GetOffersResponse;

public interface GetOffersInputPort {
    public GetOffersResponse getOffersForDesirableValue(GetOffersRequest request);
}
