package com.uam.SISPAC.controller.loans;


import com.uam.SISPAC.dto.loans.LoanDto;
import com.uam.SISPAC.model.loans.Loan;
import com.uam.SISPAC.service.loans.IServiceLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@CrossOrigin("192.*.*.*")
public class ControllerLoan {

    @Qualifier("ServiceLoan")
    @Autowired
    private IServiceLoan serviceLoan;

    @GetMapping("/all")
    public List<Loan> checkLoans() {
        return serviceLoan.checkLoans();
    }
    @PostMapping("/save")
    public void loanCreate(@RequestBody LoanDto loan) {
        serviceLoan.loanCreate(loan);
    }
    @PutMapping(value = "/update")
    public void loanUpdate(@RequestBody LoanDto loan) throws Exception {
        if (loan.getId() == null) {
            throw new Exception("Por favor, envía id");
        }
        serviceLoan.loanCreate(loan);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void loanDelete(@PathVariable String id) {
        serviceLoan.loanDelete(id);
    }
}
