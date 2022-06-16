package com.example.solidbankapp.DEPOSIT;

import com.example.solidbankapp.ACCOUNT.Account;

public class AccountDeposit extends Account {
    public AccountDeposit(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
