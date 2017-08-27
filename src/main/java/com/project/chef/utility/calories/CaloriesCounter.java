package com.project.chef.utility.calories;

import com.project.chef.model.entity.Salad;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public interface CaloriesCounter {
    double executeCalories(Salad salad);
}
