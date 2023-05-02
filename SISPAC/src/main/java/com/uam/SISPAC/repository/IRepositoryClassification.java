package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryClassification extends JpaRepository<Classification,String> {
}
