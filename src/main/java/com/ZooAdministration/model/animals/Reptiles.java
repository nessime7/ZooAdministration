package com.ZooAdministration.model.animals;

public class Reptiles implements Animals {

    private final String name;
    private final int livingCosts;

    public Reptiles(String name, int livingCosts) {
        this.name = name;
        this.livingCosts = livingCosts;
    }

    @Override
    public int getLivingCosts() {
        return livingCosts;
    }

    @Override
    public String toString() {
        return "Reptile name: " + name + " - " +
                "living costs: " + livingCosts;
    }

}