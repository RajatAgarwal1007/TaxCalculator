package com.rajat_agarwal.Tax_Calculator.controllers;

import com.rajat_agarwal.Tax_Calculator.entities.State;
import com.rajat_agarwal.Tax_Calculator.service.Impl.StateServiceImpl;
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
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateServiceImpl stateServiceImpl;

    Logger logger = LoggerFactory.getLogger(StateController.class);


    // Add State
    @PostMapping("/addState")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<State> addState(@RequestBody State state) {
        logger.info("Add State method get started");
        State s = stateServiceImpl.addState(state);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    // Delete State
    @DeleteMapping("/deleteState/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void deleteState(@PathVariable Long id) {
        logger.info("Delete State method get started");
        this.stateServiceImpl.deleteState(id);

    }

    // Update State
    @PutMapping("/updateState/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<State> updateState(@RequestBody State state, @PathVariable Long id) {
        logger.info("Update State method get started");
        State s = stateServiceImpl.updateState(state, id);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    // GET State By Id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public ResponseEntity<State> getStateById(@PathVariable Long id) {
        logger.info("getStateById method get started");
        State state = stateServiceImpl.findTaxPercentage(id);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    // Get ALL State
    @GetMapping("/allState")
    public ResponseEntity<List<State>> getAllState() {
        logger.info("getALLState method get started");
        List<State> states = stateServiceImpl.findAllState();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

}
