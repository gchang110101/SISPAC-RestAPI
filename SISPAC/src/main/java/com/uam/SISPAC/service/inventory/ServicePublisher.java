package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.PublisherDto;
import com.uam.SISPAC.model.inventory.Publisher;
import com.uam.SISPAC.repository.inventory.IRepositoryPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServicePublisher")
public class ServicePublisher implements IServicePublisher{

    @Autowired
    IRepositoryPublisher repositoryPublisher;

    @Override
    public List<Publisher> getAll() {
        return repositoryPublisher.findAll();
    }

    @Override
    public Publisher save(PublisherDto publisherDto) {

        Publisher publisher = new Publisher(
          publisherDto.getPublisherId(),
          publisherDto.getPublisherName()
        );

        return repositoryPublisher.save(publisher);
    }

    @Override
    public void deleteById(String id) {
        repositoryPublisher.deleteById(id);

    }
}
