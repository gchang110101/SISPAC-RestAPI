package com.uam.SISPAC.service.humanresources;

import com.uam.SISPAC.dto.humanresources.LoginResponse;
import com.uam.SISPAC.model.humanresources.SystemUser;
import com.uam.SISPAC.repository.humanresources.IRepositorySystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component("ServiceSystemUser")
public class ServiceSystemUser implements IServiceSystemUser {
    @Autowired
    private IRepositorySystemUser repo;

    @Override
    public List<SystemUser> getAll() {
        return repo.findAll();
    }
    @Override
    public void create(SystemUser systemUser) {
        repo.save(systemUser);
    }
    @Override
    public Optional<SystemUser> getOne(String id) {
        return repo.findById(id);
    }

    @Override
    public LoginResponse getUser(String names, String password) {
        SystemUser u = repo.getSystemUserByCif(names, password);
        LoginResponse lr = new LoginResponse(false, "NOT CONNECTED");

        if(u != null) {
            lr.setSuccess(true);
            lr.setMsg("USER CONNECTED!");
        }

        return lr;
    }
}
