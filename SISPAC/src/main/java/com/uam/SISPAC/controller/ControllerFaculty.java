package com.uam.SISPAC.controller;

import com.uam.SISPAC.model.Department;
import com.uam.SISPAC.model.Faculty;
import com.uam.SISPAC.service.IServiceFaculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class ControllerFaculty {
    @Autowired
    @Qualifier("ServiceFaculty")
    private IServiceFaculty serviceFaculty;

    @GetMapping("/all")
    public List<Faculty> getAll() {
       return serviceFaculty.getAll();
    }

    @PostMapping("/save")
    public void saveFaculty(@RequestBody Faculty faculty) {
        serviceFaculty.createFaculty(faculty);
    }

    @PutMapping("/update")
    public void updateFaculty(@RequestBody Faculty faculty) throws Exception {
        if (faculty.getId().equals(null))
            throw new Exception("No ID value found");
        serviceFaculty.createFaculty(faculty);
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteFaculty(@PathVariable String id) {
        serviceFaculty.deleteFaculty(id);
    }
}
