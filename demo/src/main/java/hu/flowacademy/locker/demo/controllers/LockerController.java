package hu.flowacademy.locker.demo.controllers;

import hu.flowacademy.locker.demo.models.Locker;
import hu.flowacademy.locker.demo.services.LockerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locker")
public class LockerController {

    private final LockerService lockerService;

    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    @GetMapping("/")
        public List<Locker> allLockers(){
            return lockerService.allLockers();
        }
    }


