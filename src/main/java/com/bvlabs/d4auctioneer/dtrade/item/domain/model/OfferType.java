package com.bvlabs.d4auctioneer.dtrade.item.domain.model;

import java.util.Arrays;

public enum OfferType {
    SELLING("SELLING", "WTB"),
    BUYING("BUYING", "WTS");

    private final String name;
    private final String searchType;

    OfferType(String name, String searchType) {
        this.name = name;
        this.searchType = searchType;
    }

    public String getName() {
        return name;
    }
    public String getSearchType() {
        return searchType;
    }

    public static OfferType getOfferTypeByName(String name) {
        if (name == null) return null;
        return Arrays.stream(values())
                .filter(st -> name.toUpperCase().contains(st.name))
                .findFirst()
                .orElse(OfferType.SELLING);
    }
}
