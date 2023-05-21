package com.uam.SISPAC.service.loans;


import com.uam.SISPAC.model.loans.RequestLoan;
import org.springframework.stereotype.Service;

@Service
public interface IServiceRequestUser extends IServiceRequest {

    public void requestCreate(RequestLoan requestLoan);

    public void requestCancel(String id);

}
