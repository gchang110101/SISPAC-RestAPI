package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.model.loans.RequestLoan;

public interface IServiceRequestLibrarian extends IServiceRequest {
    public void requestAccept(RequestLoan requestLoan);
    public void requestDeny(RequestLoan requestLoan);
}
