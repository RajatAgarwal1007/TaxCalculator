package com.rajat_agarwal.Tax_Calculator.controllers;

import com.rajat_agarwal.Tax_Calculator.entities.Role;
import com.rajat_agarwal.Tax_Calculator.service.Impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    // Method to create New Role
    @PostMapping("/createNewRole")
    @PreAuthorize("hasRole('Admin')")
    public Role createNewRole(@RequestBody Role role) {
        return roleServiceImpl.createNewRole(role);
    }
}
