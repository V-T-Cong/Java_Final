package com.example.demo.Controller;

import com.example.demo.Model.Mail;
import com.example.demo.Model.MailRepository;
import com.example.demo.Model.User;
import com.example.demo.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Mail")
public class MailController {

    @Autowired
    MailRepository maildb;

    @Autowired
    UserRepository userdb;

    @GetMapping("")
    public String mail(Model model, HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        model.addAttribute("name",user.getLastName()+user.getFirstName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());
        return "Mail/mail";
    }

    @GetMapping("/SendEmail")
    public String send(){
        return "Mail/SendEmail";
    }

    @PostMapping("/SendEmail")
    public String send(@RequestParam("Receiver") String receiver, @RequestParam("title") String title, @RequestParam("body") String body, Mail mail){

        // Id
        int IdReceiver = 0;
        List<User> users = (List<User>) userdb.findAll();
        for(User user : users)
        {
            if(user.getEmail().equals(receiver))
            {
                IdReceiver = user.getId();
                break;
            }
        }
        mail.setReceiver(IdReceiver);


        return "Mail/SendEmail";
    }
}
