package com.example.demo.services.transaction;

import com.example.demo.entities.Category;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;

import java.util.Collection;
import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    Transaction getTransaction(long id);
    List<Transaction> getTransactions();
    Transaction updateTransaction(Transaction transaction);
    String deleteTransaction(long id);

    public List<Transaction> findByLimitExceededTrue() throws IllegalAccessException;
}
