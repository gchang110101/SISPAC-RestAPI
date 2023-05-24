package com.uam.SISPAC.model.humanresources;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Librarian", schema = "HumanResources")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_librarian_user"))
public class Librarian extends SystemUser {

    @Enumerated(EnumType.STRING)
    private LibrarianRole librarianRole;
}
