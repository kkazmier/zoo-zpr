package com.zoozpr.report;

import com.zoozpr.zone.Zone;

public interface ReportService {
    Zone getLeastPopulatedZone();
    Zone getZoneOfGreatestConsumption();
}
