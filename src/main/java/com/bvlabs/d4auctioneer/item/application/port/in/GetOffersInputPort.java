package com.bvlabs.d4auctioneer.item.application.port.in;

import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersRequest;
import com.bvlabs.d4auctioneer.item.infra.dto.GetOffersResponse;

public interface GetOffersInputPort {
    public GetOffersResponse getOffersForDesirableValue(GetOffersRequest request);
}
