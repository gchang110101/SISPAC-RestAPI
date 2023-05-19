package com.uam.SISPAC.controller.inventory;

import com.uam.SISPAC.dto.inventory.BookDto;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.service.inventory.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
@CrossOrigin("*")
public class ControllerBook {
    @Qualifier("ServiceBook")
    @Autowired
    private IServiceBook service;

    @GetMapping("/all")
    public List<Book> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public Book save(@RequestBody BookDto book) {
        return service.save(book);
    }

    @PutMapping(value = "/update")
    public Book updateBook(@RequestBody BookDto bookDto) throws Exception {
        if (bookDto.getIdBook() == null) {
            throw new Exception("Please, send the Id value");
        }
        return service.save(bookDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void bookDelete(@PathVariable String id) {
        service.deleteById(id);
    }

    @GetMapping("/one/byisbn/{isbn}")
    public Book getByISBN(@PathVariable String isbn) {
        return service.getOneByISBN(isbn);
    }

    @GetMapping("/one/bytitle/{title}")
    public Book getByTitle(@PathVariable String title) {
        return service.getOneByTitle(title);
    }

    @GetMapping("/one/bymfn/{mfn}")
    public Book getByMFN(@PathVariable String mfn) {
        return service.getOneByMFN(mfn);
    }

    @GetMapping("/some/byauthor/{authorName}")
    public List<Book> getByAuthorID(@PathVariable String authorName) {
        return service.getBookByAuthor(authorName);
    }

    @GetMapping("/some/byclassification/{classificationName}")
    public List<Book> getByClassificationID(@PathVariable String classificationName) {
        return service.getBookByClassification(classificationName);
    }
}