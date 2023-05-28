package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.BookDto;
import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.repository.inventory.IRepositoryAuthor;
import com.uam.SISPAC.repository.inventory.IRepositoryBook;
import com.uam.SISPAC.repository.inventory.IRepositoryClassification;
import com.uam.SISPAC.repository.inventory.IRepositoryPublisher;
import lombok.Data;
import lombok.SneakyThrows;
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

    @Autowired
    private IRepositoryPublisher repositoryPublisher;


    @Override
    public List<Book> getAll() {
        return repoBook.findAll();
    }

    @SneakyThrows
    @Override
    public Book save(BookDto bookDto) {
        Book insertBook = new Book(
                bookDto.getIdBook(),
                bookDto.getMFN(),
                bookDto.getTitle(),
                bookDto.getExistence()
        );

        List<Author> authors = new ArrayList<>();

        for (String id: bookDto.getAuthorsId()) {
            if (!repoAuthor.existsById(id)) {
                throw new Exception("Uno o muchos de los autores ingresados no son válidos");
            }
        }

        List<Author> authorList = new ArrayList<>();

        for (String id : bookDto.getAuthorsId()) {
            authorList.add(repoAuthor.findById(id).get());
        }

        insertBook.setAuthors(authorList);


        if (!repoClassification.existsById(bookDto.getClassificationId())) {
            throw new Exception("La classification ingresada no es valida");
        }

        insertBook.setClassification(repoClassification.findById(bookDto.getClassificationId()).get());

        if (!repositoryPublisher.existsById(bookDto.getPublisherId())) {
            throw new Exception("El editorial ingresado no es valido");
        }

        insertBook.setPublisher(repositoryPublisher.findById(bookDto.getPublisherId()).get());

        /*

        //attach author through DTO foreign id parameter (if they exist)
        if(bookDto.getAuthorsId() == null)
            insertBook.setAuthors(null);
        else if(!repoAuthor.existsById(bookDto.getAuthorsId().toString()))
            insertBook.setAuthors(null);
        else
            insertBook.setClassification(null);

        //attach classification through DTO foreign id parameter (if they exist)
        if(bookDto.getClassificationId() == null)
            insertBook.setAuthors(null);
        else if(!repoClassification.existsById(bookDto.getClassificationId()))
            insertBook.setClassification(null);
        else
            insertBook.setClassification(repoClassification.findById(bookDto.getClassificationId()).get());

        /*
        if(bookDto.getPublisherId() == null)
            insertBook.setAuthors(null);
        else if(!repoClassification.existsById(bookDto.getClassificationId()))
            insertBook.setClassification(null);
        else
            insertBook.setClassification(repoClassification.findById(bookDto.getClassificationId()).get());

        //copy null for now
        insertBook.setCopy(null);
        */

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

