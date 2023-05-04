package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Faculty;
import com.uam.SISPAC.repository.IRepositoryFaculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServiceFaculty")
public class ServiceFaculty implements IServiceFaculty {
    @Autowired
    private IRepositoryFaculty repo;

    @Override
    public void createFaculty(Faculty faculty) {
        repo.save(faculty);
    }

    @Override
    public void deleteFaculty(String id) {
        repo.deleteById(id);
    }

    @Override
    public Faculty get(String id) {
        //voy a preguntarle al profe sobre esto, parece que es con algo de Optional
        return null;
    }

    @Override
    public List<Faculty> getAll() {
         return repo.findAll();
    }
}
