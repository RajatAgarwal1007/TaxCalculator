package com.rajat_agarwal.Tax_Calculator.repo;

import com.rajat_agarwal.Tax_Calculator.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepo extends JpaRepository<Tax, Long> {
}
