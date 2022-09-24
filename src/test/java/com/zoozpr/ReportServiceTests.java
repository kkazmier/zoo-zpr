package com.zoozpr;

import com.zoozpr.animal.Animal;
import com.zoozpr.report.ReportServiceImpl;
import com.zoozpr.zone.Zone;
import com.zoozpr.zone.ZoneRepository;
import com.zoozpr.zone.ZoneServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReportServiceTests {
    private final Logger logger = LoggerFactory.getLogger(ReportServiceTests.class);
    ReportServiceImpl reportService;

    ZoneServiceImpl zoneService;

    @MockBean
    ZoneRepository zoneRepository;

    private List<Zone> zones = new ArrayList<>();

    @Autowired
    public ReportServiceTests(ReportServiceImpl reportService, ZoneServiceImpl zoneService) {
        this.reportService = reportService;
        this.zoneService = zoneService;
    }

    @BeforeEach
    void init() {
        Zone firstZone = new Zone();
        Zone secondZone = new Zone();
        Zone thirdZone = new Zone();
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal(4, firstZone));
        animals1.add(new Animal(4, firstZone));
        animals1.add(new Animal(4, firstZone));
        List<Animal> animals2 = new ArrayList<>();
        animals2.add(new Animal(11, secondZone));
        animals2.add(new Animal(11, secondZone));
        List<Animal> animals3 = new ArrayList<>();
        animals3.add(new Animal(20, thirdZone));
        firstZone.setAnimals(animals1);
        secondZone.setAnimals(animals2);
        thirdZone.setAnimals(animals3);
        zones.add(firstZone);
        zones.add(secondZone);
        zones.add(thirdZone);
        Mockito.when(zoneRepository.findAll()).thenReturn(zones);
    }

    @Test
    void givenZones_whenGetLeastPopulatedZone_thenReturnLeastPopulatedZone() {
        Zone leastPopulated = reportService.getLeastPopulatedZone();

        Assertions.assertEquals(1, leastPopulated.getAnimalQuantity());
    }

    @Test
    public void givenZones_whenGetZoneOfGreatestConsumption_thenReturnZoneOfGreatestConsumption() {
        Zone greatestConsumption = reportService.getZoneOfGreatestConsumption();

        Assertions.assertEquals(2, greatestConsumption.getAnimalQuantity());
    }
}
