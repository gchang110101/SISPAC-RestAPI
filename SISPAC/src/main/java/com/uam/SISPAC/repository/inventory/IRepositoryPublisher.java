package com.uam.SISPAC.repository.inventory;


import com.uam.SISPAC.model.inventory.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPublisher extends JpaRepository<Publisher, String> {
}
