package com.example.solidbankapp.WITHDRAW;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.DAO.AccountDAO;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import com.example.solidbankapp.WITHDRAW.AccountWithdrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    AccountDAO accountDAO;


    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void withdraw(Account account, double amount) throws Exception {
        if(account== null){
            System.out.println("EXCEPTION");
            throw new Exception("Account not found");
        }
        if(account.getAccountType()=="FIXED"){
            System.out.println("This is fixed account");
            throw new Exception("Fixed account");
        }
        if(account.getBalance()<=amount && account.getBalance()==0.0){
            throw new Exception("Not enough money");
        }
        if(account.getBalance()>=amount){
            account.setBalance(account.getBalance()-amount);
        String str = String.format("%.2f", amount);
        System.out.println(str+"$ transferred from " + account.getId() + " account");
            System.out.println(account.getAccountType()+ " account type");
        accountDAO.updateAccount(account.getId(), account.getClientId(), account.getBalance());
        }
    }
}
