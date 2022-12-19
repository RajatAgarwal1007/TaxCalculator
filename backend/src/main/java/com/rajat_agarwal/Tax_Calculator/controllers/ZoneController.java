package com.rajat_agarwal.Tax_Calculator.controllers;

import com.rajat_agarwal.Tax_Calculator.entities.Zone;
import com.rajat_agarwal.Tax_Calculator.service.Impl.ZoneServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    ZoneServiceImpl zoneServiceImpl;

    Logger logger = LoggerFactory.getLogger(ZoneController.class);

    // Add Zone
    @PostMapping("/addZone")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Zone> addZone(@RequestBody Zone zone) {
        logger.info("Add Zone method get started");
        Zone z = zoneServiceImpl.addZone(zone);
        return new ResponseEntity<>(z, HttpStatus.CREATED);
    }

    // Delete Zone
    @DeleteMapping("/deleteZone/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void deleteZone(@PathVariable Long id) {
        logger.info("Delete Zone method get started");
        this.zoneServiceImpl.deleteZone(id);
    }

    //Update Zone
    @PutMapping("/updateZone/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Zone> updateZone(@RequestBody Zone zone, @PathVariable Long id) {
        logger.info("Update Zone method get started");
        Zone z = zoneServiceImpl.updateZone(zone, id);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    // GET Zone by Id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public ResponseEntity<Zone> getZoneBYId(@PathVariable Long id) {
        logger.info("getZoneById method get started");
        Zone zone = zoneServiceImpl.findTaxPercentage(id);
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }

    @GetMapping("/zoneName/{name}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Zone> getZoneByName(@PathVariable String name) {
        Zone z = zoneServiceImpl.findZoneByName(name);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    // GET all Zone
    @GetMapping("/allZone")
    public ResponseEntity<List<Zone>> getAllZone() {
        logger.info("getALLZone method get started");
        List<Zone> zone = zoneServiceImpl.findAllZone();
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }
}
