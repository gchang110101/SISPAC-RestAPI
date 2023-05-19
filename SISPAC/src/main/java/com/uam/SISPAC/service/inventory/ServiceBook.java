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

import java.util.ArrayList;
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
            insertBook.setAuthor(repoAuthor.findById(bookDto.getAuthorId()).get());

        //attach classification through DTO foreign id parameter (if they exist)
        if(bookDto.getClassificationId() == null)
            insertBook.setClassifications(null);
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
    public List<Book> getBookByAuthor(String authorName) {
        List<Book> requestBooks = new ArrayList<>();
        requestBooks = repoBook.getBookByAuthorId(authorName);

        List<Book> responseBooks = new ArrayList<>();
        //System.out.println(requestBooks);
        //System.out.println(responseBooks);

        //if the list is empty (null), from not assigning anything from the query (repoBook method)
        if(!(requestBooks.isEmpty()))
            responseBooks = requestBooks;

        return responseBooks;
    }

    @Override
    public List<Book> getBookByClassification(String classificationName) {
        List<Book> requestBooks = repoBook.getBookByClassificationId(classificationName);
        List<Book> responseBooks = new ArrayList<>();

        //is the list is empty (null), from not assigning anything from the query (repoBook method)
        if(requestBooks != null)
            responseBooks = requestBooks;

        return responseBooks;
    }
}

