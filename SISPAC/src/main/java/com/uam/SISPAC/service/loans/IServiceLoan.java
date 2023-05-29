package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.dto.loans.LoanDto;
import com.uam.SISPAC.model.loans.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceLoan {

    public void loanCreate(LoanDto loan);

    public void loanDelete(String id);

    public List<Loan> checkLoans();

}
