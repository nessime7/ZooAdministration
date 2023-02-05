package com.ZooAdministration.model.workers;

public class Zookeepers implements WorkersInterface {

    private final String name;
    private final int salary;

    public Zookeepers(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Zookeeper name: " + name + " - " +
                "salary cost: " + salary;
    }

}