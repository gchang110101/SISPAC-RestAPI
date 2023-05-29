package com.uam.SISPAC.repository.inventory;

import com.uam.SISPAC.model.inventory.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryAuthor extends JpaRepository<Author,String> {
}
