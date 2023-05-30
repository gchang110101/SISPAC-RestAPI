package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.dto.loans.LoanDto;
import com.uam.SISPAC.model.inventory.Copy;
import com.uam.SISPAC.model.loans.Loan;
import com.uam.SISPAC.repository.humanresources.IRepositorySystemUser;
import com.uam.SISPAC.repository.inventory.IRepositoryCopy;
import com.uam.SISPAC.repository.loans.IRepositoryLoan;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component("ServiceLoan")
public class ServiceLoan implements IServiceLoan{
    @Autowired
    private IRepositoryLoan repo;

    @Autowired
    IRepositorySystemUser repositorySystemUser;

    @Autowired
    IRepositoryCopy repositoryCopy;


    @SneakyThrows
    @Override
    public void loanCreate(LoanDto loanDto) {
        Loan loan = new Loan(
                loanDto.getDateIssued(),
                loanDto.getReturnDate(),
                loanDto.getDateCreated(),
                loanDto.getId(),
                loanDto.getLoanStatus()
        );
        if (!repositorySystemUser.existsById(loanDto.getUsername())) {
            throw new Exception("username no valido");
        }
        loan.setSystemUser(repositorySystemUser.findById(loanDto.getUsername()).get());


        List<Copy> copies = new ArrayList<>();

        for (String id: loanDto.getCopies()) {
            if (!repositoryCopy.existsById(id)) {
                throw new Exception("una de las copias ingresadas no existe");
            }
        }

        for (String copy: loanDto.getCopies()) {
            copies.add(repositoryCopy.findById(copy).get());
        }
        loan.setCopies(copies);

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
