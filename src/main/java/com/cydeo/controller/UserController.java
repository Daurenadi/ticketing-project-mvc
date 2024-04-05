package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

@GetMapping("/user/create")
    public String createUser(Model model){

    model.addAttribute("user", new UserDTO());

        return "user/create";
    }

}
