package com.uam.SISPAC.repository.loans;

import com.uam.SISPAC.model.loans.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryLoan extends JpaRepository<Loan, String> {

}
