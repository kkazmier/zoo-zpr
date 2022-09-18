package com.zoozpr.animal;

import com.zoozpr.zone.Zone;
import com.zoozpr.zone.ZoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private  final AnimalServiceImpl animalService;
    private final ZoneServiceImpl zoneService;

    @Autowired
    public AnimalController(AnimalServiceImpl animalService, ZoneServiceImpl zoneService) {
        this.animalService = animalService;
        this.zoneService = zoneService;
    }

    @RequestMapping("/getAll")
    public List<Animal> getAllAnimals() {
        return animalService.getAll();
    }

    @RequestMapping("/getAllByName/{name}")
    public List<Animal> getAllAnimalsByName(@PathVariable("name") String name) {
        return animalService.getAllByName(name);
    }

    @PostMapping(value = "/addNewAnimalToZone/{zoneId}", consumes = {"application/json"})
    public Animal addNewAnimalToZone(@PathVariable Long zoneId,
                                     @RequestParam("name") String name,
                                     @RequestParam("feedQuantity") Integer feedQuantity) {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setFeedQuantity(feedQuantity);
        Zone zone = zoneService.getZone(zoneId).orElseThrow();
        animal.setZone(zone);
        animalService.add(animal);
        return new Animal();
    }
}
