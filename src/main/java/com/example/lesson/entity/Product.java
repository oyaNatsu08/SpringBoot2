package com.example.lesson.entity;

public class Product {
    Integer id;
    String name;
    Integer price;

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
