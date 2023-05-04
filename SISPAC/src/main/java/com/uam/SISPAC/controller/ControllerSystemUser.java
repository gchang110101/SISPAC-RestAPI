package com.uam.SISPAC.controller;

import com.uam.SISPAC.model.SystemUser;
import com.uam.SISPAC.service.IServiceSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemuser")
public class ControllerSystemUser {
    @Autowired
    @Qualifier("ServiceSystemUser")
    private IServiceSystemUser serviceSystemUser;

    @GetMapping("/all")
    public List<SystemUser> getAll() {
        return serviceSystemUser.systemUserGetAll();
    }

    @PostMapping("/save")
    public void saveSystemUser(@RequestBody SystemUser systemUser) {
        serviceSystemUser.systemUserCreate(systemUser);
    }

    @PutMapping("/update")
    public void updateSystemUser(@RequestBody SystemUser systemUser) throws Exception {
        if (systemUser.getId().equals(null))
            throw new Exception("No ID value found");
        serviceSystemUser.systemUserCreate(systemUser);
    }
}
