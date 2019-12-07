package com.cursodsousa.libraryapi.model.repository;

import com.cursodsousa.libraryapi.model.entity.Book;
import com.cursodsousa.libraryapi.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(" select case when ( count(l.id) > 0 ) then true else false end " +
           " from Loan l where l.book = :book and l.returned is not true )  ")
    boolean existsByBookAndNotReturned( Book book );

}
