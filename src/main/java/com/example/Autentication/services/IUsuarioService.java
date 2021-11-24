package com.example.Autentication.services;

import com.example.Autentication.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {
    public Usuario findByUsername(String username);
    public Usuario registrarUsuario(Usuario usuario);
}
