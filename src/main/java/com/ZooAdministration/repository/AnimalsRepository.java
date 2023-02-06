package com.ZooAdministration.repository;

import com.ZooAdministration.model.animals.Birds;
import com.ZooAdministration.model.animals.Mammals;
import com.ZooAdministration.model.animals.Reptiles;

import java.util.ArrayList;
import java.util.List;

public class AnimalsRepository {

    private final List<Birds> birds;
    private final List<Mammals> mammals;
    private final List<Reptiles> reptiles;

    public AnimalsRepository() {
        this.birds = new ArrayList<>(List.of(
                new Birds("Eagle", 10),
                new Birds("Pigeon", 5),
                new Birds("Peacock", 8)
        ));

        this.mammals = new ArrayList<>(List.of(
                new Mammals("Monkey", 12),
                new Mammals("Wolf", 10),
                new Mammals("Tiger", 15)
        ));

        this.reptiles = new ArrayList<>(List.of(
                new Reptiles("Crocodile", 13),
                new Reptiles("Snake", 8),
                new Reptiles("Lizard", 5)
        ));
    }

    public List<Birds> getBirds() {
        return birds;
    }

    public List<Mammals> getMammals() {
        return mammals;
    }

    public List<Reptiles> getReptiles() {
        return reptiles;
    }

    @Override
    public String toString() {
        return "AnimalsRepository{" +
                "birds=" + birds +
                ", mammals=" + mammals +
                ", reptiles=" + reptiles +
                '}';
    }
}
