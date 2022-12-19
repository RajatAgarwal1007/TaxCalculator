package com.rajat_agarwal.Tax_Calculator.service;

import com.rajat_agarwal.Tax_Calculator.entities.Tax;

import java.util.List;

public interface TaxService {

    public Tax addTax(Tax tax);

    public void deleteTax(Long id);

    public Tax updateTax(Tax tax, Long id);

    public List<Tax> findAllTax();

    public Tax findById(Long id);


}
