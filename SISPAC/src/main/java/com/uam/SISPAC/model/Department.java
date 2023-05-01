package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Department")
public class Department {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    private List<Employee> facultyTeachers;
}
