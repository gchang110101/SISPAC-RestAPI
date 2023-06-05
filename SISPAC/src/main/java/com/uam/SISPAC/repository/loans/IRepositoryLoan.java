package com.uam.SISPAC.repository.loans;

import com.uam.SISPAC.model.loans.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRepositoryLoan extends JpaRepository<Loan, String> {
    @Query("select e from Loan e where e.systemUser.cif = :user")
    List<Loan> getLoansByUser(@Param("user") String user);

    @Query("select e from Loan e where e.systemUser.names = :names")
    List<Loan> getLoansByNames(@Param("names") String names);

    @Query("select e from Loan e where e.systemUser.lastNames = :last_names")
    List<Loan> getLoansByLastNames(@Param("last_names") String last_names);

    @Query("select e from Loan e join e.copies c where c.book.ISBN = :book_isbn")
    List<Loan> getLoansByBook(@Param("book_isbn") String book_isbn);

    @Query("select e from Loan e join e.copies c where c.id = :copy_id")
    List<Loan> getLoansByCopy(@Param("copy_id") String copy_id);
}
