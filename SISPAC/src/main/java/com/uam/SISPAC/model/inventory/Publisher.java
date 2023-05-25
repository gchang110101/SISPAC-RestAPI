package com.uam.SISPAC.model.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Publisher", schema = "Inventory")
public class Publisher {
    @Id
    private String id;
    private String name;
}