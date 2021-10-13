package hu.flowacademy.locker.demo.controllers;

import hu.flowacademy.locker.demo.models.User;
import hu.flowacademy.locker.demo.models.UserDTO;
import hu.flowacademy.locker.demo.services.LockerService;
import hu.flowacademy.locker.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserConroller {

    @Autowired
    private final UserService userService;
    private final LockerService lockerService;

    public UserConroller(UserService userService, LockerService lockerService) {
        this.userService = userService;
        this.lockerService = lockerService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDTO userDTO) throws Exception {
        userService.addUser(userDTO);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserDTO userDTO){
        userService.setLocker(userDTO);
        return userService.createJwts(userDTO);
    }



    @GetMapping("/")
    public List<User> allUsers(){
        return userService.allUsers();
    }




}
