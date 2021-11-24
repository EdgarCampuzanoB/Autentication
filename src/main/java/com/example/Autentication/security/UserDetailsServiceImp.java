package com.example.Autentication.security;

import com.example.Autentication.entity.Usuario;
import com.example.Autentication.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        User.UserBuilder userBuilder = null;
        if(usuario != null){
            userBuilder = User.withUsername(username);
            userBuilder.disabled(false);
            userBuilder.password(usuario.getPassword());
            userBuilder.authorities(new SimpleGrantedAuthority("USER"));
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return userBuilder.build();
    }
}
