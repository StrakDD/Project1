package com.project.chef.model.entity;

import java.util.Objects;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public class FruitVegetable extends Vegetable {
    private Fruit eatablePart;


    public FruitVegetable(String name, Fruit eatablePart) {
        super(name);
        setEatablePart(eatablePart);
    }

    public FruitVegetable(String name, int calorie, double protein, double fat, double carbohydrate, Fruit eatablePart) {
        super(name, calorie, protein, fat, carbohydrate);
        setEatablePart(eatablePart);
    }

    public Fruit getEatablePart() {
        return eatablePart;
    }

    public void setEatablePart(Fruit eatablePart) {
        Objects.requireNonNull(eatablePart);
        this.eatablePart = eatablePart;
    }

    @Override
    public String toString() {
        return "FruitVegetable{" +
                "eatablePart=" + eatablePart +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FruitVegetable)) return false;
        if (!super.equals(o)) return false;
        FruitVegetable that = (FruitVegetable) o;
        return eatablePart == that.eatablePart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eatablePart);
    }
}
