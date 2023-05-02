package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Author;
import com.uam.SISPAC.model.Book;
import com.uam.SISPAC.repository.IRepositoryAuthor;
import com.uam.SISPAC.repository.IRepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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
    public Author save(@RequestBody Author author) {
        List<Book> books = author.getBooks();
        List<Book> datos = new ArrayList<>();
        Author author1 = new Author();
        author1.setName(author.getName());
        author1.setBooks(author.getBooks());

        for(Book book : books){
            Book l = new Book();
            l.setAuthor(author1);
            l.setTitle(book.getTitle());
            datos.add(l);

        }
        author1.setBooks(datos);
        return repo.save(author1);
    }

    @Override
    public void deleteById(String id) {repo.deleteById(id);}
}
