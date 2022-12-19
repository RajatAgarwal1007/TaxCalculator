package com.rajat_agarwal.Tax_Calculator.service.Impl;

import com.rajat_agarwal.Tax_Calculator.entities.Role;
import com.rajat_agarwal.Tax_Calculator.repo.RoleRepo;
import com.rajat_agarwal.Tax_Calculator.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}
