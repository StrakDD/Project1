package com.project.chef.model.entity;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public enum Vegetative {
    ROOTS("Roots"),
    TUBERS("Tubers"),
    STEMS("Stems"),
    LEAVES("Leaves"),
    BULBS("Bulbs"),
    OTHERS("Others");

    private String name;

    Vegetative(String name) {
        this.name = name;
    }
}
