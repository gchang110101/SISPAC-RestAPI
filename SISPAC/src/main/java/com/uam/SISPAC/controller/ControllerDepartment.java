package com.uam.SISPAC.controller;

import com.uam.SISPAC.model.Department;
import com.uam.SISPAC.service.IServiceDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class ControllerDepartment {
    @Qualifier("ServiceDepartment")
    @Autowired
    private IServiceDepartment serviceDepartment;

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return serviceDepartment.getAll();
    }

    @PostMapping("/save")
    public void saveDepartment(@RequestBody Department department) {
        serviceDepartment.createDepartment(department);
    }

    @PutMapping("/update")
    public void updateDepartment(@RequestBody Department department) throws Exception {
        if (department.getId().equals(null))
            throw new Exception("No ID value found");
        serviceDepartment.createDepartment(department);
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteDepartment(@PathVariable String id) {
        serviceDepartment.deleteDepartment(id);
    }
}
