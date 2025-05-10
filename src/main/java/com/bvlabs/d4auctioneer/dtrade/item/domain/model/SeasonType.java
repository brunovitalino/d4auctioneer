package com.bvlabs.d4auctioneer.dtrade.item.domain.model;

import java.util.Arrays;

public enum SeasonType {
    SOFTCORE("SOFTCORE", "season softcore"),
    HARDCORE("HARDCORE", "season hardcore");

    private final String name;
    private final String description;

    SeasonType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public static SeasonType getSeasonTypeByDescription(String description) {
        if (description == null) return null;
        return Arrays.stream(values())
                .filter(st -> description.toUpperCase().contains(st.name))
                .findFirst()
                .orElse(SeasonType.SOFTCORE);
    }
}
