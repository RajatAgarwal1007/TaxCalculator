package com.rajat_agarwal.Tax_Calculator.service.Impl;

import com.rajat_agarwal.Tax_Calculator.entities.State;
import com.rajat_agarwal.Tax_Calculator.repo.StateRepo;
import com.rajat_agarwal.Tax_Calculator.exception.TaxNotFoundException;
import com.rajat_agarwal.Tax_Calculator.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepo stateRepo;

    public StateServiceImpl() {}

    public StateServiceImpl(StateRepo stateRepo) {
        this.stateRepo = stateRepo;
    }

    @Override
    public State addState(State state) {
        return stateRepo.save(state);
    }


    @Override
    public void deleteState(Long id) {
        State s = stateRepo.findById(id).orElseThrow(() -> new TaxNotFoundException("State", "Id", id));
        this.stateRepo.delete(s);
    }


    @Override
    public State updateState(State state, Long id) {
        State s = stateRepo.findById(id).orElseThrow(() -> new TaxNotFoundException("State", "Id", id));
        s.setName(state.getName());
        s.setTaxPercentage(state.getTaxPercentage());

        return stateRepo.save(s);
    }

    @Override
    public State findTaxPercentage(Long id) {

        return stateRepo.findById(id).orElseThrow(() -> new TaxNotFoundException("State", "Id", id));
    }

    @Override
    public List<State> findAllState() {
        return stateRepo.findAll();
    }
}
