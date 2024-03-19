package org.reis.itacademychallenge.controller;

import org.apache.catalina.User;
import org.reis.itacademychallenge.dtos.BetDTO;
import org.reis.itacademychallenge.dtos.UserDTO;
import org.reis.itacademychallenge.service.BetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.reis.itacademychallenge.service.UserService;
import org.reis.itacademychallenge.entity.UserEntity;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BetService betService;

    @PostMapping()
    public void registerBet(@RequestBody UserDTO userDto){
        userService.saveUser(userDto);
    }

    @GetMapping("/game")
    public Boolean startBets(){
        return betService.startGame();
    }

    @PostMapping("/addBet")
    public UserEntity addBet(@RequestBody BetDTO bet, @RequestParam("cpf") String cpf) {
        return userService.addBet(bet, cpf);
    }
    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/deleteAll")
    public void deleteAllUsers(){
        userService.deleteAll();
    }
    @GetMapping("/cpf")
    public UserEntity getByCpf(){
        return userService.findByCpf("157");
    }
}
