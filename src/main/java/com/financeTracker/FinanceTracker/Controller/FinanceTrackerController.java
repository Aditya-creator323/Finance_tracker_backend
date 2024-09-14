package com.financeTracker.FinanceTracker.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financeTracker.FinanceTracker.BalanceInfo;
import com.financeTracker.FinanceTracker.Transaction;
import com.financeTracker.FinanceTracker.Services.BalanceInfoService;
import com.financeTracker.FinanceTracker.Services.TransactionService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class FinanceTrackerController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public TransactionService transactionService;

    @Autowired
    public BalanceInfoService balanceInfoService;

    @GetMapping("/transactions")
    public List<Transaction> transaction() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/addTransaction")
    public Transaction addTransaction(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "amount") String amount,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "tag") String tag,
            @RequestParam(value = "type") String type) {

        // Convert amount (String) to BigDecimal
        BigDecimal amountBigDecimal = new BigDecimal(amount);

        // Convert date (String) to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateLocal = LocalDate.parse(date, formatter);

        return transactionService.addTransaction(name, amountBigDecimal, dateLocal, tag, type);
    }

    @GetMapping("/getBalanceInfo")
    public List<BalanceInfo> getBalanceInfo() {
        List<BalanceInfo> newBalanceInfo = balanceInfoService.getBalanceInfo();

        System.out.println("Balance Info : " + newBalanceInfo);
        return newBalanceInfo;
        
        // return balanceInfoService.getBalanceInfo();
    }

    @PutMapping("/addBalanceInfo")
    public BalanceInfo addBalanceInfo(
            @RequestParam(value = "current_balance") String current_balance,
            @RequestParam(value = "total_income") String total_income,
            @RequestParam(value = "total_expense") String total_expense) {

        BigDecimal currentBalance = new BigDecimal(current_balance);
        BigDecimal totalIncome = new BigDecimal(total_income);
        BigDecimal totalExpense = new BigDecimal(total_expense);

        return balanceInfoService.updateBalance(currentBalance, totalIncome, totalExpense);
    }
}
