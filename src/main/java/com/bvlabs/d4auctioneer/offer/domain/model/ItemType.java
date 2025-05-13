package com.bvlabs.d4auctioneer.offer.domain.model;

public enum ItemType {
    Equipment("EQUIPMENT"), Consumable("CONSUMABLE");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }
}
