package hu.flowacademy.locker.demo.services;

import hu.flowacademy.locker.demo.models.Locker;
import hu.flowacademy.locker.demo.repositories.LockerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerService {

    private final LockerRepository lockerRepository;

    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    public List<Locker> allLockers(){
        return lockerRepository.findAll();
    }


}
