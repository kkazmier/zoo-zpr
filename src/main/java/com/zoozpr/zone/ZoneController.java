package com.zoozpr.zone;

import com.zoozpr.animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {
    private final ZoneServiceImpl zoneService;

    @Autowired
    public ZoneController(ZoneServiceImpl zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping("/allZones")
    public List<Zone> allZones() {
        return zoneService.getAllZones();
    }

    @PostMapping(value = "/new", consumes = "*/*")
    @ResponseBody
    public Zone newZone(@RequestBody Zone zone) {
        return zoneService.newZone(zone);
    }

    @GetMapping("getAnimalsFromZone/{zoneId}")
    List<Animal> getAnimalFromZone (@PathVariable Long zoneId) {
        Zone zone = zoneService.getZone(zoneId).orElseThrow();
        return zone.getAnimals();
    }
}
