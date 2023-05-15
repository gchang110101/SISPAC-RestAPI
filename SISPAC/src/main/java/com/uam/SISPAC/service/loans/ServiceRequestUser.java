package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.model.loans.RequestLoan;
import com.uam.SISPAC.model.humanresources.SystemUser;
import com.uam.SISPAC.repository.loans.IRepositoryRequestLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component("ServiceRequestUser")
public class ServiceRequestUser implements IServiceRequestUser{

    @Autowired
    IRepositoryRequestLoan repositoryRequestLoan;
    @Override
    public List<RequestLoan> requestCheck(SystemUser systemUser) {
        List<RequestLoan> all = repositoryRequestLoan.findAll();
        List<RequestLoan> filter = new ArrayList<>();

        for (RequestLoan req:all) {
            if (req.getSystemUser().getId() == systemUser.getId()) {
                filter.add(req);
            }
        }
        return filter;
    }
    @Override
    public void requestCreate(RequestLoan requestLoans) {
        repositoryRequestLoan.save(requestLoans);
    }

    @Override
    public void requestCancel(String id) {
        repositoryRequestLoan.deleteById(id);
    }
}
