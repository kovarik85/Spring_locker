package hu.flowacademy.locker.demo.services;

import hu.flowacademy.locker.demo.models.Locker;
import hu.flowacademy.locker.demo.models.Role;
import hu.flowacademy.locker.demo.models.User;
import hu.flowacademy.locker.demo.models.UserDTO;
import hu.flowacademy.locker.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserDTO userDTO){
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .admin(userDTO.isAdmin())
                .build();
        userRepository.save(user);
    }

    public List<User> allUsers(){
       return userRepository.findAll();
    }
  //  public void findByName(UserDTO userDTO){
      // return userRepository.findByName(userDTO.getUsername());
    //}

}
