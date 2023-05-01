package com.uam.SISPAC.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class RequestLoan {
    @Id
    private String id;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
}
