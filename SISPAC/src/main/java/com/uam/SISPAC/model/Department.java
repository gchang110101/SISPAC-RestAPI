package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Employee> facultyTeachers;
}
