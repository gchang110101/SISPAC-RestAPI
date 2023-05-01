package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "Loan")
public class Loan {
    private LocalDate dateIssued;
    private LocalDate dateReturned;
    private LocalDate dateAccepted;
    private Double delay;
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus loanStatus;
}
