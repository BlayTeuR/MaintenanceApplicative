package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("test du toString de la classe Item")
    void test_toString_Item(){
        Item item = new Item("foo", 0, 0);
        assertEquals("foo, 0, 0", item.toString());
    }

    @Test
    @DisplayName("test du produit Aged Brie avec quality de base à 0")
    void test_AgedBrie_Item(){
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, 9, 1", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Aged Brie avec quality de base à 2 mais sellin à -1")
    void test_AgedBrie_0(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, -1, 4", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Aged Brie avec quality de base à 50")
    void test_AgedBrie_50(){
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, 9, 50", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Sulfuras")
    void test_Sulfuras_Item(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Backstage passes avec quality de base à 20")
    void test_Backstage_passes_Item_sellin_20(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 19, 1", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Backstage passes avec quality de base à 9")
    void test_Backstage_passes_Item_sellin_10(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 8, 2", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Backstage passes avec quality de base à 4")
    void test_Backstage_passes_Item_sellin_5(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 3", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Backstage passes après le concert")
    void test_Backstage_passes_Item_sellin_0(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[0].toString());
    }

    @Test
    @DisplayName("test du produit Backstage passes avec quality max")
    void test_Backstage_passes_Item_quality_max(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 1, 50", app.items[0].toString());
    }

    @Test
    @DisplayName("test d'un produit random pour vérifier sellin et quality pour un sellin > 0")
    void test_ran(){
        Item[] items = new Item[] { new Item("ran", 10, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("ran, 9, 6", app.items[0].toString());
    }

    @Test
    @DisplayName("test d'un produit random pour vérifier sellin et quality pour un sellin < 0")
    void test_ran_sellin_0(){
        Item[] items = new Item[] { new Item("ran", 0, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("ran, -1, 5", app.items[0].toString());
    }

    @Test
    @DisplayName("test d'un Conjured")
    void test_conjured(){
        Item[] items = new Item[] { new Item("Conjured", 10, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured, 9, 5", app.items[0].toString());
    }

}
