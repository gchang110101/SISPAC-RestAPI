package com.uam.SISPAC.service;

import com.uam.SISPAC.dto.BookDto;
import com.uam.SISPAC.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceBook {

    public List<Book> getAll();

    public Book save(BookDto bookDto);

    public void deleteById(String id);
}
