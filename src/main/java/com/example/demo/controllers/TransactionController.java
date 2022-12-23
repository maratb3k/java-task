package com.example.demo.controllers;

import com.example.demo.entities.Transaction;
import com.example.demo.services.transaction.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/transactions/")
public class TransactionController {
    private TransactionServiceImpl transactionService;


    @Autowired
    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> findAllTransactions() {
        return transactionService.getTransactions();
    }

    @GetMapping(path = "/transaction/{id}")
    public Transaction findTransactionByID(@PathVariable long id) {
        return transactionService.getTransaction(id);
    }

    @PutMapping(path = "/{id}/")
    public Transaction updateTransaction(@PathVariable long id, @RequestBody Transaction transaction) {
        transaction.setId(id);
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTransaction(@PathVariable long id) {
        return transactionService.deleteTransaction(id);
    }

    @GetMapping("limitExceeded=true")
    public List<Transaction> getWhereLimitExceededTrue() throws IllegalAccessException {
        return transactionService.findByLimitExceededTrue();
    }
}
