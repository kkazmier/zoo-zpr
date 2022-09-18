package com.zoozpr.zone;

import com.zoozpr.animal.Animal;

import java.util.List;
import java.util.Optional;

public interface ZoneService {
    List<Zone> getAllZones();
    Zone newZone(Zone zone);
    Optional<Zone> getZone(Long id);
    Zone updateZone(Zone zone);
    List<Animal> getAnimals();
}
