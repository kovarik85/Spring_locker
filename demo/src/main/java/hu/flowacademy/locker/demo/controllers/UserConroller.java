package hu.flowacademy.locker.demo.controllers;

import hu.flowacademy.locker.demo.models.User;
import hu.flowacademy.locker.demo.models.UserDTO;
import hu.flowacademy.locker.demo.services.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserConroller {

    @Autowired
    private final UserService userService;

    public UserConroller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return "User added successfully!!";
    }

    @PostMapping("/login")
    public String loginUser(UserDTO userDTO){
        return userService.createJwts(userDTO);
    }



    @GetMapping("/")
    public List<User> allUsers(){
        return userService.allUsers();
    }




}
