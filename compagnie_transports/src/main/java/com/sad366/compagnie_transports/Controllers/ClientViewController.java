//package com.sad366.compagnie_transports.Controllers;
//
//import com.sad366.compagnie_transports.Implementation.UserImpl;
//import com.sad366.compagnie_transports.Tables.Client;
//import com.sad366.compagnie_transports.Tables.User;
//import org.springframework.ui.Model;
//import com.sad366.compagnie_transports.Implementation.ClientImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//
//
//@Controller
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class ClientViewController {
//
//    private final ClientImpl clientImpl;
//    private final UserImpl userImpl;
//
//
//    @GetMapping("/registerForm")
//    public String addClientForm(Model model) {
//        Client client = new Client();
//        List<User> users = userImpl.getUsers();
//        model.addAttribute("users", users);
//        model.addAttribute("client", client);
//
//        return "registerForm";
//    }
//
//
//    @PostMapping("/register")
//    public String saveClient(Model model, Client client, RedirectAttributes redirectAttributes) {
//        Client client1 = clientImpl.addClient(client);
//        model.addAttribute("client", client1);
//        redirectAttributes.addFlashAttribute("message", "Client enregistré avec succes!");
//        return "redirect:/home";
////    }
////
//}

