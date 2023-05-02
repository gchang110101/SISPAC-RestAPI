package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Department;
import com.uam.SISPAC.repository.IRepositoryDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServiceDepartment")
public class ServiceDepartment implements IServiceDepartment {

    @Autowired
    private IRepositoryDepartment repo;

    @Override
    public void createDepartment(Department department) {
        repo.save(department);
    }

    @Override
    public void deleteDepartment(String id) {
        repo.deleteById(id);
    }

    @Override
    public Department get(String id) {
        //return repo.findById(id);
        return null;
    }

    @Override
    public List<Department> getAll() {
        return repo.findAll();
    }
}
