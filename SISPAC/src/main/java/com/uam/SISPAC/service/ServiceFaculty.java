package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Faculty;
import com.uam.SISPAC.model.Major;
import com.uam.SISPAC.repository.IRepositoryFaculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component("ServiceFaculty")
public class ServiceFaculty implements IServiceFaculty {
    @Autowired
    private IRepositoryFaculty repo;

    @Override
    public void createFaculty(Faculty faculty) {
        //lista nueva
        List<Major> insertMajors = new ArrayList<>();

        //lista de majors actuales
        List<Major> facMajors = faculty.getFacultyMajors();

        for (Major facMaj: facMajors) {
            Major insertMajor = new Major();
            insertMajor.setId(facMaj.getId());

            //System.out.println(insertMajor.getId());

            insertMajor.setName(facMaj.getName());
            insertMajor.setFaculty(faculty);

            //debugging
            System.out.println(insertMajor.getFaculty().getId());

            insertMajor.setMajorStudents(null);
            insertMajors.add(insertMajor);
        }
        faculty.setFacultyMajors(insertMajors);

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
