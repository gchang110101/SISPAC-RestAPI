package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "fk_employee_user"))
public class Employee extends SystemUser {

    @Column(unique = true)
    private String cardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_employee_departmentID"))
    @JsonIgnore
    private Department department;
}
