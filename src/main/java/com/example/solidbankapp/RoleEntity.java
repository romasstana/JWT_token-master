package com.example.solidbankapp;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

    @Column(value = "id")
    private @Id int id;
    @Column(value = "name")
    private String name;


//    @Override
//    public String toString() {
//
//        return "Account{" +
//                ", id='" + id + '\'' +
//                ", clientID='" + clientId + '\'' +
//                ", balance=" + balance +
//                '}';
//    }
}
