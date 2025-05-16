package com.bvlabs.d4auctioneer.domain.model.item;

import java.util.Arrays;

public enum ItemType {
    RUNE("rune");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public static ItemType getItemTypeByName(String name) {
        if (name == null) return null;
        return Arrays.stream(values())
                .filter(field -> name.toUpperCase().contains(field.name))
                .findFirst()
                .orElse(ItemType.RUNE);
    }
}
