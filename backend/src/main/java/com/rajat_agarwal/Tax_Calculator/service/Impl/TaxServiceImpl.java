package com.rajat_agarwal.Tax_Calculator.service.Impl;

import com.rajat_agarwal.Tax_Calculator.entities.State;
import com.rajat_agarwal.Tax_Calculator.entities.Tax;
import com.rajat_agarwal.Tax_Calculator.entities.Zone;
import com.rajat_agarwal.Tax_Calculator.exception.TaxNotFoundException;
import com.rajat_agarwal.Tax_Calculator.repo.TaxRepo;
import com.rajat_agarwal.Tax_Calculator.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepo taxRepo;

    @Autowired
    private StateServiceImpl stateServiceImpl;

    @Autowired
    private ZoneServiceImpl zoneServiceImpl;


    public Tax addTax(Tax tax) {

        State stateTax = stateServiceImpl.findTaxPercentage(tax.getStateId());
        Zone zoneTax = zoneServiceImpl.findTaxPercentage(tax.getZoneId());
        tax.setCalculatedTax(calculateTax(stateTax.getTaxPercentage(), zoneTax.getTaxPercentage(), tax.getAmount()));
//        tax.setUserName(tax.getUserName().getUserName());
        return taxRepo.save(tax);
    }

    @Override
    public void deleteTax(Long id) {
        Tax tax = taxRepo.findById(id).orElseThrow(() -> new TaxNotFoundException("Tax", "Id", id));
        this.taxRepo.delete(tax);
    }

    @Override
    public Tax updateTax(Tax tax, Long id) {
        Tax t = taxRepo.findById(id).orElseThrow(()-> new TaxNotFoundException("Tax", "Id", id));
//        t.setName(tax.getName());
//        t.setPhone(tax.getPhone());
//        t.setEmail(tax.getEmail());
        t.setAmount(tax.getAmount());
        t.setStateId(tax.getStateId());
        t.setZoneId(tax.getZoneId());

        State stateTax = stateServiceImpl.findTaxPercentage(tax.getStateId());
        Zone zoneTax = zoneServiceImpl.findTaxPercentage(tax.getZoneId());
        t.setCalculatedTax(calculateTax(stateTax.getTaxPercentage(), zoneTax.getTaxPercentage(), tax.getAmount()));

        return taxRepo.save(t);
    }


    private Double calculateTax(Double stateTax, Double zoneTax, Long amount) {
        return ((stateTax + zoneTax) * amount) / 100;

    }

    public List<Tax> findAllTax() {
        return taxRepo.findAll();
    }

    @Override
    public Tax findById(Long id) {
        return taxRepo.findById(id).orElseThrow(() ->
                new TaxNotFoundException("Zone", "Id", id));
    }
}
