package com.uam.SISPAC.repository.inventory;

import com.uam.SISPAC.model.inventory.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryBook extends JpaRepository<Book, String> {
    @Query("select b from Book b where b.ISBN = :isbn")
    public Book getBookByISBN(@Param("isbn") String isbn);

    @Query("select b from Book b where b.MFN = :mfn")
    public Book getBookByMFN(@Param("mfn") String mfn);

    @Query("select b from Book b where b.title = :title")
    public Book getBookByTitle(@Param("title") String title);

    @Query("select b from Book b where b.author.name = :authorName")
    public List<Book> getBookByAuthorId(@Param("authorName") String authorName);

    @Query("select b from Book b where b.classifications.name = :classificationName")
    public List<Book> getBookByClassificationId(@Param("classificationName") String classificationName);
}
