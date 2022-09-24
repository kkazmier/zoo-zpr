package com.zoozpr.animaltype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalTypeServiceImpl implements AnimalTypeService {
    private final AnimalTypeRepository animalTypeRepository;

    @Autowired
    public AnimalTypeServiceImpl(AnimalTypeRepository animalTypeRepository) {
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
