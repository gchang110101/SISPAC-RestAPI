package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Copy {
    @Id
    private String id;
    private int number;
    private String location;

    @Enumerated(EnumType.STRING)
    private CopyStatus copyStatus;

    @ManyToMany(mappedBy = "copies")
    List<Loan> loans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Book book;
}
