package com.uam.SISPAC.model.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "Inventory")
public class Author {
    @Id
    private String id;
    private String name;

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /*@OneToMany(mappedBy = "author",cascade = CascadeType.ALL
                ,fetch = FetchType.LAZY)/

         */
    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
