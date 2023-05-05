package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Student;
import com.uam.SISPAC.model.SystemUser;
import com.uam.SISPAC.repository.IRepositoryStudent;
import com.uam.SISPAC.repository.IRepositorySystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServiceStudent")
public class ServiceStudent implements IServiceStudent {

    @Autowired
    private IRepositoryStudent repoStudent;

    @Autowired
    private IRepositorySystemUser repoSystemUser;

    @Override
    public List<Student> studentGetAll() {
        return repoStudent.findAll();
    }

    @Override
    public void studentCreate(Student student) throws Exception {
        if(!repoSystemUser.existsById(student.getId()))
            throw new Exception("No se encontró usuario existente para crear estudiante");

        if(repoSystemUser.existsById(student.getId())) {
            //student.setMajor(null);
            Student insertStudent = new Student();

            //atachar:
            SystemUser attachSystemUser = (repoSystemUser.findById(student.getId())).get();

            //set datos de entidad user attachada al ID del nuevo student
            insertStudent.setId(attachSystemUser.getId());
            System.out.println(insertStudent.getId());
            insertStudent.setCif(attachSystemUser.getCif());
            insertStudent.setStatus(attachSystemUser.getStatus());
            insertStudent.setNames(attachSystemUser.getNames());
            insertStudent.setLastNames(attachSystemUser.getLastNames());
            insertStudent.setPhoneNumber(attachSystemUser.getPhoneNumber());
            insertStudent.setUserType(attachSystemUser.getUserType());
            insertStudent.setRequestLoans(attachSystemUser.getRequestLoans());

            //set datos para student ya con datos attachados
            insertStudent.setCardNumber(student.getCardNumber());
            insertStudent.setMajor(student.getMajor());

            //guardar insertStudent
            repoStudent.save(insertStudent);
        }
    }
}
