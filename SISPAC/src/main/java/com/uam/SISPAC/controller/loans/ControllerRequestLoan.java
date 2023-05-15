package com.uam.SISPAC.controller.loans;

import com.uam.SISPAC.model.loans.RequestLoan;
import com.uam.SISPAC.repository.humanresources.IRepositorySystemUser;
import com.uam.SISPAC.service.loans.IServiceRequestLibrarian;
import com.uam.SISPAC.service.loans.IServiceRequestUser;
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
