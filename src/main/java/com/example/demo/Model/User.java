package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String FirstName;
    private String LastName;
    @Column(name = "Emailaddress", unique = true)
    private String Email;
    private String Phone;
    private String Password;
}
