//package com.rajat_agarwal.Tax_Calculator.repo;
//
//import com.rajat_agarwal.Tax_Calculator.entities.Tax;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class TaxRepoTest {
//
//    @Autowired
//    TaxRepo taxRepo;
//
//    @Test
//    public void addTax() {
//        Tax tax = new Tax();
//        tax.setId(100L);
//        tax.setName("Test9");
////        tax.setPhone(9123456780L);
////        tax.setEmail("test9@gmail.com");
//        tax.setAmount(70000L);
//        tax.setStateId(3L);
//        tax.setZoneId(5L);
//        tax.setCalculatedTax(1000D);
//        taxRepo.save(tax);
//        assertNotNull(taxRepo.findById(100L));
//    }
//
//
//    @Test
//    public void  readAllTax() {
//        List<Tax> list = taxRepo.findAll();
//        assertThat(list).asList().size().isGreaterThan(0);
//    }
//
//    @Test
//    public void deleteTax() {
//        Tax tax = new Tax();
//        tax.setId(100L);
//        tax.setName("Test9");
////        tax.setPhone(9123456780L);
////        tax.setEmail("test9@gmail.com");
//        tax.setAmount(70000L);
//        tax.setStateId(3L);
//        tax.setZoneId(5L);
//        tax.setCalculatedTax(1000D);
//        taxRepo.save(tax);
//        taxRepo.delete(tax);
//        assertThat(taxRepo.findById(100L)).isNotPresent();
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Test Ended");
//        System.out.println("--------------------------------------------------------------");
//    }
//
//    @BeforeEach
//    void tearUp() {
//        System.out.println("Test Started");
//    }
//}
