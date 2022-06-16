package com.example.solidbankapp.ACCOUNT;

import com.example.solidbankapp.LISTING.AccountListingService;
import com.example.solidbankapp.BankCore;
import com.example.solidbankapp.CREATE.CreateAccountOperationUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI{
    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListing;
    @Autowired
    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID){
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(),clientID);
    }
    public void getAccounts(String clientID){
        System.out.println(accountListing.getClientAccounts(clientID));
    }



}
