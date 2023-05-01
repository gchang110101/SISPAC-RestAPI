package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Librarian")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_librarian_user"))
public class Librarian extends SystemUser {

    @Column(unique = true)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private LibrarianRole librarianRole;
}
