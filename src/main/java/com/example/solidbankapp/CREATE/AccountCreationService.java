package com.example.solidbankapp.CREATE;

import com.example.solidbankapp.ACCOUNT.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
