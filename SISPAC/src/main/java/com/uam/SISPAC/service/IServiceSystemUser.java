package com.uam.SISPAC.service;

import com.uam.SISPAC.model.SystemUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceSystemUser {
    public List<SystemUser> systemUserGetAll();
    public void systemUserCreate(SystemUser systemUser);
    //public void systemUserUpdate(SystemUser systemUser);
}
