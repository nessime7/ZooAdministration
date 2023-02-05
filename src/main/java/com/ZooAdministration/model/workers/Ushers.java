package com.ZooAdministration.model.workers;

public class Ushers implements WorkersInterface {

    private final String name;
    private final int salary;

    public Ushers(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Usher name: " + name + " - " +
                "salary cost: " + salary;
    }

}