package com.uam.SISPAC.repository.inventory;

import com.uam.SISPAC.model.inventory.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAuthor extends JpaRepository<Author,String> {
}
