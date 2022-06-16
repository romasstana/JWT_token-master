//package com.example.solidbankapp.DAO;
//
//import com.example.solidbankapp.ACCOUNT.Account;
//import com.example.solidbankapp.ACCOUNT.AccountType;
//import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
//import com.example.solidbankapp.DAO.AccountDAO;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//@Component
//public class MemoryAccountDAO implements AccountDAO {
//    List<Account> accountList = new ArrayList<>();
//    @Override
//    public List<Account> getClientAccounts(String clientID) {
//        return accountList;
//    }
//
//    @Override
//    public void createNewAccount(Account account) {
//        accountList.add(account);
//    }
//
//    @Override
//    public void updateAccount(Account account) {
//
//    }
//
//    @Override
//    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
//        List<Account> list= new ArrayList<>();
//        for(Account s: accountList){
//            if(s.getClientID().equals(clientID)){
//                list.add(s);
//                return list;
//            }
//        }
//        return list;
//    }
//
//    @Override
//    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
//        for(Account accW: accountList){
//            if(accW.getId().equals(accountID)){
//                return (AccountWithdraw) accW;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Account getClientAccount(String clientID, String accountID) {
//        List<Account> list= new ArrayList<>();
//        for(Account s: accountList){
//            if(s.getId().equals(accountID)){
//                return s;
//            }
//        }
//        return null;
//    }
//}
