package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.model.inventory.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface IServiceAuthor {
    public List<Author> getAll();

    public Author save(Author author);

    public void deleteById(String id);
}

