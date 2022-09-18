package com.zoozpr.animaltype;

import java.util.Optional;

public interface AnimalTypeService {
    void add(AnimalType animalType);
    Optional<AnimalType> get(Long id);
}
