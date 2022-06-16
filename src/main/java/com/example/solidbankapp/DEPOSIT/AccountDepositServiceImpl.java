package com.example.solidbankapp.DEPOSIT;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.DAO.AccountDAO;
import com.example.solidbankapp.TRANSACTIONS.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    @Autowired
    AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void deposit(double amount, Account account){
        account.setBalance(account.getBalance()+amount);
        String str = String.format("%.2f", amount);
        System.out.println(str + "$ transferred to " + account.getId() + " account");
        accountDAO.updateAccount(account.getId(), account.getClientId(), account.getBalance());

    }
}
