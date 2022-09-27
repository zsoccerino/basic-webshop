package com.gfa.basicwebshop.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
public class ItemList {
    private List<Item> itemList = new ArrayList<>();
    public ItemList() {
        this.itemList.add(new Item("Fender Stratocaster", "Classic Fender", 370000.0, 0));
        this.itemList.add(new Item("Gibson Les Paul", "Classic Gibson", 460000.0, 3));
        this.itemList.add(new Item("Ibanez", "Modern Stratocaster", 280000.0, 6));
        this.itemList.add(new Item("Jackson", "Modern Stratocaster", 250000.0, 0));
        this.itemList.add(new Item("PRS", "Modern Les Paul", 430000.0, 2));
    }
    public double getAverageStock() {
        OptionalDouble average = this.itemList.stream()
                .mapToInt(s -> s.getStock())
                .average();
        return average.getAsDouble();
    }
    public String getMostExpensive() {
        Item mostExpensive = this.itemList.stream()
                .max(Comparator.comparing(Item::getPrice)).get();
        return mostExpensive.getName();
    }
    public List<Item> getItemList() {
        return itemList;
    }
}
