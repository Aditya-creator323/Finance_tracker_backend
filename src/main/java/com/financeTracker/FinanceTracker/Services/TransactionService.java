package com.financeTracker.FinanceTracker.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeTracker.FinanceTracker.Transaction;
import com.financeTracker.FinanceTracker.Respository.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BalanceInfoService balanceInfoService;

    public List<Transaction> getAllTransactions() {
        // List<Transaction> allTransactions = new ArrayList<>();
        // allTransactions = transactionRepository.findAll();

        return transactionRepository.findAll();
    }

    public Transaction addTransaction(String name, BigDecimal amount, LocalDate date, String tag, String type) {
        Transaction transaction = new Transaction(name, amount, date, tag, type);
        return transactionRepository.save(transaction);
    }
}
