package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceDepartment {
    public void createDepartment(Department department);
    public void deleteDepartment(String id);
    public Department get(String id);
    public List<Department> getAll();
}
