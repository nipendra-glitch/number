package com.number.service;

import com.number.entity.User;
import com.number.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NumberService {

    @Autowired
    UserRepo userRepo;

    public User addUser() {
        User user = new User();
        user.setNumber(0L);
        return userRepo.save(user);
    }

    public synchronized void  incrementUserNumber(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Long number = user.getNumber() + 1;
            user.setNumber(number);
            userRepo.save(user);
        }
        else {
            throw new RuntimeException(String.format("%s:%s", "invalid user id", id));
        }

    }

    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException(String.format("%s:%s", "invalid user id", id));
    }
}
