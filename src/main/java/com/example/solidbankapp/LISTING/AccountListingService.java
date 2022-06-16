package com.example.solidbankapp.LISTING;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.ACCOUNT.AccountType;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID) throws Exception;
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
