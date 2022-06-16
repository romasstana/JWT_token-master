package com.example.solidbankapp.ACCOUNT;

import com.example.solidbankapp.WITHDRAW.AccountWithdraw;

public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
