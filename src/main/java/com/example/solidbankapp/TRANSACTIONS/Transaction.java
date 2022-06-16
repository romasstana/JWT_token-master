package com.example.solidbankapp.TRANSACTIONS;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.DateTimeException;
import java.util.Date;

@Table(name = "TRANSACTIONS")
@Data
@AllArgsConstructor
public class Transaction {
    @Column(value = "id")
    private String id;
    @Column(value = "transaction_type")
    private String transactionType;
    @Column(value = "client_id")
    private String clientId;
    @Column(value = "amount")
    private double amount;
    @Column(value = "new_balance")
    private double balance;


}
