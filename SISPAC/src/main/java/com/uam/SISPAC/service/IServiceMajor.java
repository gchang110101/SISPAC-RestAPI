package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Major;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceMajor {
    public void createMajor(Major major);
    public void deleteMajor(String id);
    public Major get(String id);
    public List<Major> getAll();
}
