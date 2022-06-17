package com.example.solidbankapp.roleAndUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserTable, Integer> {

    UserTable findByUsername(String username);


}
