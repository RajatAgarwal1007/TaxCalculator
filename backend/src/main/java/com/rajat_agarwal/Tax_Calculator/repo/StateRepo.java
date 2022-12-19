package com.rajat_agarwal.Tax_Calculator.repo;

import com.rajat_agarwal.Tax_Calculator.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StateRepo extends JpaRepository<State, Long> {
}
