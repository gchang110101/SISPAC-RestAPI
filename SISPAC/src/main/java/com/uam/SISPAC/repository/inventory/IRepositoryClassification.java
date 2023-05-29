package com.uam.SISPAC.repository.inventory;

import com.uam.SISPAC.model.inventory.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryClassification extends JpaRepository<Classification,String> {
}
