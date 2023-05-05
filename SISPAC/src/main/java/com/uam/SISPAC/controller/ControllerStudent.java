package com.uam.SISPAC.controller;

import com.uam.SISPAC.model.Student;
import com.uam.SISPAC.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class ControllerStudent {

    @Autowired
    @Qualifier("ServiceStudent")
    private ServiceStudent serviceStudent;

    @GetMapping("/all")
    public List<Student> getAll() {
        return serviceStudent.studentGetAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) throws Exception {
        serviceStudent.studentCreate(student);
    }
}
