package com.uam.SISPAC.service;


import com.uam.SISPAC.model.RequestLoan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceRequestUser extends IServiceRequest {

    public void requestCreate(RequestLoan requestLoan);

    public void requestCancel(String id);

}
