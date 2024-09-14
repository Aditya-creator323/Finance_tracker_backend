package com.financeTracker.FinanceTracker.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.financeTracker.FinanceTracker.Transaction;

// Using Repository for the Person class we can perform CRUD operation on our tables
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
