package com.univali.entities;

import java.util.List;

public class BreakFestMenu {

    private List<Food> foods;

    public BreakFestMenu(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
