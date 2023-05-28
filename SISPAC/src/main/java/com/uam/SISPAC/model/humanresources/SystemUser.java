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

    public SystemUser(String id, String cif, String cardNumber, String password, Boolean status, String names, String lastNames, String phoneNumber, UserType userType) {
        this.id = id;
        this.cif = cif;
        this.cardNumber = cardNumber;
        this.password = password;
        this.status = status;
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    @OneToMany(mappedBy = "systemUser")
    private List<Loan> loans;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
