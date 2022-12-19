package com.rajat_agarwal.Tax_Calculator.service;

import com.rajat_agarwal.Tax_Calculator.entities.Zone;

import java.util.List;

public interface ZoneService {

    public Zone addZone(Zone zone);

    public void deleteZone(Long id);

    public Zone updateZone(Zone zone, Long id);

    public List<Zone> findAllZone();

    public Zone findTaxPercentage(Long id);

    public Zone findZoneByName(String name);
}
