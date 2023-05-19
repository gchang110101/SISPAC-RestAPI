package com.uam.SISPAC.controller.humanresources;

import com.uam.SISPAC.dto.humanresources.LoginResponse;
import com.uam.SISPAC.model.humanresources.SystemUser;
import com.uam.SISPAC.service.humanresources.IServiceSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/systemuser")
@CrossOrigin("*")
public class ControllerSystemUser {
    @Autowired
    @Qualifier("ServiceSystemUser")
    private IServiceSystemUser serviceSystemUser;

    @GetMapping("/all")
    public List<SystemUser> getAll() {
        return serviceSystemUser.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody SystemUser systemUser) {
        serviceSystemUser.create(systemUser);
    }

    @PutMapping("/update")
    public void update(@RequestBody SystemUser systemUser) throws Exception {
        if (systemUser.getId().equals(null))
            throw new Exception("No ID value found");
        serviceSystemUser.create(systemUser);
    }

    @GetMapping("/one/{id}")
    public Optional<SystemUser> getOne(@PathVariable String id) {
        return serviceSystemUser.getOne(id);
    }

    @GetMapping("/login")
    public LoginResponse getLogin(@Param("cif") String cif, @Param("password") String password) {
        return serviceSystemUser.getUser(cif, password);
    }
}
