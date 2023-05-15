package com.uam.SISPAC.repository.inventory;

import com.uam.SISPAC.model.inventory.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryClassification extends JpaRepository<Classification,String> {
}
