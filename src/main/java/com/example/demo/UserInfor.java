package com.example.demo;

import com.example.demo.Model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UserInfor {
    private static User Usercurrent;

    public static User getUsercurrent () {
        return Usercurrent;
    }

    public static void setUsercurrent (User user) {
        UserInfor.Usercurrent = user;
    }
}
