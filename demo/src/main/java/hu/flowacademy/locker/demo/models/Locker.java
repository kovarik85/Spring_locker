package hu.flowacademy.locker.demo.models;

import lombok.*;

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
    @Column(unique = true)
    private Long id = (long) Math.floor(Math.random() * 100 + 1);

    private boolean closed;

    @OneToOne
    @JoinColumn
    private User user;
    private Long userIdNumber;

}
