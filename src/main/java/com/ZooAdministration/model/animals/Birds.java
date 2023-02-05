package com.ZooAdministration.model.animals;

public class Birds implements Animals {

    private final String name;
    private final int livingCosts;

    public Birds(String name, int livingCosts) {
        this.name = name;
        this.livingCosts = livingCosts;
    }

    @Override
    public int getLivingCosts() {
        return livingCosts;
    }

    @Override
    public String toString() {
        return "Bird name: " + name + " - " +
                "living costs: " + livingCosts;
    }

}
