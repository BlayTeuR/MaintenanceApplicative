package com.gildedrose;

public class BackstagePasses extends Item{

    public BackstagePasses(int sellIn, int quality){
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
    @Override
    public void updateQuality() {
        sellIn--;
        if (sellIn < 0) {
            quality = 0;
        } else if (sellIn < 5) {
            quality = Math.min(50, quality + 3);
        } else if (sellIn < 10) {
            quality = Math.min(50, quality + 2);
        } else {
            quality = Math.min(50, quality + 1);
        }
    }
}
