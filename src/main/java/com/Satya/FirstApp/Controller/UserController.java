package com.Satya.FirstApp.Controller;

import com.Satya.FirstApp.Models.User;
import com.Satya.FirstApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserRepository userRepo;

    @PostMapping("/create")
    public String home(@RequestParam(value = "fname", defaultValue = "John") String fname,
                       @RequestParam(value = "lname", defaultValue = "John") String lname,
                       @RequestParam(value = "email", defaultValue = "John") String email,
                       @RequestParam(value = "phone") Long phone) {
        //personName = "Satya";

        User user = new User();
        user.setFname(fname);
        user.setLname(lname);
        user.setPhone(phone);
        user.setEmail(email);

        try {
            userRepo.save(user);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ("Hello World!" + fname);
    }
}
