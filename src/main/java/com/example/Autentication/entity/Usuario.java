package com.example.Autentication.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuarios")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer idusuario;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private Integer edad;
    private String mail;
    private String telefono;
    private String username;
    private String password;

    private static final long serialVersionUID = 1L;


}