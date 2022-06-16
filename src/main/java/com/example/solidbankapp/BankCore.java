package com.example.solidbankapp;

import com.example.solidbankapp.ACCOUNT.AccountType;
import com.example.solidbankapp.CREATE.AccountCreationService;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    static long id = 1;
    long lastAccountNumber = 1;

    AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientID){
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }
    private void incrementLastAccountNumber(){
        lastAccountNumber++;
    }
}
