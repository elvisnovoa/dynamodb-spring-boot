package com.amazonaws.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        User user = new User();
		user.setFirstName("Chuck");
		user.setLastName("Norris");
        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);
    }

}
