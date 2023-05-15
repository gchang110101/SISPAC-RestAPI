package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.model.loans.RequestLoan;
import com.uam.SISPAC.model.humanresources.SystemUser;


import java.util.List;

public interface IServiceRequest {
    public List<RequestLoan> requestCheck(SystemUser systemUser);
}
