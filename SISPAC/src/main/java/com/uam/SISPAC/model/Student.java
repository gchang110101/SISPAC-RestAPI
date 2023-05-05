package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uam.SISPAC.Embeddables.StudentId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Student")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_student_user"))
/*
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id"))

})
*/

public class Student extends SystemUser {

    @Column(unique = true)
    private String cardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorId",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_student_majorID"))
    @JsonIgnore
    private Major major;
}
