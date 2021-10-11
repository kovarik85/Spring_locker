package hu.flowacademy.locker.demo.repositories;

import hu.flowacademy.locker.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
  //  Optional<User> findByName(String name);

}
