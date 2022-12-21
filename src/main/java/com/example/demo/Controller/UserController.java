package com.example.demo.Controller;

import com.example.demo.LoginInput;
import com.example.demo.Model.User;
import com.example.demo.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/LoginAndRegister")
public class UserController {


    @Autowired
    UserRepository userdb;

    @GetMapping("")
    public String LoginInput() {
        return "LoginAndRegister/Login";
    }

    @PostMapping("")
    public String loginInput(LoginInput input, Model model, HttpSession session) throws IOException {
        List<User> users = (List<User>) userdb.findAll();
        String url = "";
        for (User user: users ) {

            if (user.getEmail().equals(input.getEmail()) && user.getPassword().equals(input.getPassword())) {
                session.setAttribute("user", user);//  ép kiểu và định dạng
                session.setAttribute("Email", user.getEmail());
                model.addAttribute("name",user.getLastName()+user.getFirstName());
                model.addAttribute("email", user.getEmail());
                model.addAttribute("phone", user.getPhone());
                return "redirect:/Mail";
            }
        }
        return "/LoginAndRegister/Login";
    }

    // SIGN UP
    @GetMapping("/signup")
    public String signup() {
        return "LoginAndRegister/Register";
    }

    @PostMapping("/signup")
    public String signup(User u, Model model) {
        userdb.save(u);
        model.addAttribute("SuccessMessage", "Employee has been add success!");
        return "LoginAndRegister/Register";
    }

}
