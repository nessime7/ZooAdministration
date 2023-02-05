package com.ZooAdministration.model.workers;

public class Admins implements WorkersInterface {

    private final String name;
    private final int salary;

    public Admins(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Admin name: " + name + " - " +
                "salary cost: " + salary;
    }

}
