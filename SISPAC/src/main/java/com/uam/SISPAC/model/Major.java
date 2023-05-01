package com.uam.SISPAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Major")
public class Major {
    @Id
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_major_facultyID"))
    private Faculty faculty;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    private List<Student> facultyTeachers;
}
