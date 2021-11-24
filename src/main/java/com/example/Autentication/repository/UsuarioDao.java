package com.example.Autentication.repository;

import com.example.Autentication.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
    public Usuario findByUsername(String username);
}