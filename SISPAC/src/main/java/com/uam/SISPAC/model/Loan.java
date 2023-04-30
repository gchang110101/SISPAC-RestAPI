package com.uam.SISPAC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;


@Entity(name = "Loan")
public class Loan {
    private LocalDate dateIssued;
    private LocalDate dateReturned;
    private LocalDate dateAccepted;
    private Double delay;
    @Id
    private Long id;
    @OneToOne
    private LoanStatus loanStatus;
}
