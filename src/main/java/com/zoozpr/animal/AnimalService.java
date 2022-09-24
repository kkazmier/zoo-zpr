package com.zoozpr.animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Animal> getAll();
    List<Animal> getAllByName(String name);
    void add(Animal animal);
    Optional<Animal> get(Long id);
    AnimalFullInfo getAnimalFullInfo(Long id);
}
