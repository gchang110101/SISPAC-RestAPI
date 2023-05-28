package com.uam.SISPAC.controller.inventory;


import com.uam.SISPAC.dto.inventory.PublisherDto;
import com.uam.SISPAC.model.inventory.Publisher;
import com.uam.SISPAC.service.inventory.IServicePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class ControllerPublisher {

    @Qualifier("ServicePublisher")
    @Autowired
    IServicePublisher servicePublisher;

    @GetMapping("/all")
    public List<Publisher> getAll() {
        return servicePublisher.getAll();
    }

    @PostMapping("/save")
    public Publisher save(@RequestBody PublisherDto publisherDto) {
        return servicePublisher.save(publisherDto);
    }

    @PutMapping("/update")
    public Publisher update(@RequestBody PublisherDto publisherDto) {
        return servicePublisher.save(publisherDto);
    }

    @DeleteMapping("/delete{id}")
    public void deleteById(@PathVariable String id) {
        servicePublisher.deleteById(id);
    }



}
