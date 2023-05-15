package com.uam.SISPAC.model;

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
@Entity(name = "Faculty")
public class Faculty {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    //@JsonManagedReference
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonIgnore
    private List<Major> facultyMajors;


    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    //@JsonManagedReference
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonIgnore
    private List<Teacher> facultyTeachers;
}
