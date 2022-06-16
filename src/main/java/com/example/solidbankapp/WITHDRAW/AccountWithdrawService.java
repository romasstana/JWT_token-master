package com.example.solidbankapp.WITHDRAW;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import org.springframework.stereotype.Component;

@Component
public interface AccountWithdrawService {
    void withdraw(Account account, double amount) throws Exception;
}
