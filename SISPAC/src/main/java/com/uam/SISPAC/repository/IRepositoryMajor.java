package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryMajor extends JpaRepository<Major, String> {

}
