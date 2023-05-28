package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.dto.loans.LoanDto;
import com.uam.SISPAC.model.loans.Loan;
import com.uam.SISPAC.repository.humanresources.IRepositorySystemUser;
import com.uam.SISPAC.repository.loans.IRepositoryLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component("ServiceLoan")
public class ServiceLoan implements IServiceLoan{
    @Autowired
    private IRepositoryLoan repo;

    @Autowired
    IRepositorySystemUser repositorySystemUser;


    @Override
    public void loanCreate(LoanDto loanDto) {
        Loan loan = new Loan(
                loanDto.getDateIssued(),
                loanDto.getDateReturned(),
                loanDto.getDateAccepted(),
                loanDto.getId(),
                loanDto.getLoanStatus()
        );
        repo.save(loan);
    }
    @Override
    public void loanDelete(String id) {
        repo.deleteById(id);
    }
    @Override
    public List<Loan> checkLoans() {
        return repo.findAll();
    }
}
