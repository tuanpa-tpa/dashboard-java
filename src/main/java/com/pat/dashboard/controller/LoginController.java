package com.pat.dashboard.controller;

import com.pat.dashboard.model.User;
import com.pat.dashboard.service.IUserService;
import com.pat.dashboard.web.dto.UserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class LoginController {

    @Autowired
    private IUserService userService;


    @GetMapping("/login")
    public String login() {
        return "admin/auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("userRegistrationDto", userRegistrationDto);
        return "admin/auth/register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@Valid @ModelAttribute("userRegistrationDto") UserRegistrationDto userRegistrationDto, BindingResult result, Model model) {
        model.addAttribute("userRegistrationDto", userRegistrationDto);
        User user = userService.findByUsername(userRegistrationDto.getUsername());
        if (user != null) {
            return "redirect:/register?username";
        }
        if (result.hasErrors()) {
            return "admin/auth/register";
        }
        userService.save(userRegistrationDto);
        return "redirect:/register?success";
    }
}
