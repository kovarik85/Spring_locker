package hu.flowacademy.locker.demo.services;

import hu.flowacademy.locker.demo.models.Locker;
import hu.flowacademy.locker.demo.models.User;
import hu.flowacademy.locker.demo.models.UserDTO;
import hu.flowacademy.locker.demo.repositories.LockerRepository;
import hu.flowacademy.locker.demo.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private String secret;
    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Autowired
    private final UserRepository userRepository;
    private final LockerRepository lockerRepository;

    public UserService(UserRepository userRepository, LockerRepository lockerRepository) {
        this.userRepository = userRepository;
        this.lockerRepository = lockerRepository;
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }
    public String findByNameAndPassword(UserDTO userDTO){
        return allUsers()
                .stream().filter( n -> userDTO.getUsername().equals(n.getUsername()))
                .filter( n -> userDTO.getPassword().equals(n.getPassword()))
                .toString();

    }
    public void addUser(UserDTO userDTO) throws Exception {
        Locker locker = new Locker();
        lockerRepository.save(locker);
            User user = User.builder()
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .locker(locker)
                    .admin(userDTO.isAdmin())
                    .build();

       if(findbyName(user).isEmpty()){
           System.out.println(user);
           userRepository.save(user);
       }
    }

    public List<User> findbyName(User user){
    return userRepository.findAll()
              .stream().filter( u -> u.getUsername().equals(user.getUsername()))
              .collect(Collectors.toList());
    }

    public void setLocker(UserDTO userDTO){

      User user = userRepository.findByUsername(userDTO.getUsername());
          lockerRepository.findById(user.getLocker().getId()).get().setClosed(true);
          user.getLocker().setClosed(true);
          user.getLocker().setUserIdNumber(user.getId());
          userRepository.save(user);
        System.out.println("Keresett user: " + user);
   }

    public String createJwts(UserDTO userDTO){
        return Jwts.builder()
                .setSubject(findByNameAndPassword(userDTO))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
