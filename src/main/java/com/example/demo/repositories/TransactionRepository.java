package com.example.demo.repositories;

import com.example.demo.entities.Transaction;
import jakarta.persistence.Convert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //@Query (value = "select t.id, t.dateTime, t.sum from Transaction t")
    List<Transaction> findByLimitExceededTrue();
}
