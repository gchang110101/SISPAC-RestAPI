package com.uam.SISPAC.service;

import com.uam.SISPAC.model.RequestLoan;

public interface IServiceRequestLibrarian extends IServiceRequest {
    public void requestAccept(RequestLoan requestLoan);
    public void requestDeny(RequestLoan requestLoan);
}
