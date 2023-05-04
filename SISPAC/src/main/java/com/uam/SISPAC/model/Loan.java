package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;

    @ManyToMany
    @JoinTable(
            name = "loan_copy",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "copy_id"))
    List<Copy> copies;

}
