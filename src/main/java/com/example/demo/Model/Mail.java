package com.example.demo.Model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_mail;

    private int Sender;
    private int Receiver;
    private String title;
    private String body;
    private String date;
    private String time;
}
