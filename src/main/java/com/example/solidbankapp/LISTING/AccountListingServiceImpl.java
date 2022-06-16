package com.example.solidbankapp.LISTING;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.ACCOUNT.AccountType;
import com.example.solidbankapp.DAO.AccountDAO;
import com.example.solidbankapp.LISTING.AccountListingService;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountListingServiceImpl implements AccountListingService {
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) throws Exception {
        Account account = accountDAO.getClientAccount(clientID, accountID);
        if(account == null){
            throw new Exception("Account not found");
        }
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        Account account = accountDAO.getClientAccount(clientID, accountID);
        if(account==null|| !account.isWithdrawAllowed()){
            return null;
        }
        return new AccountWithdraw( account.getId(), account.getAccountType(),account.getClientId(), account.getBalance(), account.isWithdrawAllowed());
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
//        return accountDAO.findAccountsByClientId(clientID);
        return accountDAO.findAccountsByClientId(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }
}
