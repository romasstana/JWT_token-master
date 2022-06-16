package com.example.solidbankapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserTable, Integer> {

    UserTable findByUsername(String username);


}
