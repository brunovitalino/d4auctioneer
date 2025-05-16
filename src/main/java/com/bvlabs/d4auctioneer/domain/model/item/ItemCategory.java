package com.bvlabs.d4auctioneer.domain.model.item;

public enum ItemCategory {
    Equipment("EQUIPMENT"), Consumable("CONSUMABLE");

    private final String name;

    ItemCategory(String name) {
        this.name = name;
    }
}
