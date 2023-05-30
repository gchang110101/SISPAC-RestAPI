package com.uam.SISPAC.model.inventory;

import com.fasterxml.jackson.annotation.*;
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
public class Publisher {
    @Id
    private String id;
    private String name;

    public Publisher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> books;

}
