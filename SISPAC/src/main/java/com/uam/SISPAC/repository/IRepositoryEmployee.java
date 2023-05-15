package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryEmployee extends JpaRepository<Employee, String> {

}
