package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.BookDto;
import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.repository.inventory.IRepositoryAuthor;
import com.uam.SISPAC.repository.inventory.IRepositoryBook;
import com.uam.SISPAC.repository.inventory.IRepositoryClassification;
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
    private IRepositoryBook repoBook;
    @Autowired
    private IRepositoryAuthor repoAuthor;
    @Autowired
    private IRepositoryClassification repoClassification;

    @Override
    public List<Book> getAll() {
        return repoBook.findAll();
    }

    @Override
    public Book save(BookDto bookDto) {
        Book insertBook = new Book(
                bookDto.getIdBook(),
                bookDto.getMFN(),
                bookDto.getTitle(),
                bookDto.getExistence()
        );

        //attach author through DTO foreign id parameter (if they exist)
        if(bookDto.getAuthorId() == null)
            insertBook.setAuthor(null);
        else if(!repoAuthor.existsById(bookDto.getAuthorId()))
            insertBook.setAuthor(null);
        else
            insertBook.setClassifications(null);

        //attach classification through DTO foreign id parameter (if they exist)
        if(bookDto.getClassificationId() == null)
            insertBook.setAuthor(null);
        else if(!repoClassification.existsById(bookDto.getClassificationId()))
            insertBook.setClassifications(null);
        else
            insertBook.setClassifications(repoClassification.findById(bookDto.getClassificationId()).get());

        //copy null for now
        insertBook.setCopy(null);

        return repoBook.save(insertBook);
    }

    @Override
    public void deleteById(String id) {
        repoBook.deleteById(id);
    }

    @Override
    public Book getOneByISBN(String isbn) {
        Book requestBook = repoBook.getBookByISBN(isbn);
        Book responseBook = new Book();

        if(requestBook != null)
            responseBook = requestBook;

        return responseBook;
    }

    @Override
    public Book getOneByMFN(String mfn) {
        Book requestBook = repoBook.getBookByMFN(mfn);
        Book responseBook = new Book();

        if(requestBook != null)
            responseBook = requestBook;

        return responseBook;
    }

    @Override
    public Book getOneByTitle(String title) {
        Book requestBook = repoBook.getBookByTitle(title);
        Book responseBook = new Book();

        if(requestBook != null)
            responseBook = requestBook;

        return responseBook;
    }

    @Override
    public Book getBookByAuthor(String authorName) {
        return null;
    }

    @Override
    public Book getBookByClassification(String classificationName) {
        return null;
    }
}

