package edu.csumb.Webstore.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.Webstore.model.User;

@Component
public class UserSeeder implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        User buttersdu = new User("buttersdu", "130347cw");
        User LHammer9804 = new User("LHammer9804", "Camperdown143");

        userRepository.deleteAll();
        List<User> users = Arrays.asList(buttersdu, LHammer9804);
        userRepository.saveAll(users);
    }
}