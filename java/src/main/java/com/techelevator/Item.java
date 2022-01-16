package com.techelevator;


public abstract class Item {

    private String id;
    private String name;
    private Double price;
    private String type;
    private int slot = 5;



    public Item(String id, String name, Double price, String type, int slot) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
