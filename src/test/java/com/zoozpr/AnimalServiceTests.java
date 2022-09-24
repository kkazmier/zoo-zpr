package com.zoozpr;

import com.zoozpr.animal.Animal;
import com.zoozpr.animal.AnimalFullInfo;
import com.zoozpr.animal.AnimalRepository;
import com.zoozpr.animal.AnimalServiceImpl;
import com.zoozpr.animaltype.AnimalType;
import com.zoozpr.zone.Zone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnimalServiceTests {
    private final AnimalServiceImpl animalService;
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceTests(AnimalServiceImpl animalService, AnimalRepository animalRepository) {
        this.animalService = animalService;
        this.animalRepository = animalRepository;
    }

    @BeforeEach
    void init() {
        Animal animal = new Animal();
        AnimalType animalType = new AnimalType();
        animalType.setName("rabbit");
        animalType.setType("mamma");
        Zone zone = new Zone();
        zone.setName("zone");

        animal.setName("roger");
        animal.setAnimalType(animalType);
        animal.setFeedConsumption(4);
        animal.setZone(zone);

        Mockito.when(animalRepository.findById(1l)).thenReturn(Optional.of(animal));
    }

    @Test
    void givenAnimal_whenGetFullAnimalInfo_thenReturnFullAnimalInfo() {
        AnimalFullInfo animalFullInfo = animalService.getAnimalFullInfo(1l);

        Assert.assertEquals("roger", animalFullInfo.getAnimalName());
        Assert.assertEquals("rabbit", animalFullInfo.getAnimalTypeName());
        Assert.assertEquals("mamma", animalFullInfo.getAnimalType());
        Assert.assertEquals("zone", animalFullInfo.getZoneName());
        Assert.assertEquals(Optional.of(4), animalFullInfo.getFeedConsumption());
    }
}
