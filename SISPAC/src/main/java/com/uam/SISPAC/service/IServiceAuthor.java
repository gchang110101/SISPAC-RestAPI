package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Author;
import com.uam.SISPAC.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface IServiceAuthor {
    public List<Author> getAll();

    public Author save(Author author);

    public void deleteById(String id);
}

