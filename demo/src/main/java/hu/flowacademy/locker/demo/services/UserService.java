package hu.flowacademy.locker.demo.services;


import hu.flowacademy.locker.demo.models.User;
import hu.flowacademy.locker.demo.models.UserDTO;
import hu.flowacademy.locker.demo.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.jsonwebtoken.impl.crypto.MacProvider.generateKey;


@Service
public class UserService {

    private String secret;
    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

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
    public String findByName(UserDTO userDTO){
       return allUsers()
                .stream().filter( n -> userDTO.getUsername().equals(n.getUsername()))
               .filter( n -> userDTO.getPassword().equals(n.getPassword()))
                .toString();
    }
    public String createJwts(UserDTO userDTO){
        return Jwts.builder()
                .setSubject(findByName(userDTO))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


}
