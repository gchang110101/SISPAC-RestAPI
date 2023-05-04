package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "SystemUser")
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemUser {
    @Id
    private String id;

    @Column(name = "cif", unique = true)
    private String cif;

    private Boolean status;
    private String names;
    private String lastNames;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
