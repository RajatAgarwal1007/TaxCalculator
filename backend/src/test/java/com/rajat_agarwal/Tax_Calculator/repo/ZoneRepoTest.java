package com.rajat_agarwal.Tax_Calculator.repo;

import com.rajat_agarwal.Tax_Calculator.entities.Tax;
import com.rajat_agarwal.Tax_Calculator.entities.Zone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ZoneRepoTest {

    @Autowired
    ZoneRepo zoneRepo;

    @Test
    public void addTax() {
        Zone zone = new Zone();
        zone.setId(34L);
        zone.setName("Indore");
        zone.setTaxPercentage(5.4);
        zoneRepo.save(zone);
        assertNotNull(zoneRepo.findById(100L));
    }


    @Test
    public void  readAllTax() {
        List<Zone> list = zoneRepo.findAll();
        assertThat(list).asList().size().isGreaterThan(0);
    }

    @Test
    public void deleteTax() {
        Zone zone = new Zone();
        zone.setId(34L);
        zone.setName("Indore");
        zone.setTaxPercentage(5.4);
        zoneRepo.save(zone);
        zoneRepo.delete(zone);
        assertThat(zoneRepo.findById(100L)).isNotPresent();
    }


    @AfterEach
    void tearDown() {
        System.out.println("Test Ended");
        System.out.println("--------------------------------------------------------------");
    }

    @BeforeEach
    void tearUp() {
        System.out.println("Test Started");
    }
}
