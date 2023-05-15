package com.uam.SISPAC.service;

import com.uam.SISPAC.model.RequestLoan;
import com.uam.SISPAC.model.RequestStatus;
import com.uam.SISPAC.model.SystemUser;
import com.uam.SISPAC.repository.IRepositoryRequestLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceRequestLibrarian implements IServiceRequestLibrarian {

    @Autowired
    IRepositoryRequestLoan repositoryRequestLoan;
    @Override
    public List<RequestLoan> requestCheck(SystemUser systemUser) {
        if (systemUser == null) {
            return repositoryRequestLoan.findAll();
        }
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
    public void requestAccept(RequestLoan requestLoan) {
        requestLoan.setRequestStatus(RequestStatus.CONFIRMED);
        repositoryRequestLoan.save(requestLoan);
    }

    @Override
    public void requestDeny(RequestLoan requestLoan) {
        requestLoan.setRequestStatus(RequestStatus.DENIED);
        repositoryRequestLoan.save(requestLoan);
    }
}
