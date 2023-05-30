package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.CopyDto;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.model.inventory.Copy;
import com.uam.SISPAC.model.inventory.CopyStatus;
import com.uam.SISPAC.repository.inventory.IRepositoryBook;
import com.uam.SISPAC.repository.inventory.IRepositoryCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServiceCopy")
public class ServiceCopy implements IServiceCopy{

    @Autowired
    IRepositoryCopy repositoryCopy;

    @Autowired
    IRepositoryBook repositoryBook;


    @Override
    public Copy save(CopyDto copyDto) {
        Copy copy = new Copy(
                "C-" + (repositoryCopy.findAll().size() + 1),
                repositoryCopy.getCopyByBook(copyDto.getBookId()).size() + 1,
                copyDto.getLocation(),
                CopyStatus.AVAILABLE
        );

        Book book = repositoryBook.findById(copyDto.getBookId()).get();

        Integer existence = book.getExistence();
        book.setExistence(existence + 1);
        repositoryBook.save(book);
        copy.setBook(book);

        return repositoryCopy.save(copy);
    }

    public void deleteById(String id) {
        repositoryCopy.deleteById(id);
    }

    public List<Copy> getCopyByBook(String book) {
        return repositoryCopy.getCopyByBook(book);
    }
}
