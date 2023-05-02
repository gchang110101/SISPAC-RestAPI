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
public class Location {
    @Id
    private String id;
    private String name;


    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Copy> copy;

}
