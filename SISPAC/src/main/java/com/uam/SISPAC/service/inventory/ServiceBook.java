package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.BookDto;
import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.model.inventory.Copy;
import com.uam.SISPAC.model.inventory.CopyStatus;
import com.uam.SISPAC.repository.inventory.*;
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

    @Autowired
    private IRepositoryCopy repositoryCopy;


    @Override
    public List<Book> getAll() {
        return repoBook.findAll();
    }

    @SneakyThrows
    @Override
    public void save(BookDto bookDto) {
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

        repoBook.save(insertBook);

        if (insertBook.getExistence() > 0) {
            int cantCopies =  repositoryCopy.findAll().size();
            String copy_id;
            for (int i = 0; i < insertBook.getExistence(); i++) {
                copy_id =  "C-" + (i + 1 + cantCopies);
                repositoryCopy.save(new Copy(
                        copy_id,
                        i + 1,
                        null,
                        CopyStatus.AVAILABLE,
                        insertBook
                ));
            }
        }


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
    public List<Book> getManyByAuthor(String authorName) {
        List<Book> requestBooks = repoBook.getBooksByAuthor(authorName);
        List<Book> responseBooks = new ArrayList<>();

        //is the list is null, from not assigning anything from the query (repoBook method)
        if(requestBooks != null)
            responseBooks = requestBooks;

        return responseBooks;
    }

    @Override
    public List<Book> getManyByClassification(String classificationName) {
        List<Book> requestBooks = repoBook.getBookByClassification(classificationName);
        List<Book> responseBooks = new ArrayList<>();

        //is the list is null, from not assigning anything from the query (repoBook method)
        if(requestBooks != null)
            responseBooks = requestBooks;

        return responseBooks;
    }

    @Override
    public List<Book> getManyByPublisher(String publisherName) {
        List<Book> requestBooks = repoBook.getBookByPublisher(publisherName);
        List<Book> responseBooks = new ArrayList<>();

        //is the list is null, from not assigning anything from the query (repoBook method)
        if(requestBooks != null)
            responseBooks = requestBooks;

        return responseBooks;
    }
}

