package com.example.demo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginInput {
    private String email;
    private String password;
}
