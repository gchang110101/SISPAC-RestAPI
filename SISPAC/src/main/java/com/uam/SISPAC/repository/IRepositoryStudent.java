package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryStudent extends JpaRepository<Student, String> {

}
