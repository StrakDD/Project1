package com.project.chef.model.entity;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public enum Fruit {
    FRUITS("Fruits"),
    SEEDS("Seeds");

    private String name;

    Fruit(String name) {
        this.name = name;
    }
}
