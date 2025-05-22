package com.academia.Users.services;


import com.academia.Users.models.UserModel;
import com.academia.Users.models.UserRoleEnum;
import com.academia.Users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataMigration implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public DataMigration(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            String encodedPassword = passwordEncoder.encode("12345678");
            UserModel admin = new UserModel("admin", "admin@example.com", encodedPassword, UserRoleEnum.ADMIN);
            userRepository.save(admin);
        }
    }
}
