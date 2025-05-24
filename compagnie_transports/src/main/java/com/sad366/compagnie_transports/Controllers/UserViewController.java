package com.sad366.compagnie_transports.Controllers;

import com.sad366.compagnie_transports.Implementation.UserImpl;
import com.sad366.compagnie_transports.Tables.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserViewController {

    private final UserImpl userImpl;


    @GetMapping("/register")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registerForm";
    }


    @PostMapping("/register")
    public String saveUser(Model model, User user, RedirectAttributes redirectAttributes) {
        User user1 = userImpl.addUser(user);
        model.addAttribute("user", user1);
        redirectAttributes.addFlashAttribute("message", "User enregistré avec succes!");
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String home() {
        return "home"; // Assure-toi d’avoir un fichier home.html dans templates/
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Assure-toi d’avoir un fichier home.html dans templates/
    }
    @PostMapping("/login")
    public String saveUser() {

        // traitement du login
        return "redirect:/registerform";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalide la session en cours
        return "redirect:/login?logout";




}
}
