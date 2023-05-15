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
        if (bookDto.getId() == null) {
            throw new Exception("Please, send the Id vallue");
        }
        return service.save(bookDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void bookDelete(@PathVariable String id) {
        service.deleteById(id);
    }

}