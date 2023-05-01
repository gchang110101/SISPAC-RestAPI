package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceLoan {

    public void loanCreate(Loan loan);

    public void loanDelete(String id);

    public List<Loan> checkLoans();

}
