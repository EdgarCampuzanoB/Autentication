package com.example.Autentication.services;

import com.example.Autentication.entity.Usuario;
import com.example.Autentication.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements IUsuarioService{

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario findByUsername(String username) {
        return null;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return usuarioDao.save(usuario);
    }
}
