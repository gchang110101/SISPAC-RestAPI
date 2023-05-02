package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    private String ISBN;
    private String MFN;
    private String title;
    private Integer existence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Classification classifications;
}
