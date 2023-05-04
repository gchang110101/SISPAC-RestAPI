package com.uam.SISPAC.controller;

import com.uam.SISPAC.model.RequestLoan;
import com.uam.SISPAC.model.SystemUser;
import com.uam.SISPAC.repository.IRepositorySystemUser;
import com.uam.SISPAC.service.IServiceRequest;
import com.uam.SISPAC.service.IServiceRequestLibrarian;
import com.uam.SISPAC.service.IServiceRequestUser;
import com.uam.SISPAC.service.IServiceSystemUser;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requestLoan")
public class ControllerRequestLoan {
    @Autowired
    @Qualifier("ServiceRequestUser")
    private IServiceRequestUser iServiceRequestUser;
    @Autowired
    private IRepositorySystemUser iRepositorySystemUser;

    @Autowired
    private IServiceRequestLibrarian iServiceRequestLibrarian;

    @GetMapping("/all/{id}")
    public List<RequestLoan> getAll(@PathVariable String id) {
        return iServiceRequestUser.requestCheck(iRepositorySystemUser.findById(id).get());
    }

    @PostMapping("/save")
    public void createRequestLoan(@RequestBody RequestLoan requestLoan) {
        iServiceRequestUser.requestCreate(requestLoan);
    }

    @PutMapping("/update")
    public void updateRequestLoan(@RequestBody RequestLoan requestLoan) throws Exception {
        if (requestLoan.getId() == null)
            throw new Exception("No ID value found");
        iServiceRequestUser.requestCreate(requestLoan);
    }

    @PutMapping("/accept")
    public void acceptLoan(@RequestBody RequestLoan requestLoan) throws Exception {
        if (requestLoan.getId() == null)
            throw new Exception("No ID value found");
        iServiceRequestLibrarian.requestAccept(requestLoan);
    }
    @PutMapping("/denny")
    public void dennyLoan(@RequestBody RequestLoan requestLoan) throws Exception {
        if (requestLoan.getId() == null)
            throw new Exception("No ID value found");
        iServiceRequestLibrarian.requestDeny(requestLoan);
    }
    @DeleteMapping("/cancel")
    public void cancelRequest(@PathVariable String id) {
        iServiceRequestUser.requestCancel(id);
    }
}
