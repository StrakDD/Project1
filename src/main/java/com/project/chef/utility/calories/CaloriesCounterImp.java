package com.project.chef.utility.calories;

import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;

import java.util.Map;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public class CaloriesCounterImp implements CaloriesCounter {
    @Override
    public double executeCalories(Salad salad) {
        if (salad == null){
            return 0.0;
        }
        double result = 0.0;

        for (Map.Entry<Vegetable,Double> vegetable : salad.getIngredients().entrySet()) {
            result = result + vegetable.getValue() * vegetable.getKey().getCalorie();
        }

        return result;
    }

    public static double getCalories(Salad salad){
        return new CaloriesCounterImp().executeCalories(salad);
    }
}
