package com.uam.SISPAC.model.humanresources;

import com.uam.SISPAC.model.loans.Loan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "SystemUser")
@Table(schema = "humanresources")
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemUser {
    @Id
    private String id;

    @Column(name = "cif", unique = true)
    private String cif;

    @Column(name = "cardNumber", unique = true, nullable = false)
    private String cardNumber;

    private String password;
    private Boolean status;
    private String names;
    private String lastNames;
    private String phoneNumber;


    @OneToMany(mappedBy = "systemUser")
    private List<Loan> loans;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
