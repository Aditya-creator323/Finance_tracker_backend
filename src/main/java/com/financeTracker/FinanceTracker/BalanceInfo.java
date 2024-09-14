package com.financeTracker.FinanceTracker;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "balance_info")
public class BalanceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal current_balance;

    @Column(nullable = false)
    private BigDecimal total_income;

    @Column(nullable = false)
    private BigDecimal total_expense;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCurrentBalance() {
        return current_balance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        current_balance = currentBalance;
    }

    public BigDecimal getTotalIncome() {
        return total_income;
    }

    public void settotal_income(BigDecimal totalIncome) {
        total_income = totalIncome;
    }

    public BigDecimal getTotalExpense() {
        return total_expense;
    }

    public void settotal_expense(BigDecimal totalExpense) {
        total_expense = totalExpense;
    }

    public BalanceInfo() {}

    public BalanceInfo(BigDecimal currentBalance, BigDecimal totalIncome, BigDecimal totalExpense) {
        current_balance = currentBalance;
        total_income = totalIncome;
        total_expense = totalExpense;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((current_balance == null) ? 0 : current_balance.hashCode());
        result = prime * result + ((total_income == null) ? 0 : total_income.hashCode());
        result = prime * result + ((total_expense == null) ? 0 : total_expense.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BalanceInfo other = (BalanceInfo) obj;
        if (current_balance == null) {
            if (other.current_balance != null)
                return false;
        } else if (!current_balance.equals(other.current_balance))
            return false;
        if (total_income == null) {
            if (other.total_income != null)
                return false;
        } else if (!total_income.equals(other.total_income))
            return false;
        if (total_expense == null) {
            if (other.total_expense != null)
                return false;
        } else if (!total_expense.equals(other.total_expense))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BalanceInfo [current_balance=" + current_balance + ", total_income=" + total_income
                + ", total_expense=" + total_expense + "]";
    }

    
}
