package com.rajat_agarwal.Tax_Calculator.service;

import com.rajat_agarwal.Tax_Calculator.entities.State;

import java.util.List;

public interface StateService {
    public State addState(State state);

    public State updateState(State state, Long id);

    public void deleteState(Long id);

    public State findTaxPercentage(Long id);

    public List<State> findAllState();

}
