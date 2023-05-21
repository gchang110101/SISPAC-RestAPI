package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.repository.inventory.IRepositoryAuthor;
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
        author1.setId(author.getId());

        for(Book book : books){
            Book l = new Book();
            l.setAuthor(author1);
            l.setTitle(book.getTitle());
            l.setISBN(book.getISBN());
            l.setExistence(book.getExistence());
            l.setMFN(book.getMFN());
            datos.add(l);

        }
        author1.setBooks(datos);
        return repo.save(author1);
    }

    @Override
    public void deleteById(String id) {repo.deleteById(id);}
}
