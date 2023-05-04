package com.uam.SISPAC.service;
import com.uam.SISPAC.model.Book;
import com.uam.SISPAC.model.Classification;
import com.uam.SISPAC.repository.IRepositoryClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
@Component("ServiceClassification")
public class ServiceClassification implements IServiceClassification{
    @Autowired
    private IRepositoryClassification repo;

    @Override
    public List<Classification> getAll() {return repo.findAll();}

    @Override
    public Classification save(@RequestBody Classification classification) {

        List<Book> classifications = classification.getClassifications();
        List<Book> datos = new ArrayList<>();
        Classification classification1 = new Classification();
        classification1.setName(classification.getName());
        classification1.setClassifications(classification.getClassifications());
        classification1.setId(classification.getId());

        for(Book book : classifications){
            Book l = new Book();
            l.setClassifications(book.getClassifications());
            datos.add(l);

        }
        classification1.setClassifications(datos);
        return repo.save(classification1);
    }

    @Override
    public void deleteById(String id) {repo.deleteById(id);}

}
