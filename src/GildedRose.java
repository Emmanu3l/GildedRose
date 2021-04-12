class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
                switch (item.name) {
                    case "Aged Brie":
                        item.quality += 1;
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        if (item.sellIn < 1) {
                            item.quality = 0;
                        } else if (item.sellIn < 6) {
                            item.quality += 3;
                        } else if (item.sellIn < 11) {
                            item.quality += 2;
                        } else {
                            item.quality += 1;
                        }
                        break;
                    case "Conjured Mana Cake":
                        item.quality -= 2;
                        break;
                    default:
                        item.quality -= 1;
                        break;
                }
                if (item.sellIn < 1) {
                    if (item.name.equals("Aged Brie")) {
                        item.quality += 1;
                    } else {
                        item.quality -=1;
                    }
                }
                if (item.quality > 50) {
                    item.quality = 50;
                } else if (item.quality < 0) {
                    item.quality = 0;
                }
            }
        }
    }

}
