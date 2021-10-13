package hu.flowacademy.locker.demo.repositories;

import hu.flowacademy.locker.demo.models.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LockerRepository extends JpaRepository<Locker, Long> {
        List<Locker> findAll();
}
