package com.uam.SISPAC.repository.loans;


import com.uam.SISPAC.model.loans.RequestLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryRequestLoan extends JpaRepository<RequestLoan, String> {

}
