package hu.flowacademy.locker.demo.models;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotNull
    @Size(min = 12)
    private String username;
    @NotNull
    @Size(min = 12)
    private String password;
    private boolean admin;

}
