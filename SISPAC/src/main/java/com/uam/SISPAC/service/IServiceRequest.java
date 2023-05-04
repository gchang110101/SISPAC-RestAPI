package com.uam.SISPAC.service;

import com.uam.SISPAC.model.RequestLoan;
import com.uam.SISPAC.model.SystemUser;


import java.util.List;

public interface IServiceRequest {
    public List<RequestLoan> requestCheck(SystemUser systemUser);
}
