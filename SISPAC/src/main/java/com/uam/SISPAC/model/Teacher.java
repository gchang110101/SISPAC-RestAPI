package com.uam.SISPAC.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Teacher")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_teacher_user"))
public class Teacher extends SystemUser {

    @Column(unique = true)
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "facultyId",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_teacher_facultyID"))
    private Faculty faculty;
}
