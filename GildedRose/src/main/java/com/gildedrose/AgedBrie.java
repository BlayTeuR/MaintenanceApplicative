package com.gildedrose;

public class AgedBrie extends Item{

    public AgedBrie(int sellIn, int quality){
        super("Aged Brie", sellIn, quality);
    }
    @Override
    public void updateQuality() {
        sellIn--;
        if (quality < 50) {
            quality++;
        }
        if (sellIn < 0 && quality < 50) {
            quality++;
        }
    }
}
