package com.uam.SISPAC.model.humanresources;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_librarian_user"))
@Table(schema = "humanresources")
public class Librarian extends SystemUser {

    @Enumerated(EnumType.STRING)
    private LibrarianRole librarianRole;
}
