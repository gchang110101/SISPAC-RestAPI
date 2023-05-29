package com.uam.SISPAC.service.inventory;
import com.uam.SISPAC.dto.inventory.ClassificationDto;
import com.uam.SISPAC.model.inventory.Book;
import com.uam.SISPAC.model.inventory.Classification;
import com.uam.SISPAC.repository.inventory.IRepositoryClassification;
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
    public Classification save(@RequestBody ClassificationDto classificationDto) {

        Classification classification = new Classification(
                classificationDto.getIdClassification(),
                classificationDto.getClassificationName()
        );
        return repo.save(classification);
    }

    @Override
    public void deleteById(String id) {repo.deleteById(id);}

}
