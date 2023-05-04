package com.uam.SISPAC.model;

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

    @Enumerated(EnumType.STRING)
    private CopyStatus copyStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @ManyToMany(mappedBy = "copies")
    List<Loan> loans;
}
