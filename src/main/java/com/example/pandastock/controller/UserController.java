package com.example.pandastock.controller;

import com.example.pandastock.repository.UserRepository;
import com.example.pandastock.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //INJEÇÃO DE DEPENDÊNCIAS
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    //RequestParam = Pegue o valor chamado pin que veio na requisição HTTP e coloque na variável pin.
    public boolean login(@RequestParam String pin) {
        return userService.login(pin);
    }

}
