package com.uam.SISPAC.dto.loans;

import com.uam.SISPAC.model.loans.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class LoanDto {
    private LocalDate dateIssued;
    private LocalDate returnDate;
    //private LocalDate dateCreated;
    //private String id;
    //private LoanStatus loanStatus;
    private String username;
    private List<String> bookISBNList;
}
