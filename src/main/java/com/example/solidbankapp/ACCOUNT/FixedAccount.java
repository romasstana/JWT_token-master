package com.example.solidbankapp.ACCOUNT;

import com.example.solidbankapp.DEPOSIT.AccountDeposit;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
