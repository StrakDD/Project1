package com.project.chef.utility.sorting;

import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;

import java.util.*;

/**
 * Created by Denis Starovoitenko on 21.08.2017.
 */
public class SortVegetablesWeight implements SortVegetables{
    @Override
    public void sort(Salad salad) {
        Map<Vegetable, Double> result = new LinkedHashMap<>();
        List<Map.Entry<Vegetable, Double>> list = new LinkedList<>( salad.getIngredients().entrySet() );

        Collections.sort( list,Comparator.comparing(d->d.getValue()) );

        for (Map.Entry<Vegetable, Double> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        salad.setIngredients(result);
    }
}
