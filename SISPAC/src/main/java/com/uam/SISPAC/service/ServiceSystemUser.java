package com.uam.SISPAC.service;

import com.uam.SISPAC.model.SystemUser;
import com.uam.SISPAC.repository.IRepositorySystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ServiceSystemUser")
public class ServiceSystemUser implements IServiceSystemUser {
    @Autowired
    private IRepositorySystemUser repo;

    @Override
    public List<SystemUser> systemUserGetAll() {
        return repo.findAll();
    }

    @Override
    public void systemUserCreate(SystemUser systemUser) {
        repo.save(systemUser);
    }
}
