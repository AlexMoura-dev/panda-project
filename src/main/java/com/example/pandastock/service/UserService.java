package com.example.pandastock.service;

import com.example.pandastock.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //INJEÇÃO DE DEPENDÊNCIAS
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //LOGIN -> true ou false
    public boolean login(String pin) {
        return userRepository.findByPin(pin).isPresent();
    }

}
