package com.example.solidbankapp.DAO;

import com.example.solidbankapp.ACCOUNT.Account;
import com.example.solidbankapp.WITHDRAW.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDAO extends CrudRepository<Account, String> {
    //@Query("SELECT * from Account where clientId=:clientId")
    //List<Account> getClientAccounts(String clientID);
    @Query("SELECT * from Account a where a.client_id=:clientId")
    List<Account> findAccountsByClientId(String clientId);

//    List<Account> findAccountsByClientID(String clientID);
    @Modifying
    @Query("INSERT INTO Account(id, account_type, client_id, balance, withdrawal_allowed) values (:id, :type, :clientId, :balance, :withdrawAllowed)")
    void createNewAccount(String id, String type, String clientId, double balance, boolean withdrawAllowed);
    @Modifying
    @Query("UPDATE Account a SET a.balance = :balance where id=:accountId AND client_id=:clientId")
    void updateAccount(String accountId, String clientId, double balance);
    //List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    @Query("SELECT * FROM Account a WHERE a.id =:accountID AND a.client_id =:clientID AND a.withdrawal_allowed =true")
    Account getClientWithdrawAccount(String clientID, String accountID);
    @Query("SELECT * FROM Account WHERE Id=:accountID AND client_id=:clientID")
    Account getClientAccount(String clientID, String accountID);
    @Modifying
    @Query("DELETE FROM Account where id=:accountId")
    void deleteAccount(String accountId);
}
