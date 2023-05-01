package com.uam.SISPAC.service;

import com.uam.SISPAC.model.Loan;
import com.uam.SISPAC.repository.IRepositoryLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component("ServiceLoan")
public class ServiceLoan implements IServiceLoan{
    @Autowired
    private IRepositoryLoan repo;
    @Override
    public void loanCreate(Loan loan) {
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
