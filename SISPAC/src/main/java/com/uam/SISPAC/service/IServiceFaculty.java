package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceFaculty {
    public void createFaculty(Faculty faculty);
    public void deleteFaculty(String id);
    public Faculty get(String id);
    public List<Faculty> getAll();
}
