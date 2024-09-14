package com.financeTracker.FinanceTracker.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeTracker.FinanceTracker.BalanceInfo;
import com.financeTracker.FinanceTracker.Respository.BalanceInfoRepository;

@Service
public class BalanceInfoService {
    
    @Autowired
    public BalanceInfoRepository balanceInfoRepository;

    public BalanceInfo updateBalance(BigDecimal currentBalance, BigDecimal totalIncome, BigDecimal totalExpense) {
        BalanceInfo balanceInfo = balanceInfoRepository.findById(1L).orElseThrow();

        balanceInfo.settotal_income(totalIncome);
        balanceInfo.settotal_expense(totalExpense);
        balanceInfo.setCurrentBalance(currentBalance);

        BalanceInfo updatedBalance = balanceInfoRepository.save(balanceInfo);

        return new BalanceInfo(
            updatedBalance.getCurrentBalance(),
            updatedBalance.getTotalIncome(),
            updatedBalance.getTotalExpense()
        );
    }

    public List<BalanceInfo> getBalanceInfo(){
        return balanceInfoRepository.findAll();
    }

    // public BalanceInfo addBalanceInfo(BigDecimal current_balance, BigDecimal total_income, BigDecimal total_expense){
    //     BalanceInfo balanceInfo = new BalanceInfo(current_balance, total_income, total_expense);
    //     return balanceInfoRepository.save(balanceInfo);
    // }
}
