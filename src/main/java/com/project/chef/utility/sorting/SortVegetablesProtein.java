package com.project.chef.utility.sorting;

import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Denis Starovoitenko on 21.08.2017.
 */
public class SortVegetablesProtein implements SortVegetables {
    @Override
    public void sort(Salad salad) {
        Map<Vegetable, Double> result = new TreeMap<>(Comparator.comparing(d->d.getProtein()));
        result.putAll(salad.getIngredients());
        salad.setIngredients(result);
    }
}
