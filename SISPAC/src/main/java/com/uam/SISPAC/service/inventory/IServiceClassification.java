package com.uam.SISPAC.service.inventory;
import com.uam.SISPAC.dto.inventory.ClassificationDto;
import com.uam.SISPAC.model.inventory.Classification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceClassification {
    public List<Classification> getAll();

    public Classification save(ClassificationDto classification);

    public void deleteById(String id);
}
