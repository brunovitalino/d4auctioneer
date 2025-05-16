package com.bvlabs.d4auctioneer.domain.model.item;

import java.util.Arrays;

public enum TransactionType {
    SELLING("SELLING", "WTB"),
    BUYING("BUYING", "WTS");

    private final String name;
    private final String description;

    TransactionType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public static TransactionType getTransactionTypeByName(String name) {
        if (name == null) return null;
        return Arrays.stream(values())
                .filter(fieldValue -> name.toUpperCase().contains(fieldValue.name))
                .findFirst()
                .orElse(TransactionType.SELLING);
    }
}
