package com.uam.SISPAC.model.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)

    private List <Book> books;

}
