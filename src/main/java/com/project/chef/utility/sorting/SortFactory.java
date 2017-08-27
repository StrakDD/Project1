package com.project.chef.utility.sorting;

import com.project.chef.model.entity.Salad;

import java.util.Objects;

/**
 * Created by Denis Starovoitenko on 21.08.2017.
 */
public class SortFactory {
    private Salad salad;
    private SortVegetables sortVegetables;

    public SortFactory(Salad salad) {
        setSalad(salad);
    }

    public Salad getSalad() {
        return salad;
    }

    public void setSalad(Salad salad) {
        Objects.requireNonNull(salad);
        this.salad = salad;
    }

    public void sort(String fieldName){
        if (fieldName.equalsIgnoreCase("name")){
            sortVegetables = new SortVegetablesName();
        }else if (fieldName.equalsIgnoreCase("calorie")){
            sortVegetables = new SortVegetablesCalorie();
        }else if (fieldName.equalsIgnoreCase("protein")){
            sortVegetables = new SortVegetablesProtein();
        }else if (fieldName.equalsIgnoreCase("weight")){
            sortVegetables = new SortVegetablesWeight();
        }
        sortVegetables.sort(salad);
    }
}
