package com.example.solidbankapp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "user_table")
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(value = "id")
    private int id;
    @Column(value = "username")
    private String username;
    @Column(value = "password")
    private String password;
    @Column(value = "role_id")
    private int role_id;


}
