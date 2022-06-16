package com.example.solidbankapp;

import com.example.solidbankapp.LISTING.AccountListingService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void depositMoney(String clientID) throws Exception {
        transactionDeposit.execute(accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber()), withdrawDepositOperationCLIUI.requestClientAmount());

    }
}
