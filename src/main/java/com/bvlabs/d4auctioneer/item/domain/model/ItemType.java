package com.bvlabs.d4auctioneer.item.domain.model;

public enum ItemType {
    Equipment("EQUIPMENT"), Consumable("CONSUMABLE");

    final String name;

    ItemType(String name) {
        this.name = name;
    }
}
