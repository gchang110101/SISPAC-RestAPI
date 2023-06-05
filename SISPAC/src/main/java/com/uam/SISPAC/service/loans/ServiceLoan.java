package com.uam.SISPAC.service.loans;

import com.uam.SISPAC.dto.loans.LoanDto;
import com.uam.SISPAC.model.inventory.Copy;
import com.uam.SISPAC.model.loans.Loan;
import com.uam.SISPAC.model.loans.LoanStatus;
import com.uam.SISPAC.repository.humanresources.IRepositorySystemUser;
import com.uam.SISPAC.repository.inventory.IRepositoryBook;
import com.uam.SISPAC.repository.inventory.IRepositoryCopy;
import com.uam.SISPAC.repository.loans.IRepositoryLoan;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Component("ServiceLoan")
public class ServiceLoan implements IServiceLoan{
    @Autowired
    private IRepositoryLoan repoLoan;

    @Autowired
    private IRepositorySystemUser repositorySystemUser;

    @Autowired
    private IRepositoryCopy repositoryCopy;

    @Autowired
    private IRepositoryBook repositoryBook;


    @SneakyThrows
    @Override
    public void loanCreate(LoanDto loanDto) {
        //DTO constructor
        Loan loan = new Loan(
                loanDto.getDateIssued(),
                loanDto.getReturnDate(),
                LocalDate.now(),    //sets the current date, had too many issues with formatting and db constraint
                //loanDto.getId(),
                "LNBK-" + loanDto.getUsername() + "-" + (repoLoan.findAll().size() + 1),
                LoanStatus.ONTIME   //it's also the "default" value on the DB table
        );

        //System.out.println(loan.getDateCreated());

        //if no return date is assigned
        if (loan.getReturnDate() == null)
            throw new Exception("no se ha mandado fecha de retorno");

        //if no emission date is assigned
        if(loan.getDateIssued() == null)
            throw new Exception("no se ha mandado fecha de emisión");

        //if user does not exist
        if (!repositorySystemUser.existsById(loanDto.getUsername())) {
            throw new Exception("username no valido");
        }

        //user attachment
        loan.setSystemUser(repositorySystemUser.findById(loanDto.getUsername()).get());

        //if no books are sent
        if (loanDto.getBookISBNList() == null || loanDto.getBookISBNList().isEmpty())
            throw new Exception("no se han agregado libros al préstamo");

        //if there are repeated books
        boolean repeated = false;

        for (int i = 0; i < loanDto.getBookISBNList().size(); i++) {
            String book_isbn = loanDto.getBookISBNList().get(i);

            for (int j = 0; j < loanDto.getBookISBNList().size(); j++) {
                if(j == i)
                    continue;

                if(book_isbn.equals(loanDto.getBookISBNList().get(j)))
                    repeated = true;
            }
        }

        if (repeated)
            throw new Exception("uno o más libros están repetidos");

        //copy list
        List<Copy> copies = new ArrayList<>();

        //copy assignment according to books requested
        for (String isbn: loanDto.getBookISBNList()) {

            if (!repositoryBook.existsById(isbn)) {
                throw new Exception("uno de los libros no existe");     //if one of the books does not exist

            } else {

                String assign_copy_id = repositoryCopy.getAvailableCopyID(isbn);    //each copy_id to assign

                if (assign_copy_id != null) {
                    copies.add(repositoryCopy.findById(assign_copy_id).get());      //if found, attach by adding to copy list

                } else {
                    throw new Exception("copia no existe o no se encontraron disponibles");    //copy not found, assign_copy_id is null
                }
            }
        }

        //copy list attachment
        loan.setCopies(copies);

        repoLoan.save(loan);
    }

    @Override
    public void loanDelete(String id) {
        repoLoan.deleteById(id);
    }

    @Override
    public List<Loan> checkLoans() {
        return repoLoan.findAll();
    }

    @Override
    @SneakyThrows
    public void loanEnd(String id) {

        if (!repoLoan.existsById(id))
            throw new Exception("no existe el préstamo");

        Loan findLoan = repoLoan.findById(id).get();

        if (findLoan.getLoanStatus() == LoanStatus.DONELATE
                || findLoan.getLoanStatus() == LoanStatus.DONEONTIME)
            throw new Exception("el préstamo ya está finalizado");

        if (findLoan.getLoanStatus() == LoanStatus.ONTIME)
            findLoan.setLoanStatus(LoanStatus.DONEONTIME);
        else
            findLoan.setLoanStatus(LoanStatus.DONELATE);

        repoLoan.save(findLoan);
    }

    @Override
    @SneakyThrows
    public List<Loan> getByUser(String user) {
        return repoLoan.getLoansByUser(user);
    }

    @Override
    public List<Loan> getByNames(String names) {
        return repoLoan.getLoansByNames(names);
    }

    @Override
    public List<Loan> getByLastNames(String last_names) {
        return repoLoan.getLoansByLastNames(last_names);
    }

    @Override
    public List<Loan> getByBook(String book_isbn) {
        return repoLoan.getLoansByBook(book_isbn);
    }

    @Override
    public List<Loan> getByCopy(String copy_id) {
        return repoLoan.getLoansByCopy(copy_id);
    }
}
