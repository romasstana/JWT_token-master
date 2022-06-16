package com.example.solidbankapp.DEPOSIT;

import com.example.solidbankapp.ACCOUNT.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountDepositService {
    void deposit(double amount, Account account);
}
