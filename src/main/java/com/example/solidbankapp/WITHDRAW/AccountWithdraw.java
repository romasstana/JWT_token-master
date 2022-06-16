package com.example.solidbankapp.WITHDRAW;

import com.example.solidbankapp.ACCOUNT.Account;
import org.springframework.stereotype.Component;


public class AccountWithdraw extends Account {
    public AccountWithdraw(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
