package com.rajat_agarwal.Tax_Calculator.entities;

import lombok.*;
import org.hibernate.engine.internal.ImmutableEntityEntry;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "Tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_userName")
    private User userName;

//    @Column(name = "name")
//    @NotEmpty(message = "must not be empty, Its a required field")
//    @Size(min = 4, message = "name should be minimum of length 4")
//    private String name;

//    @Column(name = "phone")
//    @NotNull(message = "must not be empty, It a required field")
//    @Range(min =  10,  message = "phone number should be of length 10")
//    private Long phone;
//
//    @Column(name = "email")
//    @Email(message = "email is not valid")
//    @NotEmpty(message = "must not be empty, Its a required Field")
//    private String email;

    @Column(name = "amount")
    @NotNull(message = "must not be empty, Its a required Field")
    private Long amount;

    @NotNull(message = "must not be empty, Its a required Field")
    @Column(name = "zoneId")
    private Long zoneId;

    @NotNull(message = "must not be empty, Its a required Field")
    @Column(name = "stateId")
    private Long stateId;

    @Column(name = "calculatedTax")
    private Double calculatedTax;

//    public Long getPhone() {
//        return phone;
//    }
//
//    public void setPhone(Long phone) {
//        this.phone = phone;
//    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Double getCalculatedTax() {
        return calculatedTax;
    }

    public void setCalculatedTax(Double calculatedTax) {
        this.calculatedTax = calculatedTax;
    }

}
