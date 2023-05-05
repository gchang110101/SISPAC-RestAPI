package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceStudent {
    public List<Student> studentGetAll();
    public void studentCreate(Student student) throws Exception;
}
