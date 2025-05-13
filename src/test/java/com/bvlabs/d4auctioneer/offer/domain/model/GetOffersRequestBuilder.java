package com.bvlabs.d4auctioneer.offer.domain.model;

import com.bvlabs.d4auctioneer.offer.infra.dto.GetOffersRequest;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class GetOffersRequestBuilder {
    private Integer pageNumber;
    private String seasonType;
    private String searchType;
    private String runeNames;
    private BigDecimal minAcceptableValue;
    private BigDecimal desirableValue;

    public GetOffersRequestBuilder withPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public GetOffersRequestBuilder withSeasonType(String seasonType) {
        this.seasonType = seasonType;
        return this;
    }

    public GetOffersRequestBuilder withSearchType(String searchType) {
        this.searchType = searchType;
        return this;
    }

    public GetOffersRequestBuilder withRuneNames(String runeNames) {
        this.runeNames = runeNames;
        return this;
    }

    public GetOffersRequestBuilder withMinAcceptableValue(BigDecimal minAcceptableValue) {
        this.minAcceptableValue = minAcceptableValue;
        return this;
    }

    public GetOffersRequestBuilder withDesirableValue(BigDecimal desirableValue) {
        this.desirableValue = desirableValue;
        return this;
    }

    public GetOffersRequest build() {
        return new GetOffersRequest(this.pageNumber, this.seasonType, this.searchType, this.runeNames,
                this.minAcceptableValue, this.desirableValue);
    }
}
