package com.uam.SISPAC.service;
import com.uam.SISPAC.model.Classification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceClassification {
    public List<Classification> getAll();

    public Classification save(Classification classification);

    public void deleteById(String id);
}
