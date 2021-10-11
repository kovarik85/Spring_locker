package hu.flowacademy.locker.demo.repositories;

import hu.flowacademy.locker.demo.models.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {


}
