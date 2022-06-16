package com.example.solidbankapp.TRANSACTIONS;

import com.example.solidbankapp.ACCOUNT.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Account, String> {
    @Modifying
    @Query("INSERT INTO Transactions(id, transaction_type, client_id, amount, new_balance) " +
            " values (:id, :type, :clientId,:amount, :balance)")
    void addTransaction(String id, String type, String clientId, double amount, double balance);
    @Query("SELECT * From Transactions")
    List<Transaction> getAllTransactions(String clientId, String accountId);
}
