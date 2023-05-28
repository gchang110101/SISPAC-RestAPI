package com.uam.SISPAC.controller.inventory;

import com.uam.SISPAC.dto.inventory.AuthorDto;
import com.uam.SISPAC.model.inventory.Author;
import com.uam.SISPAC.service.inventory.IServiceAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class ControllerAuthor {
    @Qualifier("ServiceAuthor")
    @Autowired
    public IServiceAuthor serviceAuthor;
    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAll() {
        List<Author> authorList = serviceAuthor.getAll();
        //return serviceAuthor.getAll();
        return new ResponseEntity<>(authorList,HttpStatus.OK);
    }
    @PostMapping("/save")
    public Author saveAuthor(@RequestBody AuthorDto author) {
        return serviceAuthor.save(author);
    }
    @PutMapping(value = "/update")
    public Author updateAuthor(@RequestBody AuthorDto author) throws Exception {
        if (author.getAuthorId() == null) {
            throw new Exception("Please, send the Id vallue");
        }
        return serviceAuthor.save(author);
    }
    @DeleteMapping(value="/delete/{id}")
    public void deleteLibro(@PathVariable String id) {
        serviceAuthor.deleteById(id);
    }
}

