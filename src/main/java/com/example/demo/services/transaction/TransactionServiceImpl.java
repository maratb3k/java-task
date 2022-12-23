package com.example.demo.services.transaction;

import com.example.demo.dtos.CurrencyEnum;
import com.example.demo.entities.Category;
import com.example.demo.entities.ExchangeRate;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, CategoryRepository categoryRepository, UserRepository userRepository, ExchangeRateRepository exchangeRateRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        Category category = categoryRepository.findById(transaction.getAccount_to()).orElse(null);
        User user = userRepository.findById(transaction.getAccount_from()).orElse(null);
        transaction.transferFromUser(user, category);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public String deleteTransaction(long id) {
        transactionRepository.deleteById(id);
        return "Transaction #" + id + " deleted";
    }

    @Override
    public List<Transaction> findByLimitExceededTrue() throws IllegalAccessException {
        List<Transaction> transactions = transactionRepository.findByLimitExceededTrue();
        List<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();
        Double getUSDCloseValue = 0.0;
        for(int i = exchangeRates.size() - 1; i >= 0; i--) {
            getUSDCloseValue = exchangeRates.get(i).getCloseValue();
            if(getUSDCloseValue != null) {
                break;
            }
        }
        List<Object> result = new ArrayList<>();

        for(int i = 0; i < transactions.size(); i++) {
            transactions.get(i).setSum(transactions.get(i).getSum() / getUSDCloseValue);
            transactions.get(i).setCurrency(CurrencyEnum.USD);
        }
        return transactions;
    }

}
