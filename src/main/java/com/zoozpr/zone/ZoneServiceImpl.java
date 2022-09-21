package com.zoozpr.zone;

import com.zoozpr.animal.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {
    private final Logger logger = LoggerFactory.getLogger(ZoneServiceImpl.class);
    private final ZoneRepository zoneRepository;

    @Autowired
    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public List<Zone> getAllZones() {
        List<Zone> zones = zoneRepository.findAll();
        return zones;
    }

    @Override
    public Zone newZone(Zone zone) {
        zone = zoneRepository.save(zone);
        return zone;
    }

    @Override
    public Optional<Zone> getZone(Long id) {
        return zoneRepository.findById(id);
    }

    @Override
    public Zone updateZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Override
    public List<Animal> getAnimals() {
        List<Animal> animals = this.getAnimals();
        return animals;
    }
}
