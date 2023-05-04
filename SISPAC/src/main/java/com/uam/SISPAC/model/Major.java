package com.uam.SISPAC.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_major_facultyID"))
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    private Faculty faculty;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Student> majorStudents;
}
