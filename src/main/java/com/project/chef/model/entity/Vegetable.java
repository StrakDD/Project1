package com.project.chef.model.entity;

import java.util.Objects;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public class Vegetable {
    private String name;
    private int calorie;
    private double protein;
    private double fat;
    private double carbohydrate;

    public Vegetable() {
        this("Vegetable", 0, 0.0, 0.0, 0.0);
    }

    public Vegetable(String name) {
        this(name, 0, 0.0, 0.0, 0.0);
    }

    public Vegetable(String name, int calorie, double protein, double fat, double carbohydrate) {
        setName(name);
        this.calorie = calorie;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", calorie=" + calorie +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return calorie == vegetable.calorie &&
                Double.compare(vegetable.protein, protein) == 0 &&
                Double.compare(vegetable.fat, fat) == 0 &&
                Double.compare(vegetable.carbohydrate, carbohydrate) == 0 &&
                Objects.equals(name, vegetable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calorie, protein, fat, carbohydrate);
    }
}
