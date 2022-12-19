package com.rajat_agarwal.Tax_Calculator.controllers;


import com.rajat_agarwal.Tax_Calculator.entities.JwtRequest;
import com.rajat_agarwal.Tax_Calculator.entities.JwtResponse;
import com.rajat_agarwal.Tax_Calculator.service.Impl.JwtServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtServiceImpl jwtServiceImpl;

    Logger logger = LoggerFactory.getLogger(TaxController.class);

    // Method to Authenticate a user and generate Token
    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        logger.info("createJwtToken/Authentication method get started");
        return jwtServiceImpl.createJwtToken(jwtRequest);
    }

}
