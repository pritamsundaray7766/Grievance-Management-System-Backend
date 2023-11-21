package com.example.springbackend.playloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@NoArgsConstructor
@Getter
@Setter
public class AdminDao {
    private long admin_id;

    @Size(min = 4,message = "Admin first_name must be min of 4 characters !!")
    private String first_name;

    @Nullable
    private String middle_name;

    @Size(min = 4,message = "Admin last_name must be min of 4 characters !!")
    private String last_name;


    private String role;


    private int contact;

    @Email(message = "Email Address is not Valid!!")
    private String email;

    @Size(min = 4,message = "User name must be min of 4 characters !!")
    private String user_name;

    @Size(min = 3,max = 8,message = "Password must be min of 3 chars and max of 8 chars !!")
    private String password;


    private String account_status;
}
