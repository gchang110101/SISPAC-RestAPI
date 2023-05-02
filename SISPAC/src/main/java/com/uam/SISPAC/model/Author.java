package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

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
