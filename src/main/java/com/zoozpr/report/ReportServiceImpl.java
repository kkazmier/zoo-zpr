package com.zoozpr.report;

import com.zoozpr.zone.Zone;
import com.zoozpr.zone.ZoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ReportServiceImpl implements ReportService {
    private final ZoneServiceImpl zoneService;

    @Autowired
    public ReportServiceImpl(ZoneServiceImpl zoneService) {
        this.zoneService = zoneService;
    }

    @Override
    public Zone getLeastPopulatedZone() {
        return zoneService.getAllZones().stream()
                .min(Comparator.comparing(Zone::getAnimalQuantity))
                .orElseThrow();
    }

    @Override
    public Zone getZoneOfGreatestConsumption() {
        return zoneService.getAllZones().stream()
                .max(Comparator.comparing(Zone::getWholeConsumption))
                .orElseThrow();
    }


}
