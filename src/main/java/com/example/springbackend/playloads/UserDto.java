package com.example.springbackend.playloads;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long user_id;

    @Size(min = 4,message = "User first_name must be min of 4 characters !!")
    private String first_name;
    @Nullable
    private String middle_name;

    @Size(min = 4,message = "User last_name must be min of 4 characters !!")
    private String last_name;

    private long contact;

    @Email(message = "Email Address is not Valid!!")
    private String email;

    @Size(min = 3,max = 8,message = "Password must be min of 3 chars and max of 8 chars !!")
    private String password;
}
