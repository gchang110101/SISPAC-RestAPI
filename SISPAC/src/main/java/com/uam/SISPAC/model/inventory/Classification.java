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
public class Classification {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "classification",cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books;

    public Classification(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
