package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    private String ISBM;
    private String MFN;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Author author;
}
