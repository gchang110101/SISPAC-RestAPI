package com.uam.SISPAC.controller;


import com.uam.SISPAC.model.Loan;
import com.uam.SISPAC.service.IServiceLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class ControllerLoan {

    @Qualifier("ServiceLoan")
    @Autowired
    private IServiceLoan serviceLoan;

    @GetMapping("/all")
    public List<Loan> checkLoans() {
        return serviceLoan.checkLoans();
    }
    @PostMapping("/save")
    public void loanCreate(@RequestBody Loan loan) {
        serviceLoan.loanCreate(loan);
    }
    @PutMapping("/update")
    public void loanUpdate(@RequestBody Loan loan) throws Exception {
        if (loan.getId() == null) {
            throw new Exception("Por favor, envía id");
        }
        serviceLoan.loanCreate(loan);
    }
    @DeleteMapping("/delete/{id}")
    public void loanDelete(@PathVariable Long id) {
        serviceLoan.loanDelete(id);
    }
}
