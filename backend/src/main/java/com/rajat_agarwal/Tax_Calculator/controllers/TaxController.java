package com.rajat_agarwal.Tax_Calculator.controllers;

import com.rajat_agarwal.Tax_Calculator.entities.Tax;

import com.rajat_agarwal.Tax_Calculator.service.Impl.TaxServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tax")
public class TaxController {


    @Autowired
    TaxServiceImpl taxServiceImpl;


    Logger logger = LoggerFactory.getLogger(TaxController.class);

    //Add Tax
    @PostMapping("/addTax")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<Tax> addTax(@Valid @RequestBody Tax tax) {
        logger.info("addTax method get started" + tax);
        Tax w = taxServiceImpl.addTax(tax);
        return new ResponseEntity<>(w, HttpStatus.CREATED);
    }

    //Delete Tax
    @DeleteMapping("/deleteTax/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void deleteTax(@PathVariable Long id) {
        logger.info("Delete Tax method get started");
        this.taxServiceImpl.deleteTax(id);

    }

    //Update Tax
    @PutMapping("/updateTax/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Tax> updateTax(@RequestBody Tax tax, @PathVariable Long id) {
        logger.info("Update Tax method get started");
        Tax t = taxServiceImpl.updateTax(tax, id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    // Get Tax by Id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public ResponseEntity<Tax> getTaxById(@PathVariable Long id) {
        logger.info("Get Tax By Id method get started");
        Tax tax = taxServiceImpl.findById(id);
        return new ResponseEntity<>(tax, HttpStatus.OK);
    }

    // Get All Tax
    @GetMapping("/allTax")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<List<Tax>> getCalculatedTax() {
        logger.info("Get All Tax method get started");
        List<Tax> w = taxServiceImpl.findAllTax();
        return new ResponseEntity<>(w, HttpStatus.OK);
    }
}
