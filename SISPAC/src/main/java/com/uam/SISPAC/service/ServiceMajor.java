package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Faculty;
import com.uam.SISPAC.model.Major;
import com.uam.SISPAC.repository.IRepositoryFaculty;
import com.uam.SISPAC.repository.IRepositoryMajor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServiceMajor")
public class ServiceMajor implements IServiceMajor {

    @Autowired
    private IRepositoryMajor repo;

    @Autowired
    private IRepositoryFaculty repo2;

    @Override
    public void createMajor(Major major) { //no terminado
        Major insertMajor = new Major();
        insertMajor.setId(major.getId());
        insertMajor.setName(major.getName());

        //Faculty insertFaculty = repo2.findById(major.getId()).get();

        Faculty insertFaculty = repo2.findById(major.getFaculty().getId()).get();

        insertMajor.setFaculty(insertFaculty);
        insertMajor.setMajorStudents(null);
        repo.save(insertMajor);
    }

    @Override
    public void deleteMajor(String id) {
        repo.deleteById(id);
    }

    @Override
    public Major get(String id) {
        return null;
    }

    @Override
    public List<Major> getAll() {
        return repo.findAll();
    }
}
