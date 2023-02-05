package com.ZooAdministration.model.animals;

public class Mammals implements Animals {

    private final String name;
    private final int livingCosts;

    public Mammals(String name, int livingCosts) {
        this.name = name;
        this.livingCosts = livingCosts;
    }

    @Override
    public int getLivingCosts() {
        return livingCosts;
    }

    @Override
    public String toString() {
        return "Mammal name: " + name + " - " +
                "living costs: " + livingCosts;
    }
}