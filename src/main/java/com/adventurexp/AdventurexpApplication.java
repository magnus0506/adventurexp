package com.adventurexp;

import com.adventurexp.model.User;
import com.adventurexp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AdventurexpApplication {



    public static void main(String[] args) {
        SpringApplication.run(AdventurexpApplication.class, args);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "employee";
        String encodedPassword = passwordEncoder.encode(password);

        System.out.println();
        System.out.println("Password is         : " + password);
        System.out.println("Encoded Password is : " + encodedPassword);
        System.out.println("Invalid Password is : " + encodedPassword + "junk");
        System.out.println();

        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
        System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
    }

}
