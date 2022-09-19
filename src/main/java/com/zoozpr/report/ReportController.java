package com.zoozpr.report;

import com.zoozpr.zone.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportServiceImpl reportService;

    @Autowired
    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/leastPopulatedZone")
    Zone getLeastPopulatedZone() {
        return reportService.getLeastPopulatedZone();
    }

    @GetMapping("/zoneOfGreatestConsumption")
    public Zone getZoneOfGreatestConsumption() {
        return reportService.getZoneOfGreatestConsumption();
    }
}
