package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "RequestLoan")
@AllArgsConstructor
@NoArgsConstructor
public class RequestLoan {
    @Id
    private String id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @ManyToMany
    @JoinTable(
            name = "reqest_book",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "isbn"))
    private List<Book> books;

    @ManyToOne
    private SystemUser systemUser;
}
