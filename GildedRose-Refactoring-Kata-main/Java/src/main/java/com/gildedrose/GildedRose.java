package com.gildedrose;

class GildedRose {
    Item[] items;
    String backStagePass = "Backstage passes to a TAFKAL80ETC concert";
    String sulfuras = "Sulfuras, Hand of Ragnaros";
    String agedBrie = "Aged Brie";


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(agedBrie) && !items[i].name.equals(backStagePass)) {
                updateNormalItemQuality(i);
            } else if (items[i].quality < 50) {
                    items[i].quality++;

                    if (items[i].name.equals(backStagePass)) {
                        updatebackStagePassQuality(i);
                    }
            }
            updateSellIn(i);
            updateBackStage(i);
        }
    }

    public void updateNormalItemQuality(int i) {
        if (items[i].quality > 0 && !items[i].name.equals(sulfuras)) {
            items[i].quality--;
        }
    }

    public void updatebackStagePassQuality(int i) {
        if (items[i].quality < 50) {
            if (items[i].sellIn < 11) {
                items[i].quality++;
            }
            if (items[i].sellIn < 6) {
                items[i].quality++;
            }
        }
    }
    public void updateSellIn(int i) {
        if (!items[i].name.equals(sulfuras)) {
            items[i].sellIn--;
        }
    }
    public void updateBackStage(int i) {
        if (items[i].sellIn < 0) {
            if (!items[i].name.equals(agedBrie)) {
                updateBackStageQuality(i);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality++;
                }
            }
        }
    }
    public void updateBackStageQuality(int i) {
        if (!items[i].name.equals(backStagePass)) {
            if (items[i].quality > 0 && !items[i].name.equals(sulfuras)) {
                items[i].quality--;
            }
        } else {
            items[i].quality -= items[i].quality;
        }
    }
}