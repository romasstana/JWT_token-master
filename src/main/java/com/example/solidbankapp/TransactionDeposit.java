package com.example.solidbankapp;

import com.example.solidbankapp.ACCOUNT.Account;

import com.example.solidbankapp.DEPOSIT.AccountDepositService;
import com.example.solidbankapp.TRANSACTIONS.Transaction;
import com.example.solidbankapp.TRANSACTIONS.TransactionRepository;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    @Autowired
    TransactionRepository transactionRepository;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionRepository transactionRepository) {
        this.accountDepositService = accountDepositService;
        this.transactionRepository = transactionRepository;
    }

    void execute(AccountWithdraw accountWithdraw, AccountWithdraw accountWithdraw2, double amount){

    }
    public void execute(Account account, double amount){
        accountDepositService.deposit(amount, account);
        Transaction transaction = new Transaction(account.getId(), "deposit", account.getClientId(), amount, account.getBalance());
        transactionRepository.addTransaction(transaction.getId(), transaction.getTransactionType(), transaction.getClientId(), transaction.getAmount(), transaction.getBalance());
    }


}
