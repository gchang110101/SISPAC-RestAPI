package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.AuthorDto;
import com.uam.SISPAC.model.inventory.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface IServiceAuthor {
    public List<Author> getAll();

    public Author save(AuthorDto author);

    public void deleteById(String id);
}

