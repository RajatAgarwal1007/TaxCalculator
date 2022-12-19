package com.rajat_agarwal.Tax_Calculator.repo;

import com.rajat_agarwal.Tax_Calculator.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepo extends JpaRepository<Zone, Long> {

    Zone findByName(String name);

}
