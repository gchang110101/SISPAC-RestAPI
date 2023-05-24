package com.uam.SISPAC.model.loans;

import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.model.humanresources.SystemUser;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "RequestLoan")
@Data
@Table(name = "RequestLoan", schema = "Loans")
public class RequestLoan {
    @Id
    private String id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @ManyToMany
    @JoinTable(
            name = "book_request",
            schema = "Loans",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @ManyToOne
    private SystemUser systemUser;

}
