package com.example.solidbankapp.ACCOUNT;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {


    @Column(value = "id")
    private @Id String id;
    @Column(value = "account_type")
    private String accountType;

    @Column(value = "client_id")
    private String clientId;
    @Column(value = "balance")
    private double balance;
    @Column(value = "withdrawal_allowed")
    private boolean withdrawAllowed;


    @Override
    public String toString() {

        return "Account{" +
                ", id='" + id + '\'' +
                ", clientID='" + clientId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
