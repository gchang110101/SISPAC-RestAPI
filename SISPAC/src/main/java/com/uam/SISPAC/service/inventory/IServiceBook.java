package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.BookDto;
import com.uam.SISPAC.model.inventory.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceBook {

    public List<Book> getAll();

    public Book save(BookDto bookDto);

    public void deleteById(String id);

    public Book getOneByISBN(String isbn);

    public Book getOneByMFN(String mfn);

    public Book getOneByTitle(String title);

    public List<Book> getManyByAuthor(String authorName);

    public List<Book> getManyByClassification(String classificationName);

    public List<Book> getManyByPublisher(String publisherName);
}
