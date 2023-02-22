package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

   //Name Unit test
    @Test
    //testing name value
    void test_name() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    //SellIn Unit test
    @Test
    //testing sellIn reduces by 1 even at 0
    void test_sellin_0() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
        //testing sellIn reduces by 1 at 1
    void test_sellin_1() {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
        //testing sellIn reduces by 1 even at 2
    void test_sellin_2() {
        Item[] items = new Item[] { new Item("foo", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
        //testing sellIn reduces by 1 even at 10
    void test_sellin_3() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
        //testing sellIn does not reduce if Sulfuras
    void test_sellin_4() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
        //testing sellIn does not reduce if Sulfuras even at 50
    void test_sellin_5() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 50, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].sellIn);
    }

    //Quality Unit test

    @Test
    //Backstage passes quality increases by 2 with 10 or less days.
    void test_quality_0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
        //Backstage passes quality increases by 2 with 10 or less days, but above 5
    void test_quality_1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
        //Backstage passes quality increases by 3 with 5 or less days.
    void test_quality_2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
        //Backstage passes quality increases by 3 with 5 or less days, evan at 1 day.
    void test_quality_3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
        //Backstage passes quality decrease to 0 at 0 days
    void test_quality_4() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
        //quality decrease by 1
    void test_quality_5() {
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
        //quality decrease by 0 at 0
    void test_quality_6() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
        //quality decrease by 0 at 1 is 0
    void test_quality_7() {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
        //quality decrease by double at 0
    void test_quality_8() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
        //quality can not decrease after 0
    void test_quality_9() {
        Item[] items = new Item[] { new Item("foo", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
        //quality can not decrease after 0 even after a lot of days
    void test_quality_10() {
        Item[] items = new Item[] { new Item("foo", -50, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
        //quality of Aged Brie increases
    void test_quality_11() {
        Item[] items = new Item[] { new Item("Aged Brie", 50, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
        //quality of Aged Brie increases to 50
    void test_quality_12() {
        Item[] items = new Item[] { new Item("Aged Brie", 50, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }


    @Test
        //quality of Aged Brie does not increase to 51
    void test_quality_13() {
        Item[] items = new Item[] { new Item("Aged Brie", 50, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
        //Sulfuras
    void test_quality_14() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
        //Sulfuras at -50 days
    void test_quality_15() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -50, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
        //Sulfuras at 50 days
    void test_quality_16() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 50, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

//    @Test
//        //Sulfuras with wrong quality
//    void test_quality_17() {
//        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -50, 79) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(80, app.items[0].quality);
//    }

//    @Test
        //quality can not decrease below 0 even if a negative number is entered
//    void test_quality_11() {
//        Item[] items = new Item[] { new Item("foo", 50, -1) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(0, app.items[0].quality);
//    }


}
