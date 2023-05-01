package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryBook extends JpaRepository<Book,String> {
}
