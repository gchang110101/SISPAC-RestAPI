package com.uam.SISPAC.repository.inventory;

import com.uam.SISPAC.model.inventory.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRepositoryCopy extends JpaRepository<Copy, String> {
    @Query("select e from Copy e where e.book.ISBN = :book")
    public List<Copy> getCopyByBook(@Param("book") String book);

    //get first available copy of a loan book requested
    @Query(value =
            "select top(1) id from [Inventory].[Copy]" +
                    " inner join Inventory.Book on book_ISBN = ISBN " +
                    "where book_ISBN = :isbn and copyStatus = 'AVAILABLE'"
            , nativeQuery = true)   //lets you use your database engine's native dialect
    public String getAvailableCopyID(@Param ("isbn") String isbn);
}
