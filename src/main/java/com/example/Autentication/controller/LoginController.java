package com.example.Autentication.controller;

import com.example.Autentication.entity.Usuario;
import com.example.Autentication.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/auth/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }


    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@ModelAttribute Usuario usuario, Model model){
        model.addAttribute("usuario", iUsuarioService.registrarUsuario(usuario));
        return "redirect:/auth/login";
    }
}
