package com.example.solidbankapp;

import com.example.solidbankapp.ACCOUNT.Account;

import com.example.solidbankapp.TRANSACTIONS.Transaction;
import com.example.solidbankapp.TRANSACTIONS.TransactionRepository;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import com.example.solidbankapp.WITHDRAW.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    @Autowired
    TransactionRepository transactionRepository;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionRepository transactionRepository) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionRepository = transactionRepository;
    }

    public void execute(Account account, double amount) throws Exception {
        accountWithdrawService.withdraw(account, amount);
        Transaction transaction = new Transaction(account.getId(), "withdraw", account.getClientId(),amount, account.getBalance());
        transactionRepository.addTransaction(transaction.getId(), transaction.getTransactionType(), transaction.getClientId(), transaction.getAmount(), transaction.getBalance());
    }
}
