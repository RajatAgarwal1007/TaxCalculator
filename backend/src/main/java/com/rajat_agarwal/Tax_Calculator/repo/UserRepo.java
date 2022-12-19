package com.rajat_agarwal.Tax_Calculator.repo;

import com.rajat_agarwal.Tax_Calculator.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<User, String> {
}
