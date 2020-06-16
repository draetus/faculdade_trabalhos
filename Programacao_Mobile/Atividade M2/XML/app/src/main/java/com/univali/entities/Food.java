package com.univali.entities;

public class Food {

    private Long id;
    private String name;
    private String price;
    private String description;
    private Integer calories;

    private Boolean selected;

    public Food(Long id, String name, String price, String description, Integer calories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
        this.selected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
