package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryDepartment extends JpaRepository<Department, String> {


}
