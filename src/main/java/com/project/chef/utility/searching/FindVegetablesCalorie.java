package com.project.chef.utility.searching;

import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis Starovoitenko on 21.08.2017.
 */
public class FindVegetablesCalorie implements FindVegetables<Double> {
    @Override
    public Map<Vegetable, Double> find(Salad salad, Double minLimit, Double maxLimit) {
        Map<Vegetable, Double> result = new HashMap<>();
        Map<Vegetable, Double> ingredients = salad.getIngredients();
        double calories;

        for (Vegetable vegetable : ingredients.keySet()) {
            calories = vegetable.getCalorie() * ingredients.get(vegetable);

            if ( (calories >= minLimit) && (calories <= maxLimit)){
                result.put(vegetable, ingredients.get(vegetable));
            }
        }
        return result;
    }
}
