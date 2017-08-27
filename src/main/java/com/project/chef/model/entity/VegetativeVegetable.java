package com.project.chef.model.entity;

import java.util.Objects;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public class VegetativeVegetable extends Vegetable {
    private Vegetative eatablePart;


    public VegetativeVegetable(String name, Vegetative eatablePart) {
        super(name);
        setEatablePart(eatablePart);
    }

    public VegetativeVegetable(String name, int calorie, double protein, double fat, double carbohydrate, Vegetative eatablePart) {
        super(name, calorie, protein, fat, carbohydrate);
        setEatablePart(eatablePart);
    }

    public Vegetative getEatablePart() {
        return eatablePart;
    }

    public void setEatablePart(Vegetative eatablePart) {
        Objects.requireNonNull(eatablePart);
        this.eatablePart = eatablePart;
    }

    @Override
    public String toString() {
        return "VegetativeVegetable{" +
                "eatablePart=" + eatablePart +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VegetativeVegetable)) return false;
        if (!super.equals(o)) return false;
        VegetativeVegetable that = (VegetativeVegetable) o;
        return eatablePart == that.eatablePart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eatablePart);
    }
}
