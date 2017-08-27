package com.project.chef.model.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public class Salad {
    private Map<Vegetable, Double> ingredients;
    private String name;

    public Salad(String name) {
        setName(name);
        ingredients = new HashMap<>();
    }

    public Map<Vegetable, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Vegetable, Double> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public void addIngredient(Vegetable vegetable, double kilograms){
        Objects.requireNonNull(vegetable);
        ingredients.put(vegetable, kilograms);
    }

    public void removeIngredient(Vegetable vegetable){
        Objects.requireNonNull(vegetable);
        ingredients.entrySet().removeIf(e -> e.getKey().equals(vegetable));
    }


}
