package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryFaculty extends JpaRepository<Faculty, String> {

}
