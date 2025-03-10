package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            handle(item);
        }
    }

    private void handle(Item item) {
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            handleSulfuras(item);
        } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            handleBackstage(item);
        } else if (item.name.equals(AGED_BRIE)) {
            handleAgedBrie(item);
        } else if (item.name.toLowerCase().contains("conjured")) {
            handleConjured(item);
        } else {
            handleNormal(item);
        }
    }

    private void handleNormal(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality--;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }

    private void handleConjured(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }

    private void handleAgedBrie(Item item) {
        item.sellIn--;

        if (item.quality < 50) {
            item.quality++;
        }

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void handleBackstage(Item item) {
        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality = Math.min(50, item.quality + 3);
        } else if (item.sellIn < 10) {
            item.quality = Math.min(50, item.quality + 2);
        } else {
            item.quality = Math.min(50, item.quality + 1);
        }
    }

    private void handleSulfuras(Item item) {
    }
}
