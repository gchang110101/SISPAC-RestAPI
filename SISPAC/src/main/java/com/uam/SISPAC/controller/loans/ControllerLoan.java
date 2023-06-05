package com.uam.SISPAC.controller.loans;


import com.uam.SISPAC.dto.loans.LoanDto;
import com.uam.SISPAC.model.loans.Loan;
import com.uam.SISPAC.repository.loans.IRepositoryLoan;
import com.uam.SISPAC.service.loans.IServiceLoan;
import lombok.SneakyThrows;
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
    public void loanUpdate(@RequestBody LoanDto loan) {
        serviceLoan.loanCreate(loan);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void loanDelete(@PathVariable String id) {
        serviceLoan.loanDelete(id);
    }

    @PutMapping(value = "/end/{id}")
    @SneakyThrows
    public void loanEnd(@PathVariable String id) {
        if (id == null)
            throw new Exception("no se ha enviado ningún ID");

        serviceLoan.loanEnd(id);
    }

    @GetMapping(value = "/byuser/{user}")
    @SneakyThrows
    public List<Loan> getByUser(@PathVariable String user) {
        if (user == null)
            throw new Exception("no se ha enviado ningun user");
        return serviceLoan.getByUser(user);
    }

    @GetMapping(value = "/bynames/{names}")
    @SneakyThrows
    public List<Loan> getByNames(@PathVariable String names) {
        if (names == null)
            throw new Exception("no se han enviado nombres");
        return serviceLoan.getByNames(names);
    }

    @GetMapping(value = "/bylastnames/{last_names}")
    @SneakyThrows
    public List<Loan> getByLastNames(@PathVariable String last_names) {
        if (last_names == null)
            throw new Exception("no se han enviado apellidos");
        return serviceLoan.getByLastNames(last_names);
    }

    @GetMapping(value = "/bybookisbn/{book_isbn}")
    @SneakyThrows
    public List<Loan> getByBook(@PathVariable String book_isbn) {
        if (book_isbn == null)
            throw new Exception("no se ha enviado ningun ISBN");
        return serviceLoan.getByBook(book_isbn);
    }

    @GetMapping(value = "/bycopyid/{copy_id}")
    @SneakyThrows
    public List<Loan> getByCopy(@PathVariable String copy_id) {
        if (copy_id == null)
            throw new Exception("no se ha enviado ningun id de ejemplar");
        return serviceLoan.getByBook(copy_id);
    }
}
