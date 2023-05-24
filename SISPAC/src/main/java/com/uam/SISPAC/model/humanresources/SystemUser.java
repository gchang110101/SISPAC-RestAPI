package com.uam.SISPAC.model.humanresources;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SystemUser", schema = "HumanResources")
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

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
