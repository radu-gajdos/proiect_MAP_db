package com.map.Controllers;

import org.springframework.stereotype.Controller;
import com.map.Domain.entities.UserEntity;
import com.map.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    @Autowired
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:63342")
    public String login(@RequestParam String username, @RequestParam String password,  Model model) {
        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated) {
            model.addAttribute("userName", username);
            return "redirect:/homepage?username=" + username;
        } else {
            model.addAttribute("loginError", "Login failed");
            return "login+signup";
        }
    }



    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:63342")
    public String getLogin() {
            return "login+signup";
    }

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:63342")
    public String signup(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        if (userService.isUsernameTaken(username)) {
            return "redirect:/signup?error=username_taken";
        }

        UserEntity newUser = new UserEntity(null, username,email, password, null, null, "User", null);
        userService.createUser(newUser);

        return "redirect:/login";
    }
}

