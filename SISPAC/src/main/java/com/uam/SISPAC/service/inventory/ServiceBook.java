package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.BookDto;
import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.repository.inventory.IRepositoryAuthor;
import com.uam.SISPAC.repository.inventory.IRepositoryBook;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
@Component("ServiceBook")
public class ServiceBook implements IServiceBook{

    @Autowired
    private IRepositoryBook repo;
    @Autowired
    private IRepositoryAuthor repo2;

    @Override
    public List<Book> getAll() {
        return repo.findAll();
    }

    @Override
    public Book save(BookDto bookDto) {
        Book l =  repo.findById(bookDto.getId()).get();
        Author author = repo2.findById(bookDto.getId()).get();
        l.setTitle(bookDto.getTitle());
        l.setAuthor(author);
        return repo.save(l);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }


}

