package com.gildedrose;

public class Conjured extends Item{

    public Conjured(int sellIn, int quality){
        super("Conjured", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        if (quality > 0) {
            quality -= 2;
            if (quality < 0) {
                quality = 0;
            }
        }
        if (sellIn < 0 && quality > 0) {
            quality -= 2;
            if (quality < 0) {
                quality = 0;
            }
        }
    }
}
