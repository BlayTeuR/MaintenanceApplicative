package com.gildedrose;

public class Random extends Item{


    public Random(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        if (quality > 0) {
            quality--;
        }
        if (sellIn < 0 && quality > 0) {
            quality--;
        }
    }
}
