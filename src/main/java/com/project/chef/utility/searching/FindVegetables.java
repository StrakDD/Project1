package com.project.chef.utility.searching;

import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;

import java.util.Map;

/**
 * Created by Denis Starovoitenko on 21.08.2017.
 */
public interface FindVegetables<T> {
    Map<Vegetable, Double> find(Salad salad, T minLimit, T maxLimit);
}
