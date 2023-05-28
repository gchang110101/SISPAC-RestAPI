package com.uam.SISPAC.model.loans;

import com.uam.SISPAC.model.humanresources.SystemUser;
import com.uam.SISPAC.model.inventory.Copy;
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
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus loanStatus;

    @ManyToMany
    @JoinTable(
            name = "loan_copy",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "copy_id"))
    List<Copy> copies;

    @ManyToOne(fetch = FetchType.LAZY)
    private SystemUser systemUser;

    public Loan(LocalDate dateIssued, LocalDate dateReturned, LocalDate dateAccepted, String id, LoanStatus loanStatus) {
        this.dateIssued = dateIssued;
        this.dateReturned = dateReturned;
        this.dateAccepted = dateAccepted;
        this.id = id;
        this.loanStatus = loanStatus;
    }
}
