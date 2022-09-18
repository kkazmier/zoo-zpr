package com.zoozpr.animaltype;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AnimalServiceImpl implements AnimalTypeService {
    private final AnimalTypeRepository animalTypeRepository;

    @Autowired
    public AnimalServiceImpl(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public void add(AnimalType animalType) {
        animalTypeRepository.save(animalType);
    }

    @Override
    public Optional<AnimalType> get(Long id) {
        return animalTypeRepository.findById(id);
    }
}
