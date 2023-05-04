package com.uam.SISPAC.model;

import jakarta.persistence.*;

import java.time.LocalDate;

public class RequestLoan {
    @Id
    private String id;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

}
