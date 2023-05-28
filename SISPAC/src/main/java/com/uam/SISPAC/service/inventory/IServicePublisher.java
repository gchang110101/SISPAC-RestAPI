package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.ClassificationDto;
import com.uam.SISPAC.dto.inventory.PublisherDto;
import com.uam.SISPAC.model.inventory.Classification;
import com.uam.SISPAC.model.inventory.Publisher;

import java.util.List;

public interface IServicePublisher {

    public List<Publisher> getAll();

    public Publisher save(PublisherDto publisherDto);

    public void deleteById(String id);
}
