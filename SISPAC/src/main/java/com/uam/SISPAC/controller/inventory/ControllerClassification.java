package com.uam.SISPAC.controller.inventory;

import com.uam.SISPAC.model.inventory.Classification;
import com.uam.SISPAC.service.inventory.IServiceClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification")
@CrossOrigin("*")
public class ControllerClassification {

    @Qualifier("ServiceClassification")
    @Autowired
    public IServiceClassification serviceClassification;
    @GetMapping("/all")
    public ResponseEntity<List<Classification>> getAll() {
        List<Classification> classificationList = serviceClassification.getAll();
        //return serviceClassification.getAll();
        return new ResponseEntity<>(classificationList, HttpStatus.OK);
    }
    @PostMapping("/save")
    public Classification saveClassification(@RequestBody Classification classification) {
        return serviceClassification.save(classification);
    }
    @PutMapping(value = "/update")
    public Classification updateClassification(@RequestBody Classification classification) throws Exception {
        if (classification.getId() == null) {
            throw new Exception("Please, send the Id vallue");
        }
        return serviceClassification.save(classification);
    }
    @DeleteMapping(value="/delete/{id}")
    public void deleteClassificaction(@PathVariable String id) {
        serviceClassification.deleteById(id);
    }
}
