package com.uam.SISPAC.controller;

import com.uam.SISPAC.model.Major;
import com.uam.SISPAC.service.IServiceMajor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/major")
public class ControllerMajor {
    @Autowired
    @Qualifier("ServiceMajor")
    private IServiceMajor serviceMajor;

    @GetMapping("/all")
    public List<Major> getAllMajors() {
        return serviceMajor.getAll();
    }

    @PostMapping("/save")
    public void saveMajor(@RequestBody Major major) {
        serviceMajor.createMajor(major);
    }

    @PutMapping("/update")
    public void updateMajor(@RequestBody Major major) throws Exception {
        if (major.getId().equals(null))
            throw new Exception("No ID value found");
        serviceMajor.createMajor(major);
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteMajor(@PathVariable String id) {
        serviceMajor.deleteMajor(id);
    }
}
