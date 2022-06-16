package com.example.solidbankapp;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.LISTING.AccountListingService;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TransactionWithdrawCLI {

    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }
    public void withdrawMoney(String clientID) throws Exception {
        String accountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        Account account = accountListingService.getClientAccount(clientID, accountId);

        transactionWithdraw.execute(account, amount);

    }
}
