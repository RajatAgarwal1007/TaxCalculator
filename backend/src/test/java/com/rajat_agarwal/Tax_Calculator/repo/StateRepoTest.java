package com.rajat_agarwal.Tax_Calculator.repo;

import com.rajat_agarwal.Tax_Calculator.entities.State;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StateRepoTest {

    @Autowired
    StateRepo stateRepo;

    @Test
    void addState() {
        State state = new State();
        state.setId(177L);
        state.setName("Goa");
        state.setTaxPercentage(3.4);
        stateRepo.save(state);
        assertNotNull(stateRepo.findById(177L));
    }

    @Test
    public void  readAllState() {
        List<State> list = stateRepo.findAll();
        assertThat(list).asList().size().isGreaterThan(0);
    }

    @Test
    public void deleteTax() {
        State state = new State();
        state.setId(177L);
        state.setName("Goa");
        state.setTaxPercentage(3.4);
        stateRepo.save(state);
        stateRepo.delete(state);
        assertThat(stateRepo.findById(177L)).isNotPresent();
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
