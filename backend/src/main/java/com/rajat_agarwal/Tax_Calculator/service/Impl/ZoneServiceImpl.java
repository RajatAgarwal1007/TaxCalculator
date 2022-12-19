package com.rajat_agarwal.Tax_Calculator.service.Impl;

import com.rajat_agarwal.Tax_Calculator.entities.Zone;
import com.rajat_agarwal.Tax_Calculator.repo.ZoneRepo;
import com.rajat_agarwal.Tax_Calculator.exception.TaxNotFoundException;
import com.rajat_agarwal.Tax_Calculator.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepo zoneRepo;

    @Override
    public Zone addZone(Zone zone) {
        return zoneRepo.save(zone);
    }

    @Override
    public void deleteZone(Long id) {
        Zone z = zoneRepo.findById(id).orElseThrow(() -> new TaxNotFoundException("Zone", "Id", id));
        this.zoneRepo.delete(z);
    }

    @Override
    public Zone updateZone(Zone zone, Long id) {
        Zone z = zoneRepo.findById(id).orElseThrow(() -> new TaxNotFoundException("Zone", "Id", id));
        z.setName(zone.getName());
        z.setTaxPercentage(zone.getTaxPercentage());
        return zoneRepo.save(z);

    }

    public List<Zone> findAllZone() {
        return zoneRepo.findAll();
    }

    public Zone findTaxPercentage(Long id) {

        return zoneRepo.findById(id).orElseThrow(() ->
                new TaxNotFoundException("Zone", "Id", id));
    }

    @Override
    public Zone findZoneByName(String name) {
        return zoneRepo.findByName(name);
//                .orElseThrow(() ->
//                new TaxNotFoundException("Zone", "Id", name));
    }

}
