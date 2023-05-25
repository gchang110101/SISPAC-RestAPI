package com.uam.SISPAC.model.inventory;

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
@Table(name = "Book", schema = "Inventory")
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Copy> copy;

    //BookDTO constructor
    public Book(String isbn, String mfn, String title, Integer existence) {
        this.ISBN = isbn;
        this.MFN = mfn;
        this.title = title;
        this.existence = existence;
    }
}
