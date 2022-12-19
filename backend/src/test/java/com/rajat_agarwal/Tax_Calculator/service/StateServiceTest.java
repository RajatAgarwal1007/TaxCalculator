package com.rajat_agarwal.Tax_Calculator.service;

import com.rajat_agarwal.Tax_Calculator.entities.State;
import com.rajat_agarwal.Tax_Calculator.repo.StateRepo;
import com.rajat_agarwal.Tax_Calculator.service.Impl.StateServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StateServiceTest {

    @Mock
    private StateRepo stateRepo;


    private StateServiceImpl stateService;

    @BeforeEach
    void setUp() {
        this.stateService = new StateServiceImpl(this.stateRepo);
    }

    @Test
    void getAllstate() {
        stateService.findAllState();
        verify(stateRepo).findAll();
    }


    @Test
    void addState() {
        State state = new State();

        stateService.addState(state);
        verify(stateRepo).save(state);
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
