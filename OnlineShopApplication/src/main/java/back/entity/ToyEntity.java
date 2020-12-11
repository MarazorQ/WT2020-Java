package entity;

import java.util.List;

public class ToyEntity extends Entity{
    private String name;
    private int price;
    protected int toyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getToyId() {
        return toyId;
    }

    public void setToyId(int pianoId) {
        this.toyId = toyId;
    }
}
