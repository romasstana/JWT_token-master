package com.example.solidbankapp.CREATE;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.ACCOUNT.AccountType;
import com.example.solidbankapp.DAO.AccountDAO;
import com.example.solidbankapp.ACCOUNT.FixedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountCreationServiceImpl implements AccountCreationService {

    AccountDAO accountDAO;
    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account account = null;
        String accountNumber = String.format("%03d%06d", 1, accountID);
        switch (accountType){
            case FIXED:
//                accountDAO.createNewAccount(String.format("%03d%06d", 1, accountID),"FIXED", clientID, 0.0, false);
//                System.out.println("Bank account created");
                accountDAO.createNewAccount( String.format("%03d%06d", 1, accountID),"FIXED", clientID, 0.0, false);
                System.out.println("Bank account created");
                break;
            case CHECKING:
                accountDAO.createNewAccount( String.format("%03d%06d", 1, accountID),"CHECKING", clientID, 0.0, true);
                System.out.println("Bank account created");
                break;
            case SAVING :
                accountDAO.createNewAccount( String.format("%03d%06d", 1, accountID),"SAVING", clientID, 0.0, true);
                System.out.println("Bank account created");
                break;
        }
//        accountDAO.createNewAccount(account);
    }
}
