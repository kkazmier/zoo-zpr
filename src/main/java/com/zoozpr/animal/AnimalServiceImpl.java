package com.zoozpr.animal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final Logger logger = LoggerFactory.getLogger(AnimalServiceImpl.class);
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getAllByName(String name) {
        return animalRepository.findAllByName(name);
    }

    @Override
    public void add(Animal animal) {
        animal = animalRepository.save(animal);
    }

    @Override
    public Optional<Animal> get(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public AnimalFullInfo getAnimalFullInfo(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow();
        return new AnimalFullInfo(
                animal.getId(),
                animal.getName(),
                animal.getAnimalType().getType(),
                animal.getAnimalType().getName(),
                animal.getFeedConsumption(),
                animal.getZone().getName()
        );
    }
}
