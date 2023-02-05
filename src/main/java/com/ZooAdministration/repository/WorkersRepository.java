package com.ZooAdministration.repository;

import com.ZooAdministration.model.workers.Admins;
import com.ZooAdministration.model.workers.Ushers;
import com.ZooAdministration.model.workers.Zookeepers;

import java.util.ArrayList;
import java.util.List;

public class WorkersRepository {

    private final List<Admins> admins;
    private final List<Ushers> ushers;
    private final List<Zookeepers> zookeepers;

    public WorkersRepository() {
        this.admins = new ArrayList<>(List.of(
                new Admins("John", 5)
        ));

        this.ushers = new ArrayList<>(List.of(
                new Ushers("Sam", 20),
                new Ushers("Tom", 20)
        ));

        this.zookeepers = new ArrayList<>(List.of(
                new Zookeepers("Kim", 13),
                new Zookeepers("Khloe", 13),
                new Zookeepers("Kris", 13)
        ));
    }

    public List<Admins> getAdmins() {
        return admins;
    }

    public List<Ushers> getUshers() {
        return ushers;
    }

    public List<Zookeepers> getZookeepers() {
        return zookeepers;
    }

    public void addAdmin(String name, int salary) {
        Admins admins = new Admins(name, salary);
        this.getAdmins().add(admins);
    }

    public void addUsher(String name, int salary) {
        Ushers ushers = new Ushers(name, salary);
        this.getUshers().add(ushers);
    }

    public void addZookeeper(String name, int salary) {
        Zookeepers zookeepers = new Zookeepers(name, salary);
        this.getZookeepers().add(zookeepers);
    }

}
