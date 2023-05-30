package com.uam.SISPAC.model.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uam.SISPAC.model.loans.Loan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "inventory")
public class Copy {
    @Id
    private String id;
    private Integer number;
    private String location;

    @Enumerated(EnumType.STRING)
    private CopyStatus copyStatus;


    @JsonIgnore
    @ManyToMany(mappedBy = "copies")
    List<Loan> loans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Book book;

    public Copy(String id, Integer number, String location, CopyStatus copyStatus) {
        this.id = id;
        this.number = number;
        this.location = location;
        this.copyStatus = copyStatus;
    }
    public Copy(String id, Integer number, String location, CopyStatus copyStatus, Book book) {
        this.id = id;
        this.number = number;
        this.location = location;
        this.copyStatus = copyStatus;
        this.book = book;
    }
}
