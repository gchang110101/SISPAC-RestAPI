package com.uam.SISPAC.model.loans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uam.SISPAC.model.humanresources.SystemUser;
import com.uam.SISPAC.model.inventory.Copy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Loan")
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "Loans")
public class Loan {
    private LocalDate dateIssued;
    private LocalDate returnDate;
    private LocalDate dateCreated;
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus loanStatus;

    @ManyToMany
    //@JsonIgnore
    @JoinTable(
            schema = "Loans",
            name = "loan_copy",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "copy_id"))
    List<Copy> copies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SystemUser systemUser;

    public Loan(LocalDate dateIssued, LocalDate returnDate, LocalDate dateCreated, String id, LoanStatus loanStatus) {
        this.dateIssued = dateIssued;
        this.returnDate = returnDate;
        this.dateCreated = dateCreated;
        this.id = id;
        this.loanStatus = loanStatus;
    }
}
