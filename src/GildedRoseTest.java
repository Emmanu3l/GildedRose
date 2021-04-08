import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("Thing", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Thing", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void qualityAlwaysLower50() {
        Item[] items = new Item[] { new Item("Aged Brie", 50, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(49, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void brie() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void expiredBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(10, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }


    @Test
    public void sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
        assert(app.items[0]. quality == 80);
    }

    @Test
    public void conjured() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void backstageUnexpiredMoreThan10Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 21) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(22, app.items[0].quality);
        assertEquals(19, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void backstageUnexpiredLessThan10Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 21) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(23, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void backstageUnexpiredLessThan5Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 21) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(24, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }


    @Test
    public void backstageExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 21) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }

    @Test
    public void sellByDatePassed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assert(app.items[0]. quality >= 0);
        assert(app.items[0].quality <= 50);
    }


}
