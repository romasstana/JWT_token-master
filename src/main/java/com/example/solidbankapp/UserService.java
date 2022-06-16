package com.example.solidbankapp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userTableRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserTable saveUser(UserTable UserTable) {
        RoleEntity userRole = roleEntityRepository.findRoleEntityById(2);
        UserTable.setPassword(passwordEncoder.encode(UserTable.getPassword()));
        UserTable.setRole_id(userRole.getId());
        return userTableRepository.save(UserTable);
    }

    public UserTable findByLogin(String login) {
        return userTableRepository.findByUsername(login);
    }

    public UserTable findByLoginAndPassword(String login, String password) {
        UserTable UserTable = findByLogin(login);
        if (UserTable != null) {
            if (passwordEncoder.matches(password, UserTable.getPassword())) {
                return UserTable;
            }
        }
        return null;
    }
}