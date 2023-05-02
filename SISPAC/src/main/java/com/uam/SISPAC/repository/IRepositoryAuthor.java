package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAuthor extends JpaRepository<Author,String> {
}
