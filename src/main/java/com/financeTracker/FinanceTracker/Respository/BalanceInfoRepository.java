package com.financeTracker.FinanceTracker.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.financeTracker.FinanceTracker.BalanceInfo;

// Using Repository for the Person class we can perform CRUD operation on our tables
public interface BalanceInfoRepository extends JpaRepository<BalanceInfo, Long> {}
