package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.AuthorDto;
import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.repository.inventory.IRepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@Component("ServiceAuthor")

public class ServiceAuthor implements IServiceAuthor {

    @Autowired
    private IRepositoryAuthor repo;

    @Override
    public List<Author> getAll() {
        return repo.findAll();
    }

    @Override
    public Author save(@RequestBody AuthorDto authorDto) {
        Author author = new Author(
                authorDto.getAuthorId(),
                authorDto.getAuthorName()
        );
        return repo.save(author);
    }

    @Override
    public void deleteById(String id) {repo.deleteById(id);}
}
