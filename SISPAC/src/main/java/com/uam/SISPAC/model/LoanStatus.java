package com.uam.SISPAC.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "LoanStatus")
public class LoanStatus {
    private ELoanStatus loanStatus;
    @Id
    private Long id;

}
