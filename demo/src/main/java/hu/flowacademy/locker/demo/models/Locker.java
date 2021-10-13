package hu.flowacademy.locker.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.MathContext;
import java.util.Random;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locker {

    @Id
    private Long id = new Random().nextLong();

    private boolean closed;

    @OneToOne
    @JoinColumn
    private User user;
    private Long userIdNumber;

}
