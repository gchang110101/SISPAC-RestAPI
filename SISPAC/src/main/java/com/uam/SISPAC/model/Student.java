package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Student")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_student_user"))
public class Student extends SystemUser {

    @Column(unique = true)
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "majorId",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_student_majorID"))
    private Major major;
}
